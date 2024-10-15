USE team38_projectdb;

DROP TABLE IF EXISTS q2_results;

-- Query 2: Show the average price of the meter squared depending on the distance from the center (Use Euclidean distance). Group Data into 10 buckets depending on the distance
CREATE TABLE q2_results AS
SELECT
    CASE
        WHEN distance_from_center <= 0.1 THEN '0.0 - 0.1'
        WHEN distance_from_center <= 0.2 THEN '0.1 - 0.2'
        WHEN distance_from_center <= 0.3 THEN '0.2 - 0.3'
        WHEN distance_from_center <= 0.4 THEN '0.3 - 0.4'
        WHEN distance_from_center <= 0.5 THEN '0.4 - 0.5'
        WHEN distance_from_center <= 0.6 THEN '0.5 - 0.6'
        WHEN distance_from_center <= 0.7 THEN '0.6 - 0.7'
        WHEN distance_from_center <= 0.8 THEN '0.7 - 0.8'
        WHEN distance_from_center <= 0.9 THEN '0.8 - 0.9'
        ELSE '0.9 - 1.0'
    END AS distance_in_degrees,
    AVG(price / area) AS mean_m2_price
FROM (
    SELECT
        price,
        area,
        SQRT(POW(metro_station_latitude - 55.7522, 2) + POW(metro_station_longitude - 37.6156, 2)) AS distance_from_center
    FROM housing_data_part_buck
) t
GROUP BY 
    CASE
        WHEN distance_from_center <= 0.1 THEN '0.0 - 0.1'
        WHEN distance_from_center <= 0.2 THEN '0.1 - 0.2'
        WHEN distance_from_center <= 0.3 THEN '0.2 - 0.3'
        WHEN distance_from_center <= 0.4 THEN '0.3 - 0.4'
        WHEN distance_from_center <= 0.5 THEN '0.4 - 0.5'
        WHEN distance_from_center <= 0.6 THEN '0.5 - 0.6'
        WHEN distance_from_center <= 0.7 THEN '0.6 - 0.7'
        WHEN distance_from_center <= 0.8 THEN '0.7 - 0.8'
        WHEN distance_from_center <= 0.9 THEN '0.8 - 0.9'
        ELSE '0.9 - 1.0'
    END;