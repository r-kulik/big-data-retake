"""
This module trains Linear Regression and Grafient Boosting Tree Regressor to obtain models for data
"""


from pyspark.sql import SparkSession
from pyspark.ml.regression import LinearRegression, GBTRegressor
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.tuning import TrainValidationSplit, ParamGridBuilder
from pyspark.sql.functions import abs as abs_fun, col, mean
from pyspark.ml.feature import StringIndexer, OneHotEncoder, VectorAssembler, StandardScaler
from pyspark.ml import Pipeline
from pyspark.sql.functions import rand

# Initialize Spark Session
print("Initializing Spark Session...")
spark = SparkSession.builder \
    .appName("team38 - spark ML") \
    .master("yarn") \
    .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883") \
    .config("spark.sql.warehouse.dir", "project/hive/warehouse") \
    .config("spark.sql.avro.compression.codec", "snappy") \
    .enableHiveSupport() \
    .getOrCreate()

# Load and Prepare Data
print("Loading and preparing data...")
spark.sql("USE team38_projectdb")
df = spark.sql("""
    SELECT 
        price, 
        minutes_to_metro, 
        number_of_rooms, 
        area, 
        living_area, 
        kitchen_area, 
        apartment_floor, 
        number_of_floors, 
        apartment_type_name, 
        region_name, 
        renovation_name, 
        metro_station_latitude, 
        metro_station_longitude 
    FROM 
        housing_data_part_buck
""")

# Split the data into train and test sets
print("Splitting data into train and test sets...")
train_data, test_data = df.orderBy(rand(seed=42)).randomSplit([0.8, 0.2], seed=42)

# Feature Engineering and Pipeline
print("Performing feature engineering and creating pipeline...")
categorical_columns = [
    'apartment_type_name',
    'region_name',
    'renovation_name'
]
numeric_columns = [
    'minutes_to_metro',
    'number_of_rooms',
    'area',
    'living_area',
    'kitchen_area',
    'apartment_floor',
    'number_of_floors',
    'metro_station_latitude',
    'metro_station_longitude'
]

indexers = [
    StringIndexer(
        inputCol=col, outputCol=col + "_index", handleInvalid="keep"
    ) for col in categorical_columns
]
encoders = [
    OneHotEncoder(
        inputCol=col + "_index", outputCol=col + "_encoded"
    ) for col in categorical_columns
]

train_data = train_data.withColumn("living_area_ratio", col("living_area") / col("area"))
test_data = test_data.withColumn("living_area_ratio", col("living_area") / col("area"))

numeric_columns.append("living_area_ratio")

assembler_inputs = [col + "_encoded" for col in categorical_columns] + numeric_columns
assembler = VectorAssembler(inputCols=assembler_inputs, outputCol="features")
scaler = StandardScaler(
    inputCol="features", outputCol="scaled_features", withStd=True, withMean=True
)

pipeline = Pipeline(stages=indexers + encoders + [assembler, scaler])
model = pipeline.fit(train_data)

train_data = model.transform(train_data)
test_data = model.transform(test_data)

train_data = train_data.select("scaled_features", "price")
test_data = test_data.select("scaled_features", "price")

train_data = train_data.withColumnRenamed("price", "label")
test_data = test_data.withColumnRenamed("price", "label")

# Train and Evaluate Linear Regression Model
print("Training and evaluating Linear Regression model...")
lr = LinearRegression(featuresCol="scaled_features", labelCol="label")
paramGrid = ParamGridBuilder() \
    .addGrid(lr.regParam, [0.1, 0.01]) \
    .addGrid(lr.elasticNetParam, [0.0, 0.5, 1.0]) \
    .build()

tvs = TrainValidationSplit(estimator=lr,
                           estimatorParamMaps=paramGrid,
                           evaluator=RegressionEvaluator(
                               labelCol="label", predictionCol="prediction", metricName="rmse"
                            ),
                           trainRatio=0.8)

lr_model = tvs.fit(train_data)
lr_model.bestModel.write().overwrite().save("project/models/model1")

predictions = lr_model.transform(test_data)
predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("header", "true")\
    .save("project/output/model1_predictions")

evaluator_rmse = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="rmse"
)
evaluator_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")
evaluator_mae = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="mae")

rmse1 = evaluator_rmse.evaluate(predictions)
r21 = evaluator_r2.evaluate(predictions)
mae1 = evaluator_mae.evaluate(predictions)

predictions = predictions.withColumn(
    "APE", abs_fun((col("label") - col("prediction")) / col("label"))
)
mape1 = predictions.select(mean("APE")).collect()[0][0] * 100

print("Linear Regression Model Evaluation:")
print(f"Root Mean Squared Error (RMSE): {rmse1}")
print(f"R^2: {r21}")
print(f"Mean Absolute Error (MAE): {mae1}")
print(f"Mean Absolute Percentage Error (MAPE): {mape1}")

# Train and Evaluate GBT Model
print("Training and evaluating GBT model... This may take a while")
gbt = GBTRegressor(featuresCol="scaled_features", labelCol="label")
# Step 2: Create a parameter grid for grid search
paramGrid = ParamGridBuilder() \
    .addGrid(gbt.maxDepth, [2, 4]) \
    .addGrid(gbt.maxIter, [3, 5]) \
    .build()

tvs = TrainValidationSplit(estimator=gbt,
                           estimatorParamMaps=paramGrid,
                           evaluator=RegressionEvaluator(
                               labelCol="label", predictionCol="prediction", metricName="rmse"
                            ),
                           trainRatio=0.8)

gbt_model = tvs.fit(train_data)
gbt_model.bestModel.write().overwrite().save("project/models/model2")

predictions = gbt_model.transform(test_data)
predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("header", "true")\
    .save("project/output/model2_predictions")

evaluator_rmse = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="rmse"
)
evaluator_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")
evaluator_mae = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="mae")

rmse2 = evaluator_rmse.evaluate(predictions)
r22 = evaluator_r2.evaluate(predictions)
mae2 = evaluator_mae.evaluate(predictions)

predictions = predictions.withColumn(
    "APE", abs_fun((col("label") - col("prediction")) / col("label"))
)
mape2 = predictions.select(mean("APE")).collect()[0][0] * 100

print("GBT Model Evaluation:")
print(f"Root Mean Squared Error (RMSE): {rmse2}")
print(f"R^2: {r22}")
print(f"Mean Absolute Error (MAE): {mae2}")
print(f"Mean Absolute Percentage Error (MAPE): {mape2}")

# Create DataFrame for Model Comparison
print("Creating DataFrame for model comparison...")
models = [
    ["Linear Regression", rmse1, r21, mae1, mape1],
    ["GBT", rmse2, r22, mae2, mape2]
]

df = spark.createDataFrame(models, ["model", "RMSE", "R2", "MAE", "MAPE"])
df.show(truncate=False)

# Save Model Comparison to HDFS
print("Saving model comparison to HDFS...")
df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/evaluation.csv")

# Stop Spark Session
print("Stopping Spark Session...")
spark.stop()
