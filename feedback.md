# 풀이 후 피드백

## 2차원 배열

### [행렬 덧셈](백준/Bronze/2738. 행렬 덧셈)
- Scanner보다는 BufferedReader를 활용하는 게 시간 측면에서 효율적임.
- 풀이 방법이 떠올렸다고 해서 바로 풀이 들어가지 말고, _조금 더 아이디어를 다듬고 들어가자._
    - 더 효율적인 방법이 있을 수 있고, 혹은 해당 방법에서 더욱 최적화된 코드를 짤 수 있게 된다.
- 중간중간 log를 찍어보며 오류가 없는지 확인하자.

### [최댓값](백준/Bronze/2566. 최댓값)
- _제출 실패해도 당황하지 말자._
    -  요구 사항을 놓친 부분은 없는지, 예외 사항이 있는지 체크하자.

### [세로읽기](백준/Bronze/10798. 세로읽기)
- 초기화된 배열의 요소는 0을 가짐.
- 코드 본격적으로 작성하기 전에 조금 더 설계하자.
- 2차원 배열 출력하는 방법: **Arrays.deepToString(arr)**
- 입력 요구사항 꼼꼼히 체크하자. (최대와 최소도 체크할 것)
    - 최대 이용해서 2차원 배열 선언해둘 수 있음.
- 반복문에서 순서(index)가 중요하다면 while 보다는 for

### [색종이](백준/Silver/2563. 색종이)
- 제출 후 틀렸을 때 대처법
    - 요구사항을 재점검한다.
    - 예외사항을 고려한다. (특히, 자유도가 높을 경우)
    - 최악의 경우, 다시 설계하고 구현해야 한다.
- **문제 처음에 이해하고 설계할 때, 예외 사항도 추론하고 고려해야 한다.**
- 좌표평면 상의 넓이를 구하기 위해 2차원 배열로 표현하여 구할 수 있다.


## 문자열
### [시저 암호](프로그래머스/1/12926. 시저 암호)
- Character: char를 다루기 위한 클래스
    - isDigit: 숫자인지
    - isAlpahbetic: 알파벳인지
    - isUpperCase: 대문자인지
    - isLowerCase: 소문자인지
    - isSpaceChar: 공백인지
 
    - toUpperCase: 대문자로
    - toLowerCase: 소문자로
    - toString: 문자열로
- int offset = 'A'; <- 아스키코드로 저장됨.
- 문자열을 CharArray로 바꾸고 싶을 때: String.toCharArray
- 절대적인 위치를 평행이동하여 상대적인 위치를 이용해 더욱 편하게 계산할 수 있음.
- 코드를 순차적으로 짜는 것보다는 _구조적인 설계 코드_ 를 짜두고 들어가는 것도 좋음.

### [이상한 문자 만들기](프로그래머스/1/12930. 이상한 문자 만들기)
- 문제 요구사항 꼼꼼히 읽자!! 훑어읽지마!!
- StringBuilder 적극적 이용하자. 자바에서 문자열은 불변이다.
- 예외사항 때문에 꼬였을 때 다시 설계하고 구현하는 것도 고려하자. 이게 오히려 더 빠를 수 있다.

### [문자열 압축](프로그래머스/2/60057. 문자열 압축)
- 메서드 분리의 필요성! (레벨2이상은 메서드 분리하면서 풀어야 할 듯) (급하게 하지마)
    - 리팩토링 용이함.
    - 구현하는 동안 가독성 올라감.
- 문자열 비교는 _equals_ !!!
- subString (x) substring (o)


## 구현
### 이코테 예제 문제(왕실의 나이트)
- 정수형 자료형의 범위: int < long
- continue: 반복문에서 현재 단계의 실행을 멈춤 (cf. break)
- 내가 문제를 푸는 게 아니야! 컴퓨터가 문제를 풀게 해야 해. 컴퓨터가 일반화를 하게 해야 해.
- 2차원 공간에서 이동해야 한다면, 이동할 수 있는 경우의 수를 dx(행), dy(열) 배열 형태로 저장하고 for문 돌리자.

### 이코테 예제 문제(게임 개발)
- 2차원 공간에서 이동하는 경우
    - dx, dy, direction 배열로 저장해두기
    - 예: nx = x + dx[direction[i]];
- indexOf는 list에서만 쓸 수 있음.
- 리스트 선언
``` 
List<String> s2 = new ArrayList<String>(Arrays.asList("1", "2", "3")); // 원소 자유롭게 수정 가능
List<String> s5 = Arrays.asList("1", "2", "3"); // set을 통해서만 수정 가능
List<String> s5 = List.of("1", "2", "3"); // 수정 불가능
```


## 완전 탐색
### [모의고사](프로그래머스/Lv.1/42840. 모의고사)
- 자바의 타입
    - 기본 타입(primitive type)
        - 정수 타입: byte, char, short, int, long
        - 실수 타입: float, double
        - 논리 타입: boolean
    - 참조 타입(reference type)
        - 배열 타입
        - 열거 타입(enum)
        - 클래스 (ex. String, Integer)
        - 인터페이스
    - 차이점: 기본 타입은 실제 값을 변수 안에 저장하지만, 참조 타입은 메모리의 번지를 저장함.
- 리스트, 배열 변환 (stream 이용) (for문, Arrays.asList 등을 이용할 수도 있음.)
```java
// IntegerList to intArray
int[] intArray = IntegerList.stream()
                            .mapToInt(Integer::intValue).toArray();

// intArray to IntegerList
List<Integer> integerList = Arrays.stream(intArray)
                                   .boxed() // int to Integer
                                   .collect(Collectors.toList());

// StringList to StringArr
String[] stringArray = stringList.stream().toArray(String[]::new);

// StringArr to StringList
List<String> stringList = Arrays.stream(stringArray)
                                        .collect(Collectors.toList());
```
- 배열/리스트 최댓값 구하기
```java
int max = Arrays.stream(intArray).max().getAsInt(); 
//max는 OptionalInt 객체로 반환. getAsInt는 해당 객체에서 실제 int값을 가져옴.
// OptionalInt는 Java 8부터 추가된 클래스로, 값이 존재할 수도 있고 없을 수도 있는 값을 감싸는 래퍼 클래스
int max = Collections.max(intList);
```
- 스트림 문법
    - 의미: 자바8에서 등장한 새로운 기술 중의 하나로, 컬렉션을 함수형 프로그래밍 스타일로 다룰 수 있게 해주는 API
    - 스트림 연산
        - 중간 연산
        - 최종 연산
- Collection(인터페이스): list, set, map
- Collections(유틸리티 클래스): 컬렉션을 위한 유용한 메서드 제공


### [카펫](프로그래머스/Lv.2/42842. 카펫)
- import java.util.*; 하고 시작하자!!
- 2차원 리스트 선언
```java
List<List<Integer>> list1 = new ArrayList<>();
```

### [수식 최대화](프로그래머스/Lv.2/67257. ［카카오 인턴］ 수식 최대화)
- 문자열에 특정 문자가 포함되었는지 확인하고 싶다면 -> str.contains("dd");
- 네이밍 조금만 더 신경쓰자. 
- **문제 읽을 때 숫자 범위 체크하고 int, long 골라서 사용하자.**
  - 2,147,483,647 넘어가거나 2의 31제곱 넘어갈 때
  - 2,147,483,648 이하이거나 2의 31제곱 -1 이하일 때
- 길이 확인 메서드
```java
int l1 = string.length();
int l2 = list.size();
int l3 = array.length;
```
- Integer.toString(int): int to string
- 문자열끼리 비교하는 거 주의하자!!!(문자열은 클래스야!) str1.equals(str2)
- StringTokenizer 학습 (문자열 분할할 때 완전 유용!)
```java
StringTokenizer st = new StringTokenizer(expression, "+-*", true); 
// "+", "-". "*"을 각각으로 구분자 취급하여 분할함. 
// 구분자를 토큰에 포함할 것인지 설정할 수 있음.
List<String> tokens = new ArrayList<>();
while (st.hasMoreTokens()) {
    tokens.add(st.nextToken());
}
```
- for 문에서 제한 조건을 리스트 size로 제한했지만 중간에 리스트 요소를 삭제하거나 추가한다면, i 업데이트 시켜주기!!

### 그 외 학습 내용
- 배열을 스트림으로: Arrays.stream(arr)
- while: 반목문 탈출 조건 성립하는지 다시 한 번 확인하자.
- main 클래스 밖에 새로운 클래스 선언 하려면 public 없이.
- 풀이 아이디어 떠올렸다면 해당 알고리즘 검증하는 시간 가지기. 정확히 동작하는지.
- 배열, 리스트의 총합
    - Arrays.stream(intArr).sum();
    - Arrays.stream(stringArr).mapToInt(Integer::parseInt).sum();
    - integerList.stream().mapToInt(Integer::intValue).sum(); // Integer -> int (sum 때문에)
