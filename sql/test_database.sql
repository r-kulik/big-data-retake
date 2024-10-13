BEGIN;

-- Check if apartment_types table has data
SELECT COUNT(*) FROM apartment_types;

-- Check if metro_stations table has data
SELECT COUNT(*) FROM metro_stations;

-- Check if regions table has data
SELECT COUNT(*) FROM regions;

-- Check if renovations table has data
SELECT COUNT(*) FROM renovations;

-- Check if housing_data table has data
SELECT COUNT(*) FROM housing_data;

-- Check constraints in housing_data table
SELECT * FROM housing_data WHERE price <= 0;
SELECT * FROM housing_data WHERE minutes_to_metro < 0;
SELECT * FROM housing_data WHERE area <= 0;
SELECT * FROM housing_data WHERE living_area < 0;
SELECT * FROM housing_data WHERE kitchen_area < 0;
SELECT * FROM housing_data WHERE number_of_floors <= 0;

-- Check constraints in metro_stations table
SELECT * FROM metro_stations WHERE latitude IS NULL OR longitude IS NULL;
SELECT * FROM metro_stations WHERE latitude < -90 OR latitude > 90;
SELECT * FROM metro_stations WHERE longitude < -180 OR longitude > 180;

COMMIT;