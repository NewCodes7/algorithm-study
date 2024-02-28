SET @HOUR = -1;

SELECT (@HOUR := @HOUR+1) AS HOUR, (SELECT COUNT(*)
                                   FROM ANIMAL_OUTS
                                   WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23

# 왜 이렇게 하면 안 되지?
# 아.. 그러면 이거 행의 데이터가 24개 미만이면 틀리겠네!!!