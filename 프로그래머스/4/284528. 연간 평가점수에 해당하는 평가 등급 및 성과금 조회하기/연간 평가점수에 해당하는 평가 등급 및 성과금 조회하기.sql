SELECT A.EMP_NO, B.EMP_NAME, (CASE
             WHEN AVG(SCORE) >= 96
             THEN 'S'
             WHEN AVG(SCORE) >= 90
             THEN 'A'
             WHEN AVG(SCORE) >= 80
             THEN 'B'
             ELSE 'C' END) AS GRADE, SAL * (CASE
             WHEN AVG(SCORE) >= 96
             THEN 0.2
             WHEN AVG(SCORE) >= 90
             THEN 0.15
             WHEN AVG(SCORE) >= 80
             THEN 0.1
             ELSE 0 END) AS BONUS
FROM HR_GRADE A JOIN HR_EMPLOYEES B ON A.EMP_NO = B.EMP_NO
GROUP BY EMP_NO
ORDER BY A.EMP_NO

# 소수점??
# 최하 점수 기준임. 예시에 따르면... 평균일수도??
# 자연스러운 건 평균이 더 자연스럽긴 해