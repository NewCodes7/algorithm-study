# MySQL
### 피드백
- AS 변수명 붙이는 느낌.
- group by
  - 조건 붙일 때는 where이 아니라 having
  - 칼럼을 두 개 넣을 수도 있음. (이 두 가지가 같은 걸 기준으로 ~~해줘.)
- ! 별칭을 사용할 때 기억해야 할 주의사항 ! 
  - 테이블 별칭은 WHERE 절에서 사용 가능
  - 🔥 열(칼럼) 별칭은 WHERE 절에서 사용 불가능 (단, GROUP BY나 ORDER BY 같은 절에는 별칭 사용 가능)
    - SELECT절보다 WHERE 절이 먼저 실행되기 때문
  - select에서 연속적으로 별칭을 이용할 순 없는 듯.
- WHERE COLUMN LIKE '' 특정 문자 있는지 확인
- 🔥 문자열 합치기 CONCAT(STR1, STR2, ...)
- 🔥 어려운 건 설계가 필요하다! 펜 쓰는 것도 감안해두기
- 🔥 레벨 4이상은 다시 풀어봐야 할 듯.
- 합계 왠만하면 SUM 이용하자!
- GROUP BY 두 개 할 수 있음. (저자 별 카테고리 별)
- 🔥 문제 제목 읽고 유추하기
- 🔥 중복된 거는 버리고 싶을 때!!: COUNT(DISTINCT(B.USER_ID)) (DISTINCT: 범주 조회)
  - 고유 개수 세기에는 DISTINCT가 정말 유용한 듯.
- 제시된 테스트 케이스 훑고 들어가야 할 듯. 그리고 디버깅할 때 적극적으로 보기.
- 🔥 문제 서술 부분 훑어 읽으며 중요한 부분 있으면 캐치하자!! (주문량이 많은 아이스크림들 조회하기)


### [자동차 대여 기록 별 대여 금액 구하기]
- 기존 풀린 풀이가 왜 틀렸는지는 이해가 되지 않지만, 위험한 건 알겠음.
- 🔥 무지성 join은 위험하다!!! 서브쿼리, 유니온으로 해당 테이블 활용할 수도 있다!!
- 🔥 a between b and c: b, c와 일치하는 것도 true. 그러나 아래 주의!
  - BETWEEN '2012-01-22' AND '2012-01-23' 은
  - BETWEEN '2012-01-22 00:00:00' AND '2012-01-23 00:00:00' 과 같은거
- 더 효율적인 풀이로 시도하기 (https://kkw-da.tistory.com/entry/SQL-%EC%9E%90%EB%8F%99%EC%B0%A8-%EB%8C%80%EC%97%AC-%EA%B8%B0%EB%A1%9D-%EB%B3%84-%EB%8C%80%EC%97%AC-%EA%B8%88%EC%95%A1-%EA%B5%AC%ED%95%98%EA%B8%B0%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4MySQLLevel-4)
  - from에서도 서브쿼리 활용할 수 있음.

### [취소되지 않은 진료 예약 조회하기]
- with 문법 풀이?

### [대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기]
- 🔥 WHERE '2022-08-01' <= START_DATE <= '2022-10-31' // 이런식으로 비교하는 건 안돼!!

### WITH
- 임시 테이블을 지정함으로써 반복적인 수행을 가능하게 해줌.
- 구조
- ```sql
- WITH 테이블이름네이밍 AS 
(
    #반복시킬 쿼리
    SELECT 
)

-```


### 🔥 SET
- 없는 값을 만들어내는 데 사용됨. 무언가 값을 update할 때
- 🔥 입양 시각 구하기(2) 다시 풀어보기
- set 연습해보기 (우선순위 낮지만)

### JOIN
- ![Alt text](image.png)
- TABLE1 JOIN TABLE2 ON 조건
- 🔥 LEFT OUTER JOIN
  - 첫 번째 테이블을 기준으로 두 번째 테이블을 조합
  - 첫 번째 테이블은 모두 검색되어야 함.
  ```SQL
  -- 예) 1학년 학생의 이름과 지도교수명을 출력하라. 단, 지도교수가 지정되지 않은 학생도 출력되게 하라.

  SELECT STUDENT.NAME, PROFESSOR.NAME 
  FROM STUDENT LEFT OUTER JOIN PROFESSOR -- STUDENT를 기준으로 왼쪽 조인
  ON STUDENT.PID = PROFESSOR.ID 
  WHERE GRADE = 1
  ```
- RIGHT OUTER JOIN
  - 두 번째 테이블을 기준으로 첫 번째 테이블을 조합
  - 두 번째 테이블이 모두 검색되어야 함.
  ```SQL
  -- 예) 1학년 학생의 이름과 지도교수명을 출력하라. 단, 지도교수가 지정되지 않은 학생도 출력되게 하라.

  SELECT STUDENT.NAME, PROFESSOR.NAME 
  FROM STUDENT RIGHT OUTER JOIN PROFESSOR -- PROFESSOR를 기준으로 오른쪽 조인
  ON STUDENT.PID = PROFESSOR.ID 
  WHERE GRADE = 1
  ```
- JOIN하면 기준이 같은 건데 한 쪽에 여러 개 있다면 여러 개 생성됨.
- ON 기준은 최대한 고유한 것으로!! 


### LIKE
- 와일드 카드: 여러 파일을 한꺼번에 지정할 목적으로 사용하는 기호
  - %: 0개 이상의 문자 대신 표현
  - _: 1개의 문자표현
    - _012 -> t012, 0012, a012
  - \: %나 _를 포함하려면 \붙이면 됨.


### IN
- 집합 내부에 값이 존재하는지 여부를 확인합니다. (값 자체가 있는지 정확히 판단 %(x))
- COLUM IN ('ABC') -> ture or false
- 서브 쿼리 이용: COLUMN IN (SELECT ~~) 
- 🔥 두개활용가능: (a.user, a.group) IN ('test2', 'B') (식품분류별 가장 비싼 식품의 정보 조회하기)
- 🔥 특정 요소를 하나라도 뽑지 않아야 한다면 not in 활용 (특정 기간동안 대여 가능한 자동차들의 대여비용 구하기) - 한 번 더 풀기
- 🔥 서브쿼리에서 두 개의 열 담고 싶다면
  - ```sql
  - AND (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE)
                    FROM FOOD_PRODUCT
                    GROUP BY CATEGORY)
  - ```
- 🔥 이런 식으로는 불가능!! B.SEX_UPON_OUTCOME IN ('Spayed%', 'Neutered%')
  - %는 LIKE 문법이다!!

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
  🔥 END	
  ```

### DATE
- DATE_FORMAT(date, format)
- 🔥 DATEDIFF(D1, D2) -- D1 - D2를 반환함. 몇일동안 이루어졌는지 알고싶으면 +1해야함.

### 문자열 가져오기
- 🔥 SUBSTRING(STR, STARTIDX, COUNT) -- MID와 동일
- 🔥 LEFT(STR, COUNT)
- 🔥 RIGHT(STR, COUNT)

- IN 정확히

### NULL
- ISNULL()
- ~ IS NULL
- ~ IS NOT NULL

### 🔥 NUMBER
- ROUND(N) : 반올림
- ROUND(N, 2) : 소수점 둘째자리 까지
- CEIL
- FLOOR
- ABS
- TRUNCATE
- POW
- MOD
- ```SQL
  # 절대값
  select abs(100), abs(-100);

  # 올림
  select ceil(10.1), ceil(10.4), ceil(10.5), ceil(10.0);

  # 내림
  select floor(10.1), floor(10.4), floor(10.5), floor(10.0);

  # 반올림
  select round(10.1), round(10.4), round(10.5), round(10.0);
  select round(1.23456789, 1), round(1.23456789, 4), round(1.23456789, 7);

  # 제곱
  select pow(10, 2);

  # 나머지
  select mod(10, 3);

  # 최대값
  select greatest(10, 4, 20, 1);

  # 최소값
  select least(10, 4, 20, 1);
- ```
  

### LIMIT
- 🔥 행 데이터 10개만 조회하기
  - SELECT title, content, writer FROM board LIMIT 10;
- 🔥 11번째 ~ 20번째 행 데이터 조회
  - SELECT title, content, writer FROM board LIMIT 10, 10;
- 🔥 가장 큰 걸 고르고 싶다면
```sql
(SELECT MEMBER_ID
                   FROM REST_REVIEW
                   GROUP BY MEMBER_ID
                   ORDER BY COUNT(MEMBER_ID) DESC
                   LIMIT 1)
```


### 🔥 UNION
- 테이블을 합치는 방법은 join만 있는 게 아니다!!
- UNION: 중복제외
- UNION ALL: 중복 허용
- 🔥 특정 칼럼 null로 두고 싶다면 그저 Null as '칼럼명' 하면 됨.

### 소수점 없애기