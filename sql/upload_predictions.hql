USE team38_projectdb;

-- Create external table for model1_predictions.csv
CREATE EXTERNAL TABLE model1_predictions (
    label DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION 'hdfs:///user/team38/project/output/model1_predictions';

-- Create external table for model2_predictions.csv
CREATE EXTERNAL TABLE model2_predictions (
    label DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION 'hdfs:///user/team38/project/output/model2_predictions';

-- Create external table for evaluation.csv
CREATE EXTERNAL TABLE evaluation (
    model STRING,
    RMSE DOUBLE,
    R2 DOUBLE,
    MAE DOUBLE,
    MAPE DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION 'hdfs:///user/team38/project/output/evaluation.csv';