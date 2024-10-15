#!/bin/bash

# Create the directory if it does not exist
hdfs dfs -mkdir -p project/warehouse/avsc

# Remove existing files in the avsc folder
hdfs dfs -rm -f project/warehouse/avsc/*.avsc

# Copy new files to the avsc folder
hdfs dfs -put output/*.avsc project/warehouse/avsc

password=$(head -n 1 secrets/.hive.pass)
# beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/db.hql > output/hive_results.txt

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q1.hql
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q1_export.hql --outputformat=csv2 --silent> output/q1.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q2.hql
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q2_export.hql --outputformat=csv2 --silent > output/q2.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q3.hql
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q3_export.hql --outputformat=csv2 --silent > output/q3.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q4.hql
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q4_export.hql --outputformat=csv2 --silent > output/q4.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q5.hql
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team38 -p $password -f sql/q5_export.hql --outputformat=csv2 --silent > output/q5.csv

python3 scripts/create_hist.py