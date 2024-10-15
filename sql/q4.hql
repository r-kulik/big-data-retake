USE team38_projectdb;


DROP TABLE IF EXISTS q4_results;
-- Query 4: Find the distribution of apartment_floor variable among all available apartments
CREATE TABLE q4_results AS
SELECT
    apartment_floor,
    COUNT(*) AS count
FROM housing_data_part_buck
GROUP BY apartment_floor;