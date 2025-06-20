SELECT
    FLOOR (PRICE / 10000) * 10000 AS PRICE_GROUP,
    COUNT(*) AS PRODUCTS
FROM
    PRODUCT 
WHERE
    PRICE
GROUP BY
    FLOOR (PRICE / 10000) * 10000
ORDER BY
    PRICE_GROUP;