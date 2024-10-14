#!/bin/bash
password=$(head -n 1 secrets/.psql.pass)

python scripts/build_projectdb.py

rm -r output
mkdir output
cd output

# Очистка папки project/warehouse в HDFS
hdfs dfs -rm -r -f project/warehouse

sqoop import-all-tables \
 --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team38_projectdb \
 --username team38 \
 --password $password  \
 --compression-codec=snappy \
 --compress \
 --as-avrodatafile \
 --warehouse-dir=project/warehouse \
 --m 1

cd ..