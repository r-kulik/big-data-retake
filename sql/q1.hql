USE team38_projectdb;


DROP TABLE IF EXISTS q1_results;
-- Query 1: Find the mean price for the meter squared (price of the apartment divided by its area) in both regions depending on the renovation_type
CREATE TABLE q1_results AS
SELECT
    renovation_name,
    AVG(price / area) AS mean_m2_price
FROM housing_data_part_buck
GROUP BY renovation_name;