SELECT
    B.S AS SCORE,
    A.EMP_NO,
    A.EMP_NAME,
    A.POSITION,
    A.EMAIL
FROM
    HR_EMPLOYEES A INNER JOIN (
        SELECT 
            EMP_NO,
            SUM(SCORE) AS S
        FROM
            HR_GRADE
        GROUP BY
            EMP_NO
        ORDER BY
            S DESC
        LIMIT 1
        ) B
ON
    A.EMP_NO = B.EMP_NO;