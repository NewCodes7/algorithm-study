SELECT HISTORY_ID, TRUNCATE((DAILY_FEE 
                             * (DATEDIFF(END_DATE, START_DATE) + 1) 
                             * (100 - (CASE
                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90
                    THEN (SELECT DISCOUNT_RATE
                          FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                          WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '90일 이상')
                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30
                    THEN (SELECT DISCOUNT_RATE
                          FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                          WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '30일 이상')
                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 7
                    THEN (SELECT DISCOUNT_RATE
                          FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                          WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '7일 이상')
                    ELSE 0
                   END))/100), 0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR A 
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B ON A.CAR_ID = B.CAR_ID
WHERE A.CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC


# 11:04~