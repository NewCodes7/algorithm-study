SELECT H.HISTORY_ID, -- 대여 기록 ID
    -- 지불해야하는 비율까지 구했다면 일일 대여 요금 x (끝난 날짜 - 시작 날짜)+1 = 이용기간 => 대여 금액 
    -- 단 소수점은 다 버린다.
    round(DAILY_FEE * (DATEDIFF(H.END_DATE,H.START_DATE)+1) * 
          (1 - ( -- 1 - (구한 비율을 100으로 나눈 값)을 하면 비용을 지불해야하는 비율이다.
          CASE WHEN DATEDIFF(H.END_DATE,H.START_DATE)+1 >= 90  -- 90일 이상일 경우
                THEN (SELECT DISCOUNT_RATE  -- CAR_RENTAL_COMPANY_DISCOUNT_PLAN테이블에서 할인비율
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN SP
                      -- CAR_RENTAL_COMPANY_CAR의 차종류와 CAR_RENTAL_COMPANY_DISCOUNT_PLAN의 차 종류가 같고
                     WHERE C.CAR_TYPE = SP.CAR_TYPE 
                        and DURATION_TYPE = '90일 이상')/100 -- 대여 기간이 90일 이상인 것
                    -- 의 비율을 100으로 나눈 후 
              -- CASE ~ WHEN ~ END의 내용은 위와 같은 내용이다.
               WHEN DATEDIFF(H.END_DATE,H.START_DATE)+1 >= 30 
                THEN (SELECT DISCOUNT_RATE 
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN SP
                     WHERE C.CAR_TYPE = SP.CAR_TYPE and DURATION_TYPE = '30일 이상')/100
               WHEN DATEDIFF(H.END_DATE,H.START_DATE)+1 >= 7 
                THEN (SELECT DISCOUNT_RATE 
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN SP
                     WHERE C.CAR_TYPE = SP.CAR_TYPE and  DURATION_TYPE = '7일 이상')/100
               ELSE 0 -- 90, 30, 7일 이상이 아닐 경우는 1 - 0 = 할인이 없다는 것
               END ))) FEE
    from CAR_RENTAL_COMPANY_CAR as C
        join CAR_RENTAL_COMPANY_RENTAL_HISTORY as H
            -- CAR_RENTAL_COMPANY_RENTAL_HISTORY의 테이블의 차 ID와 CAR_RENTAL_COMPANY_CAR의 차 ID를 기준으로 연결
            on C.CAR_ID = H.CAR_ID 
WHERE C.car_type = "트럭" -- 차 종류가 트럭인 경우만
GROUP BY H.HISTORY_ID -- 대여 기록 ID로 그룹화
ORDER BY FEE DESC , H.HISTORY_ID DESC