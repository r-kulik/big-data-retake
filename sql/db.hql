-- Drop the database if it exists to ensure a clean start
DROP DATABASE IF EXISTS team38_projectdb CASCADE;

-- Create the database
CREATE DATABASE team38_projectdb LOCATION "project/hive/warehouse";

-- Use the newly created database
USE team38_projectdb;

-- apartment_types table
CREATE EXTERNAL TABLE apartment_types
STORED AS AVRO
LOCATION 'project/warehouse/apartment_types'
TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/apartment_types.avsc');

-- housing_data table
CREATE EXTERNAL TABLE housing_data
STORED AS AVRO
LOCATION 'project/warehouse/housing_data'
TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/housing_data.avsc');

-- metro_stations table
CREATE EXTERNAL TABLE metro_stations
STORED AS AVRO
LOCATION 'project/warehouse/metro_stations'
TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/metro_stations.avsc');

-- regions table
CREATE EXTERNAL TABLE regions
STORED AS AVRO
LOCATION 'project/warehouse/regions'
TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/regions.avsc');

-- renovations table
CREATE EXTERNAL TABLE renovations
STORED AS AVRO
LOCATION 'project/warehouse/renovations'
TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/renovations.avsc');

-- Create the partitioned and bucketed table housing_data_part_buck
CREATE TABLE housing_data_part_buck (
    id INT,
    price FLOAT,
    apartment_type_id INT,
    metro_station_id INT,
    minutes_to_metro FLOAT,
    number_of_rooms FLOAT,
    area FLOAT,
    living_area FLOAT,
    kitchen_area FLOAT,
    apartment_floor FLOAT,
    number_of_floors FLOAT,
    renovation_id INT,
    apartment_type_name STRING,
    metro_station_name STRING,
    region_name STRING,
    renovation_name STRING,
    metro_station_latitude FLOAT,
    metro_station_longitude FLOAT
)
PARTITIONED BY (region_id INT)
CLUSTERED BY (area) INTO 5 BUCKETS
STORED AS ORC;

-- Set dynamic partition mode to nonstrict
SET hive.exec.dynamic.partition.mode=nonstrict;

-- Insert data into the partitioned and bucketed table
INSERT INTO TABLE housing_data_part_buck PARTITION (region_id)
SELECT
    hd.id,
    hd.price,
    hd.apartment_type_id,
    hd.metro_station_id,
    hd.minutes_to_metro,
    hd.number_of_rooms,
    hd.area,
    hd.living_area,
    hd.kitchen_area,
    hd.apartment_floor,
    hd.number_of_floors,
    hd.renovation_id,
    at.name AS apartment_type_name,
    ms.name AS metro_station_name,
    r.name AS region_name,
    rn.name AS renovation_name,
    ms.latitude AS metro_station_latitude,
    ms.longitude AS metro_station_longitude,
    hd.region_id
FROM housing_data hd
JOIN apartment_types at ON hd.apartment_type_id = at.id
JOIN metro_stations ms ON hd.metro_station_id = ms.id
JOIN regions r ON hd.region_id = r.id
JOIN renovations rn ON hd.renovation_id = rn.id;

-- Drop all unpartitioned tables
DROP TABLE IF EXISTS housing_data;
DROP TABLE IF EXISTS apartment_types;
DROP TABLE IF EXISTS metro_stations;
DROP TABLE IF EXISTS regions;
DROP TABLE IF EXISTS renovations;

-- Show tables to verify the creation
SHOW TABLES;