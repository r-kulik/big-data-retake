BEGIN;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS raw CASCADE;
DROP TABLE IF EXISTS raw_geo CASCADE;
DROP TABLE IF EXISTS housing_data CASCADE;
DROP TABLE IF EXISTS apartment_types CASCADE;
DROP TABLE IF EXISTS metro_stations CASCADE;
DROP TABLE IF EXISTS regions CASCADE;
DROP TABLE IF EXISTS renovations CASCADE;

-- Create raw table to store initial data
CREATE TABLE raw (
    price FLOAT NOT NULL,
    apartment_type VARCHAR(50) NOT NULL,
    metro_station VARCHAR(100) NOT NULL,
    minutes_to_metro FLOAT NOT NULL,
    region VARCHAR(100) NOT NULL,
    number_of_rooms FLOAT NOT NULL,
    area FLOAT NOT NULL,
    living_area FLOAT NOT NULL,
    kitchen_area FLOAT NOT NULL,
    floor FLOAT NOT NULL,
    number_of_floors FLOAT NOT NULL,
    renovation VARCHAR(50) NOT NULL
);

-- Create raw_geo table to store initial geo data
CREATE TABLE raw_geo (
    name VARCHAR(100) NOT NULL,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL
);

-- Create table for apartment types
CREATE TABLE apartment_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- Create table for metro stations
CREATE TABLE metro_stations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    latitude FLOAT,
    longitude FLOAT
);

-- Create table for regions
CREATE TABLE regions (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

-- Create table for renovations
CREATE TABLE renovations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- Create the main table to store housing data
CREATE TABLE housing_data (
    id SERIAL PRIMARY KEY,
    price FLOAT NOT NULL,
    apartment_type_id INT REFERENCES apartment_types(id),
    metro_station_id INT REFERENCES metro_stations(id),
    minutes_to_metro FLOAT NOT NULL,
    region_id INT REFERENCES regions(id),
    number_of_rooms FLOAT NOT NULL,
    area FLOAT NOT NULL,
    living_area FLOAT NOT NULL,
    kitchen_area FLOAT NOT NULL,
    floor FLOAT NOT NULL,
    number_of_floors FLOAT NOT NULL,
    renovation_id INT REFERENCES renovations(id)
);

COMMIT;