# 자료구조
## 종류
1. 배열
2. 리스트
3. 맵
4. 셋
5. 스택
6. 큐, 힙
7. 트리


### 우선순위 큐
- 의미: 우선순위가 가장 높은 데이터를 가장 먼제 삭제하는 자료구조
- 조건: 우선순위 큐에 저장할 객체는 Comparable Interface를 구현해야 함. compareTo를 오버라이딩하여 우선순위 조건을 리턴하면 됨.
- 내부: 해당 큐를 구현하기 위해 여러 자료구조를 사용하는데 그 중에 힙을 사용함.
- 원리
  - 이진트리를 이용함.
  - 삽입하고 나서, 부모보다 작다면 교체함.
  - 추출하고 나서, 마지막 원소와 자리 바꾼 뒤, 교체 진행함.
- 선언
  - PriorityQueue<type> pq = new PriorityQueue<>(); (우선순위가 낮은 숫자 순)
  - PriorityQueue<type> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
  - ```java
      absPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
          if (Math.abs(o1) == Math.abs(o2)) { //절대값이 같다면
              return o1 - o2; // 값 자체로 비교해서 오름차순
          } else {
              return Math.abs(o1) - Math.abs(o2); // 아니면 절대값으로 비교해서 오름차순
          }
      }
      }); 
  - ```


### 힙(Heap)
- 최소힙: 최솟값이 우선순위인 큐
- 최대힙: 최댓값이 우선순위인 큐
- 삽입 및 삭제 시간 복잡도: O(logN) // 왜?

### 스택(Stack)
- 의미: 후입선출
  - 후입: 가장 나중에 들어온 게 (Last In)
  - 선출: 먼저 나간다. (First out)
  - 선언 : Stack<> s = new Stack<>();
- 메서드
  - add(): 값 삽입
  - pop(): 값 추출 (반환)
  - isEmpty(): 비어있는지 확인
  - size(): 개수 반환
  - peek(): 값만 반환 (스택에 영향 주지 않음.)
  - 🔥 search()
    - 메서드 인자 검색하여 해당 위치(빠져나오는 순서) 반환
    - 해당 인자가 여러 개일 경우, 마지막 위치(가장 빨리 빠지는) 반환
    - 값이 없을 경우, -1 반환

### 큐(Queue)
- 의미: 선입선출
  - 선입: 가장 먼저 들어간 게 (First In)
  - 선출: 먼저 나간다. (First out)
  - 선언: Queue<> q = new LinkedList<>();
- 메서드
  - add()
  - poll()
  - isEmpty()

### 덱(Deque)
- 의미: 큐의 양쪽에서 삽입과 삭제 가능한 자료구조
- 특징: 스택처럼, 혹은 큐처럼 활용할 수도 있음. 
- 선언: Deque<> d = new ArrayDeque<>();
- 메서드
  - addFirst()
  - addLast()
  - pollFirst()
  - pollLast()
  - peekFirst()
  - peekLast()
