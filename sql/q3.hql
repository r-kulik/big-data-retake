USE team38_projectdb;

-- Query 3: Find the average price of the meter squared depending on the minutes_to_metro. Group data into 10 buckets depending on the minutes_to_metro
CREATE TABLE q3_results AS
SELECT
    CASE
        WHEN minutes_to_metro <= 2 THEN '0-2'
        WHEN minutes_to_metro <= 4 THEN '2-4'
        WHEN minutes_to_metro <= 6 THEN '4-6'
        WHEN minutes_to_metro <= 8 THEN '6-8'
        WHEN minutes_to_metro <= 10 THEN '8-10'
        WHEN minutes_to_metro <= 12 THEN '10-12'
        WHEN minutes_to_metro <= 14 THEN '12-14'
        WHEN minutes_to_metro <= 16 THEN '14-16'
        WHEN minutes_to_metro <= 18 THEN '16-18'
        ELSE '18-20'
    END AS distance_to_metro,
    AVG(price / area) AS mean_m2_price
FROM housing_data_part_buck
GROUP BY 
    CASE
        WHEN minutes_to_metro <= 2 THEN '0-2'
        WHEN minutes_to_metro <= 4 THEN '2-4'
        WHEN minutes_to_metro <= 6 THEN '4-6'
        WHEN minutes_to_metro <= 8 THEN '6-8'
        WHEN minutes_to_metro <= 10 THEN '8-10'
        WHEN minutes_to_metro <= 12 THEN '10-12'
        WHEN minutes_to_metro <= 14 THEN '12-14'
        WHEN minutes_to_metro <= 16 THEN '14-16'
        WHEN minutes_to_metro <= 18 THEN '16-18'
        ELSE '18-20'
    END;