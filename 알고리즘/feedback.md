
## 각종 학습 내용
- 배열을 스트림으로: Arrays.stream(arr)
- while: 반목문 탈출 조건 성립하는지 다시 한 번 확인하자.
- main 클래스 밖에 새로운 클래스 선언 하려면 public 없이.
- 풀이 아이디어 떠올렸다면 해당 알고리즘 검증하는 시간 가지기. 정확히 동작하는지.
- 배열, 리스트의 총합
    - Arrays.stream(intArr).sum();
    - Arrays.stream(stringArr).mapToInt(Integer::parseInt).sum();
    - integerList.stream().mapToInt(Integer::intValue).sum(); // Integer -> int (sum 때문에)
- Wrapper class
  - char -> Character
  - boolean -> Boolean
  - long -> Long
- 연산하다가 소수점 나올 수 있는 거 고려해라.. 반올림이랑 올림 뭐가 필요한지.. 특히 올림이라면.
  - 🔥 아래 메서드는 double을 인자로 받고 double로 반환함.
  - Math.ceil(): 올림
  - Math.floor(): 내림
  - Math.round(): 반올림
  ```java
  int num = (int) Math.ceil((double) 10.1);
  ```
