

SELECT A.CAR_ID, A.CAR_TYPE, ROUND(A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE)/100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS A 
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS B ON A.CAR_ID = B.CAR_ID 
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS C ON C.CAR_TYPE = A.CAR_TYPE
WHERE C.DURATION_TYPE = '30일 이상'
AND B.CAR_ID NOT IN (SELECT CAR_ID
                   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                   WHERE !(END_DATE <= '2022-11-01' OR START_DATE > '2022-11-30'))
AND (A.CAR_TYPE = 'SUV' OR A.CAR_TYPE = '세단')
GROUP BY A.CAR_ID
HAVING FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID DESC