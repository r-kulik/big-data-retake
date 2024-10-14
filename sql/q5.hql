USE team38_projectdb;

-- Query 5: Fetch dependencies between the location of the floor and price per meter squared
CREATE TABLE q5_results AS
SELECT
    CASE
        WHEN relative_floor_location <= 0.1 THEN '0.0 - 0.1'
        WHEN relative_floor_location <= 0.2 THEN '0.1 - 0.2'
        WHEN relative_floor_location <= 0.3 THEN '0.2 - 0.3'
        WHEN relative_floor_location <= 0.4 THEN '0.3 - 0.4'
        WHEN relative_floor_location <= 0.5 THEN '0.4 - 0.5'
        WHEN relative_floor_location <= 0.6 THEN '0.5 - 0.6'
        WHEN relative_floor_location <= 0.7 THEN '0.6 - 0.7'
        WHEN relative_floor_location <= 0.8 THEN '0.7 - 0.8'
        WHEN relative_floor_location <= 0.9 THEN '0.8 - 0.9'
        ELSE '0.9 - 1.0'
    END AS apartment_relative_to_building_height,
    AVG(price / area) AS mean_m2_price
FROM (
    SELECT
        price,
        area,
        apartment_floor / number_of_floors AS relative_floor_location
    FROM housing_data_part_buck
) t
GROUP BY 
    CASE
        WHEN relative_floor_location <= 0.1 THEN '0.0 - 0.1'
        WHEN relative_floor_location <= 0.2 THEN '0.1 - 0.2'
        WHEN relative_floor_location <= 0.3 THEN '0.2 - 0.3'
        WHEN relative_floor_location <= 0.4 THEN '0.3 - 0.4'
        WHEN relative_floor_location <= 0.5 THEN '0.4 - 0.5'
        WHEN relative_floor_location <= 0.6 THEN '0.5 - 0.6'
        WHEN relative_floor_location <= 0.7 THEN '0.6 - 0.7'
        WHEN relative_floor_location <= 0.8 THEN '0.7 - 0.8'
        WHEN relative_floor_location <= 0.9 THEN '0.8 - 0.9'
        ELSE '0.9 - 1.0'
    END;