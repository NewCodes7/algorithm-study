# 코딩테스트 피드백 문서
- 2024년 1월 2일부터 소프트웨어 마에스트로 코딩테스트를 준비하며 공부한 내용을 정리한 문서입니다.

---

### To do list
- [x] 설계, 태도, 행동강령, 유틸성 지식 우선 범주 없이 정리하기
- [x] sql 정리
- [x] 해당 시험과 관련하여 특이사항 
- [x] vscode 단축키? (컨트롤 c, x안됨.) 줄 지우려면 커맨드 백스페이스
- [x] 시험 문서 읽어보기
- [x] 최단 경로 알고리즘 읽어보기
- [x] ! 피드백 문서 읽으며 정리하기
- [x] dfs, bfs, 순열, 조합 기본 코드 짜보기
- [ ] 시간 있으면 레퍼런스 사용법 익히기
- [x] ! 마지막 사전테스트 체험
  - [x] 단축키 되는지 확인
- [x] ! sql 문제 더 풀어보기

- [x] 소프트웨어 업데이트
- [x] 초콜릿 사기

### 🔥 vscode 단축키
- ! 반복되는 코드를 한번에 수정하기: Command + D (반복적으로 눌러야 함)
- ! 코드 위/아래로 이동하기: Option + ↑ 또는 ↓
- ! 코드 위/아래로 복사하기: Shift + Option + ↑ 또는 ↓
- ! 다중커서: Option + 마우스 클릭
- ! 한줄 삭제: CMD + SHIFT + K or CMD + 백스페이스
- ! 검색: 커맨드 f도 됨!!


---
## 시험 전 준비 사항

### 준비
- [x] 책상 및 환경 정리 (전자기기 치우기)
- [x] 신분증, A4종이, 펜, 스마트폰
- [ ] 🔥 감독관 확인 - A4 종이, 초콜릿
- [ ] 크롬 브라우저만 켜기
- [x] 맥북 글램쉘 모드, 방해금지 모드
- [x] 애드블록 차단 풀기
- [x] 아이폰 캠 연결 (배터리 확인- 부족하다면 충전시키면서)
- [x] 카페인, 뇌 활성화, 샤워, 화장실, 당충전

### 실전 유의사항
- 실전에서는 복붙 안 된다!! 테이블이나 칼럼명 직접 작성해야 해
- 최종 채점 안 된다! 제출하기 전에 예제 케이스 이외에 검토하는 습관 들여야 해.
- MYSQL 중간중간 출력해보는 것 필요함.
- 혹시나 와이파이 안 되면 -> 핫스팟 (실행할 정도는 되는 듯)
- 🔥 다른 문제로 넘어가기 전에 실행하기 누르고 가기
- 🔥 마지막으로 최종 제출한 코드가 최종 답안임! (테케 다 통과했다면 우선 눌러두기)
- 물 마시면 안 됨. 마시기 전에 허락 맡기. 


### 전체 시험 흐름도
- 시간계획: sql 20, 알고리즘1 40, 알고리즘2 50
  - 새로운 문제 도전: 30분 이상 있으면 할만함. (3시 반까지는 sql, 알고리즘1 마무리)

1. 문제 훑기 (제목, 길이 정도만)
2. sql 풀기 (복잡하면 알고리즘 ㄱㄱ)
3. 1번이 쉬운 문제인지 확인 (1~3번)
4. 쉬운 문제 하나 풀기 (풀면서 막히면 sql 회귀)
5. 알고리즘1, sql1 풀고 검토까지 마쳤다면, 새 문제 도전
6. 최종 제출 점검


### '행동강령' 추상화
1. 차분해라.
2. 코드에 생각을 담아라.
3. 자신감 가지자!


---
## 문제 접근 방법

### 설계
- 문제 읽기
  - 🔥 문제 한 번 훑고 시작하기! 바로 정독하는 것보다는!!
  - 🔥 문제 조건 하나하나를 꼼꼼히 민감하게 따지자!!! (예외사항 고려)
  - 🔥 문제 한 번 읽고 나서 다시 한 번 보면서 조건 체크하자!!!
  - 🔥 하나의 시행이 무엇인지 정확히 파악해야 한다!!! 
  - 문제 내용이 잘 이해되지 않더라도, 조급함을 버리고 계속 여러 번 읽으면서 정리하면 이해된다..! 
  - 처음에 이해 안 되는 부분 쑥쑥 넘기는 거 좋은데, 다 읽은 다음 다시 읽어봐야 해!!!
- 🔥 작은 것부터 확실하게 만든다. 
  - 그래야 테스트와 검증이 쉽고 확실하다!! 디버깅 특혜
- 사고
  - 🔥 순차적 사고도 좋지만, 결과적 사고도 하자!!! (특히, 현재 시간 복잡도가 크다면)

- 세부 설계: 들여쓰기 설계 후, 코드 껍질 짜면서 세부적인 설계는 //주석으로 처리하자. 
  - 단, 중간에 설계할 때 중요한 부분에는 시간 들여라. 너무 급하게 x
- 다 조합하고 나서 다 뽑고 나서 요리하는 게 아니라, 가능하다면 조합하면서 요리!!
- 들여쓰기 설계할 때 생각나는 거 있으면 우선 모조리 적어둬야 함.
- 설계에서 꼭 하나의 루프로 표현하려고 하지말자. 복잡하면 나누자. 

### 태도, 행동강령
- 🔥 생각: 코드 한 줄 한 줄 생각 담아서 짜기.
- 🔥 넘어가기: 하나 온전히 물려고 하지 말고, 안 풀린다 싶으면 시원하게 넘어가기!!
  - 🔥 그 전 문제 말려서 다음 문제 왔으면, 그 전 문제는 잊어버리고 시작하자!!!
  - 🔥 sql 못 풀 수 있는 것도 감안하기. 너무 새롭고 모르겠으면 과감하게 포기하기.
- 🔥 점검: 중간중간 해당 기능이 잘 구현됐는지 꼼곰히 점검.
- 🔥 검토
  - 케이스: 테케 이외의 극단적인, 예외적인 케이스 고려해보자!!
  - 조건: 문제 조건 놓친 거 없이 정확히 반영했는지 체크하자!
  - 코드 자체: 코드에 논리적 오류 없는지 점검하자!
- 시간 초과나면
  - 근본적인 걸 수정하거나 (ex. 이중반복문)
  - 🔥 결과적 사고를 진행하자. (과정이 아니라 결과적으로 해석하기 (능동적인 수학머리 참여))

- 테스트 케이스 틀렸을 때 대처법
  - 가능성이 높은 쪽 고려
  - 요구사항 고려
  - 예외사항 고려
- 에러났을 때 대처법
  - index
  - null
- 방심x: 많이 쉬워보이거나 설계에서 길이 뚜렷하게 보여도 차분해야 한다. 꾹꾹 눌러서!!
- 시간
  - 백트랙킹 + 약간의 구현 -> 큰 굴곡이 없다면 30분 정도 걸림. 감안.
- 주의: 전에 봤던 비슷한 문제랑 스트럭쳐 유사하다고 해서 우숩게 보면 큰일난다!!!!
- 처음부터 너무 크게 만들지 말기. 나중에 테스트, 검증하는 것 감안해서 작은 것부터 확실하게 만들고 세밀하게 검증하자.


---
## 유틸성 지식

### 문자열
- 🔥 문자열에는 여러 도움을 주는 메서드들이 많음. 하지만 이걸 모른다고 해도 배열 + for문으로 해결할 수 있음. 너무 강박x

- [정규표현식](./알고리즘/정규표현식.md)
- 🔥 특정문자 제거: s.replaceAll("[^abc]", "");
  - regex ""로 감싸야 함.
  - a, b, c 셋 중에 하나가 아니라면 replace 작동함.
  - []: ~ 중의 하나
  - [xy]: x 와 y 중에 하나를 의미
  - [^xy]: x 및 y 를 제외한 문자
- 🔥 문자열 삭제 메서드
  - sb - delete: new StringBuilder(originalString).delete(startIndex, endIndex)
  - replace: originalString.replaceAll("삭제할 부분", "")

- 🔥 문자열 분할: new StringTokenizer(expression, "abc", true);
  - a, b, c를 구분자로 분할함.
  - replace와 다르게 해당 파라미터가 정규식은 아님.
  - true하면 구분자도 포함시킴.
- 🔥 split(String regex): 파라미터 그냥 문자열이 아니라 정규표현식이다!!
  - 정규표현식에서 .은 특수문자이기에 "\\."라고 해야 함.
- 🔥 연속된 문자 제거하고 싶을 때: split("문자")
  - "1002".split("0"); // ["1", "", "2"]

- 🔥 st 개수: st.countTokens();
- 🔥 char to String: String.valueOf(char);
- Character: char를 다루기 위한 클래스
  - isDigit: 숫자인지
  - isAlphabetic: 알파벳인지
  - isUpperCase: 대문자인지
  - toUpperCase: 대문자로
  - toString: 문자열로
- 아스키코드 저장: int offset = 'A'; <- 아스키코드로 저장됨.
- 부분 문자열 주의: subString (x) substring (o)
- 문자열 뒤집기: new StringBuilder(str).reverse().toString();
- StringBuilder.append() 유연성: 매개변수에 char,int 등 원시 자료형 들어갈 수 있다. 배열도 char[]도 가능!!
- Stringbuilder에서 삭제: sb.deleteCharAt(sb.length() - 1);
- 🔥 String[] to String
  - String.join("", arr); 첫번째 파라미터는 문자열 요소를 구분하는 기호
  - String.join(" ", arr); 붙일때마다 사이에 공백 추가됨.

- 🔥 문자열 비교: str1.compareTo(str2);
  - 첫 번째 자리부터 차근차근 비교함. 
    - 다른 숫자가 나타나는 순간, 그 숫자들의 아스키코드 차를 나타냄.
  - str1에 str2가 포함되어있을 경우("3455", "34"), 서로의 문자열 길이의 차이값을 리턴(2)

- 🔥 문자열 탐색
  - str1.contains(str2); // true or false
  - "abcd".search("cd"); // 2 (startIndex)

- 🔥 문자열 특정 위치 문자 바꾸려면? -> sb 이용! setCharAt!!!! 
  - ```java
      StringBuilder sb = new StringBuilder(myString);
      sb.setCharAt(7, 'X'); // 인덱스 7의 문자를 'X'로 변경
  - ```

---
### 숫자
- long 선택
  - 중간에 연산하면서 21억 넘어갈 거 같을 때
  - 2,147,483,647 넘어가거나 2의 31제곱 넘어갈 때
  - -2,147,483,648 이하이거나 -2의 31제곱 -1 이하일 때
- int 자릿수 얻기
  - ```java
      while (number > 0) {
        stack.push(number % 10);
        number /= 10;
      }
  - ```
- 진법 변환
  - 10진법 -> x진법: Integer.toString(n, x); Long.toString(n, x);
  - x진법 -> 10진법: Integer.parseInt(n, x); Long.parseLong(n, x);
  - 🔥 진법 변환했다가 좀 조작하고 다시 돌아올 때 조심해야 해! 숫자 커질 수 있음.
- 🔥 소수 찾기 범위: i <= Math.sqrt(n);
- 🔥 Math 메서드 주의: Math.ceil((double) time / fee[2]);
- 🔥 소수점 반올림: Math.round(pie*10)/10.0;	 // 3.1
- 최댓값: Integer.MAX_VALUE
- 최솟값: Integre.MIN_VALUE


---
### 자료구조
- 자료구조 선택: 큐, 덱, 스택 쓰기 전에 중간 요소 필요없는지 점검하자.
- 🔥 자료구조 원소 읽을 때 주의: get, peek, poll, pop 등 할 때, 원소가 하나라도 있는지 null이 아닌지 민감하게 반응하자!!!
- Contains 주의: List<int[]> list = new ArrayList<>();
- set 값 읽기: List<> list = new ArrayList<>(set);
- 넓이: 좌표평면 상의 넓이를 구하기 위해 2차원 배열로 표현하여 구할 수 있다.
- remove(객체): 특정한 객체 찾아 제거
  - 🔥 list.remove(Integer.valueOf(1)): 첫번째로 등장하는 1을 제거
  - 🔥 list.removeAll(Integer.valueOf(1)): 1 모두 제거
  - fruits.remove("apple");
- 리스트 삽입 순서 지정 가능: list.add(i, 원소); (i: 추가하고 싶은 index)
- 값 삽입, 수정, 삭제 재빠르게 해야 한다면: HashMap 이용!!!
- 🔥 연결성: 정렬, 삽입, 삭제 등 하면 다른 곳에서도 바뀐다는 걸 인지하자!!
- 2차원 배열 복사 주의: int[][] clone = map.clone(); 이걸로 안 된다!!
- Map 순회
  - for (Map.Entry<String, String> entry : **map.entrySet()**) {
  - String key = enrty.getKey();
  - String value = entry.getValue();}
  - 🔥 for (String key : **map.keySet()**)
  - 🔥 for (String key : **map.values()**)
- 우선순위 큐
  - PriorityQueue<type> pq = new PriorityQueue<>(); (우선순위가 낮은 숫자 순)
  - 🔥 PriorityQueue<type> pq = new PriorityQueue<>(Comparator.reverseOrder());

- 깊은 복사
  - 배열 깊은 복사: arr.clone();
  - 🔥 리스트 깊은 복사: ArrayList<Integer> deepCopyList = new ArrayList<>(originalList);

- 스택, 큐
  - 🔥 contains(): 특정 요소가 있는지 확인
  - 🔥 (스택만) search(): 해당 요소의 순번 리턴 (가장 빨리 나오는 게 1번) (요소 없으면 -1)

- 🔥 덱: Deque<> d = new 🔥ArrayDeque<>();
  - addFirst()
  - addLast()
  - pollFirst()
  - pollLast()
  - peekFirst()
  - peekLast()
- 🔥 큐, 스택 순회 - 확장 for문으로 가능!

---
### 백트랙킹, DFS, BFS
- 🔥 본질: 순서, 문어발(위아래)
- 🔥 유형: 순열(visited), 조합(i+1), 같순열(arr[i]--, == 0 continue), 채워넣기(i, continue)(순서x)(중복조합과 유사)
- 🔥 사고: 어떤 예상값이 나와야 하는지부터 파악해보기.
- 복구: for문 뿐만 아니라 if문에서 한 것까지 복원해야 한다!
  - 🔥 특히 배열, 리스트라면 더 주의해서!!!
  - 깔끔하게 복구되었는지 민감하게 거시적으로 확인하자.
- 🔥 실수 주의: 조합에서는 for문 안에 일반적으로 i만 나온다! idx 아니라!!
- 본질: for문 안에 dfs 생각해봐. 모든 경우의 수 돌기 위함. 이걸 풀어헤치면 dfs가 여러 줄 나올 수 있음!! 반복문에 얽매이지 말고, 어떤 결과를 구해야하는 지부터 파악하고, 그에 따라 코드 짜자.

- 🔥 그래프 주의: 1번 부터 시작하면 n+1, i <= n이다!!!!
- 🔥 인접 행렬 혹은 인접 리스트에 정보 저장할 때, **양방향 그래프라면** 양쪽에 추가해야 된다!! 하나만 추가하지마!!
  - 그리고 간선의 삭제, 복구도 양쪽에 해야한다!
- '최단 경로'로 이동했을 때!!!!!! '거리' 관련은!!!!!!! '가깝고' '멀고' 관련은!!! -> BFS!!!!
- 🔥 bfs 방문처리는 while 문 안에서
- 🔥 dfs 방문처리는 dfs 첫 줄에서

---
### 정렬
- 배열 내림차순: Arrays.sort(arr, Comparator.reverseOrder());
- 🔥 부분 정렬: Arrays.sort(arr, fromIndex, toIndex);
- 🔥 sort() 함수에 정렬 기준 지정 가능
  - ```java
      Collections.sort(list, (e1, e2) -> {
          return e1.getY() - e2.getY();
      }); // 이와 같이 comparator 함수를 직접 지정해줄 수 있음.
  - ```

---
### 이진탐색
- 🔥 10억과 같이 탐색 범위가 굉장히 크다면, 이진 탐색 떠올려라!!
```java
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return mid;

            if (arr[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        return -1;
    }
```
- 🔥 Arrays.binarySearch(arr, target);
- Collections.binarySearch(list, target);


---
### 기타
- 정렬해서 출력하거나 처리해야 하는 문제들은 미리 전처리로 해결할 수도 있다!!
- 🔥 map에서 get할 때 우선 key 있는지부터 if(map.containsKey())로 점검해야해!!!

- break: 사용할 때 범위 체크

- 영향력 주의: 좌표 x, y 위치 바꾸려면 통일성 지켜야 한다. 
- 90도 회전: y=x 대칭이동 + x축 대칭이동
- 🔥 변수 범위 체크: '크기가 100x100'에 현혹돼서 바로 100이라 선언x!! 각 인자마다 범위 확실히 체크하자.
- 예외 사항 체크: 예외 사항 찾을 때 너무 작은 값만 신경 쓰는 게 아니라 큰 값도 신경 써라! 양수가 아니라 음수도!
- 🔥 모든 경우에 대해 삼단논법을 진행해야 한다면, 플로이드 워셜 (삼중 반복문 k,a,b)
- 아래 메서드는 double을 인자로 받고 double로 반환함.
  - Math.ceil(): 올림
  - Math.floor(): 내림
  - Math.round(): 반올림

- 코드 재사용: 특정 동작을 반복해야 한다면, 재사용성 고려해서 힘들게 메서드 합치지 말고, 일단 복붙해서 구현하자.
- 논리 연산자: &&에서 왼쪽 피연산자 false일 경우, 자동 false 반환!!

- 최장 증가 부분 수열 원리: 각 원소의 지위, 랭크를 매기는 작업을 **순차적으로** 선행함. 그리고 가장 큰 값이 답.
- 🔥 반복문 중첩 주의: 반복문 중첩해있을 때, 특정 로직이 어디 안에 있어야 하는지 민감하게 반응하자.
- 🔥 90도 rotate: rotate[i][j] = arr[n-1-j][i]; n: 원래 가로
```java
// 90 rotate
static int[][] rotate(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    int[][] rotate = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            rotate[i][j] = arr[n-1-j][i];
        }
    }

    return rotate;
}
```
- 무언가 중요한 기준을 수정했을 때는 그와 관련하여 바꿔야 할 부분이 많다!! 최대한 신경 기울여야 함.



---
### MYSQL
- WITH A AS ()
- 🔥 GROUP BY는 GROUP BY에 정의한 내용(컬럼 또는 변형된 컬럼)만 SELECT절에 그대로 사용할 수 있다. GROUP BY에 정의하지 않은 컬럼을 SELECT절에서 사용하려면 반드시 집계함수 처리를 해야 한다.
- SUM() 안에도 WHEN 절 활용할 수 있다!!

- 🔥 문제 제목 읽고 유추하기
- 🔥 문제 서술 부분 훑어 읽으며 중요한 부분 있으면 캐치하자!!
- 🔥 어려운 건 설계가 필요하다! 펜 쓰는 것도 감안해두기
- 🔥 코드 중복, 코드 재사용성 연연하지 말자. 시간 복잡도가 있는 것도 아니니까. 코드 길어져도 초조해하지 말고 '정확성'에 초점 두자. 
- 🔥 '여성 회원' 이것도 문제의 조건이다!!! 하나하나 꾹꾹 눌러 읽어야 함.
- '2022-01-11'로 출력되어야 한다면 DATE-FORMAT!!!
- 🔥 SQL에서는 순차적 사고보다는 결과적 사고를 하자!!! 순차적 사고를 구현하기는 힘드니까. 

- 열(칼럼) 별칭은 WHERE 절에서 사용 불가능
- 문자열 합치기 CONCAT(STR1, STR2, ...)
- a between b and c: b, c와 일치하는 것도 true. 그러나 아래 주의!
  - BETWEEN '2012-01-22' AND '2012-01-23' 은
  - BETWEEN '2012-01-22 00:00:00' AND '2012-01-23 00:00:00' 과 같은거
- ```sql
  WITH 테이블이름네이밍 AS 
  (
      #반복시킬 쿼리
      SELECT 
  )
- ```
- 🔥 TIMESTAMPDIFF(단위, 날짜1, 날짜2);
  - SECOND : 초
    MINUTE : 분
    HOUR : 시
    DAY : 일
    WEEK : 주
    MONTH : 월
    QUARTER : 분기
    YEAR : 연
- LEFT OUTER JOIN
  - 첫 번째 테이블을 기준으로 두 번째 테이블을 조합
  - 첫 번째 테이블은 모두 검색되어야 함.
  - 🔥 오른쪽 = null하면 차집합구할 수 있음.
- SET @HOUR = -1;
- LIKE
  - 와일드 카드: 여러 파일을 한꺼번에 지정할 목적으로 사용하는 기호
    - %: 0개 이상의 문자 대신 표현
    - _: 1개의 문자표현
      - _012 -> t012, 0012, a012
    - \: %나 _를 포함하려면 \붙이면 됨.
- 🔥 IF(조건문, 참일 때 값, 거짓일 때 값)
- 🔥 IFNULL(column_name, '대체할 값')
- 🔥 문자열 자르기
  - SUBSTRING(STR, STARTIDX, COUNT) -- MID와 동일 (마지막 파라미터 인덱스가 아니라 개수다!!)
  - LEFT(STR, COUNT)
  - RIGHT(STR, COUNT)

- 🔥 버림: TRUNCATE()
  - SELECT TRUNCATE(1234.56789 ,1) FROM DUAL; 1234.5
  - SELECT TRUNCATE(1234.56789 ,4) FROM DUAL; 1234.5678
  - SELECT TRUNCATE(1234.56789 ,0) FROM DUAL; 1234
  - SELECT TRUNCATE(1234.56789 ,-1) FROM DUAL; 1230
  - SELECT TRUNCATE(1234.56789 ,-2) FROM DUAL; 1200
- 제곱: POW(10, 2); 100
- 🔥 나머지: MOD(10, 3); 1
- 🔥 최댓값: GREATEST(3, 2, 1); 3
- 최솟값: LEAST(3, 2, 1); 1

- 🔥 LIMIT x, y
  - x+1번째항부터 y개 조회 (x+1 ~ x+y)
  - SELECT title, content, writer FROM board LIMIT 3, 5;
    - 4번째 항부터 8번째항까지 조회

- 🔥 UNION: 중복제외
- UNION ALL: 중복 허용

- 🔥 칼럼 내 값이 중복 있는지 점검하는 습관 좋다!! 중복에 민감해야해!!!!! 문제 처음 읽을 때! 이래서 설명도 읽어야 해
- 고유 개수 세기에는 DISTINCT가 정말 유용한 듯.
  - DISTINCT birthcity 이렇게도 사용가능함
    - 🔥 DISTINCT birthyear, birthMonth, birthday: 이건 세 개의 값이 모두 같은 행들만 중복으로 간주함. 1998,09,12 1998,09,12
- 🔥 특정 요소를 하나라도 뽑지 않아야 한다면 not in 활용




---
