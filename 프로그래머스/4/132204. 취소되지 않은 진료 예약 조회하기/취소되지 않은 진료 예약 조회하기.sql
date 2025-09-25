SELECT
    A.APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    A.MCDP_CD,
    D.DR_NAME,
    A.APNT_YMD
FROM
    DOCTOR D
JOIN (
        SELECT
            *
        FROM
            APPOINTMENT
        WHERE
            APNT_CNCL_YN = 'N'
            AND DATE(APNT_YMD) = '2022-04-13'
            AND MCDP_CD = 'CS'
    ) AS A ON D.DR_ID = A.MDDR_ID
JOIN PATIENT P ON P.PT_NO = A.PT_NO
ORDER BY A.APNT_YMD