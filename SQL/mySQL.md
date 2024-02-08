# MySQL
### 피드백
- AS 변수명 붙이는 느낌.
- group by에서 조건 붙일 때는 where이 아니라 having
- ! 별칭을 사용할 때 기억해야 할 주의사항 ! 
  - 테이블 별칭은 WHERE 절에서 사용 가능
  - 열(칼럼) 별칭은 WHERE 절에서 사용 불가능 (단, GROUP BY나 ORDER BY 같은 절에는 별칭 사용 가능)
    - SELECT절보다 WHERE 절이 먼저 실행되기 때문
  - select에서 연속적으로 별칭을 이용할 순 없는 듯.
- WHERE COLUMN LIKE '' 특정 문자 있는지 확인

### JOIN ON
- TABLE1 JOIN TABLE2 ON 조건

### IN
- COLUM IN ('ABC') -> ture or false
- 서브 쿼리 이용: COLUMN IN (SELECT ~~) 
- (a.user, a.group) IN ('test2', 'B')

### IF
- IF(조건문, 참일 때 값, 거짓일 때 값)
- IFNULL(column_name, '대체할 값')
- CASE WHEN
  ```sql
  SELECT
	CASE
		WHEN permission_type_id = 1
		THEN '관리자'
		WHEN permission_type_id = 2
		THEN '판매자'
		ELSE '일반 유저'
  END	
  ```

### A BETWEEN B AND C

### DATE
- DATE_FORMAT(date, format)
- DATEDIFF(D1, D2) -- 일수 차이

### 문자열 가져오기
- SUBSTRING(STR, STARTIDX, COUNT) -- MID와 동일
- LEFT(STR, COUNT)
- RIGHT(STR, COUNT)
