# MySQL
### 피드백
- AS 변수명 붙이는 느낌.
- group by에서 조건 붙일 때는 where이 아니라 having
- ! 별칭을 사용할 때 기억해야 할 주의사항 ! 
  - 테이블 별칭은 WHERE 절에서 사용 가능
  - 열(칼럼) 별칭은 WHERE 절에서 사용 불가능 (단, GROUP BY나 ORDER BY 같은 절에는 별칭 사용 가능)
    - SELECT절보다 WHERE 절이 먼저 실행되기 때문
  - select에서 연속적으로 별칭을 이용할 순 없는 듯.

