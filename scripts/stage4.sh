#!/bin/bash
password=$(head -n 1 secrets/.hive.pass)

echo "Uploading files to Database thorugh beeline"
# Define the Beeline connection string
BEELINE_URL="jdbc:hive2://hadoop-03.uni.innopolis.ru:10001"

# Define the username and password
USERNAME="team38"
PASSWORD="$password"  # Ensure this is set in your environment or replace with the actual password

# Run the HiveQL script using Beeline
beeline -u $BEELINE_URL -n $USERNAME -p $PASSWORD -f sql/upload_predictions.hql

echo "Files uploaded"