#!/bin/bash

# Run the Python script using Spark with YARN and redirect stderr to /dev/null
spark-submit --master yarn --deploy-mode client scripts/model_train.py 2>/dev/null

# Check if the script ran successfully
if [ $? -eq 0 ]; then
    # Define the output directory and files
    output_dir="output"
    model1_predictions="$output_dir/model1_predictions.csv"
    model2_predictions="$output_dir/model2_predictions.csv"
    evaluation_csv="$output_dir/evaluation.csv"

    # Check if the output directory exists, if not, create it
    if [ ! -d "$output_dir" ]; then
        mkdir -p "$output_dir"
    fi

    # Check if the files exist and delete them if they do
    if [ -f "$model1_predictions" ]; then
        rm "$model1_predictions"
    fi
    if [ -f "$model2_predictions" ]; then
        rm "$model2_predictions"
    fi
    if [ -f "$evaluation_csv" ]; then
        rm "$evaluation_csv"
    fi

    # Download model predictions and evaluation results from HDFS to local system
    hdfs dfs -get project/output/model1_predictions/*.csv "$model1_predictions"
    hdfs dfs -get project/output/model2_predictions/*.csv "$model2_predictions"
    hdfs dfs -get project/output/evaluation.csv/*.csv "$evaluation_csv"

    echo "Model predictions and evaluation results downloaded to output directory."
else
    echo "Failed to run the Python script."
fi