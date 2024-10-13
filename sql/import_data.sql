BEGIN;

-- Import data into raw_geo table
COPY raw_geo (name, latitude, longitude)
FROM STDIN DELIMITER ',' CSV HEADER QUOTE '"' ESCAPE '''';

-- Import data into raw table
COPY raw (price, apartment_type, metro_station, minutes_to_metro, region, number_of_rooms, area, living_area, kitchen_area, floor, number_of_floors, renovation)
FROM STDIN DELIMITER ',' CSV HEADER QUOTE '"' ESCAPE '''';

-- Insert unique apartment types into apartment_types table
INSERT INTO apartment_types (name)
SELECT DISTINCT apartment_type FROM raw
ON CONFLICT (name) DO NOTHING;

-- Insert unique metro stations into metro_stations table
INSERT INTO metro_stations (name)
SELECT DISTINCT LOWER(TRIM(metro_station)) FROM raw
ON CONFLICT (name) DO NOTHING;

-- Insert unique regions into regions table
INSERT INTO regions (name)
SELECT DISTINCT region FROM raw
ON CONFLICT (name) DO NOTHING;

-- Insert unique renovations into renovations table
INSERT INTO renovations (name)
SELECT DISTINCT renovation FROM raw
ON CONFLICT (name) DO NOTHING;

-- Insert data into metro_stations table from raw_geo
INSERT INTO metro_stations (name, latitude, longitude)
SELECT DISTINCT LOWER(TRIM(rg.name)), rg.latitude, rg.longitude
FROM raw_geo rg
ON CONFLICT (name) DO UPDATE SET latitude = EXCLUDED.latitude, longitude = EXCLUDED.longitude;

-- Insert data into housing_data table
INSERT INTO housing_data (price, apartment_type_id, metro_station_id, minutes_to_metro, region_id, number_of_rooms, area, living_area, kitchen_area, floor, number_of_floors, renovation_id)
SELECT
    r.price,
    at.id AS apartment_type_id,
    ms.id AS metro_station_id,
    r.minutes_to_metro,
    reg.id AS region_id,
    r.number_of_rooms,
    r.area,
    r.living_area,
    r.kitchen_area,
    r.floor,
    r.number_of_floors,
    ren.id AS renovation_id
FROM raw r
JOIN apartment_types at ON r.apartment_type = at.name
JOIN metro_stations ms ON LOWER(TRIM(r.metro_station)) = ms.name
JOIN regions reg ON r.region = reg.name
JOIN renovations ren ON r.renovation = ren.name;

-- Drop raw and raw_geo tables after data has been successfully imported
DROP TABLE raw;
DROP TABLE raw_geo;

COMMIT;