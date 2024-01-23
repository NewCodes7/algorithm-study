# 알고리즘 학습

### 그리디(탐욕법)
- 의미: 현재 상황에서 지금 당장 좋은 것을 선택하는 방법
- 그리디 공략법
  - 정당성 검토: 그리디로 문제의 해법을 발상했을 때, 그 해법이 정당한지 검토해보기. (논리적인 이유가 있을 것)
  - 유형 파악: 문제를 만났을 때 바로 문제 유형을 파악하기 어렵다면, 그리디인지 의심해보기.
  - 출제 패턴: 해당 문제에서 그리디가 최적의 해인 경우가 많음. (애매하게 그리디 섞어서 출제하진x)
- 내 생각: 생각보다 무식한 알고리즘이네..? 이를 막 휘둘러서는 안 되겠다. 검증되었을 때 사용하는 게 안전할 듯.

---

### 구현
- 의미: 머릿속에 있는 알고리즘을 소스코드로 바꾸는 과정
- 유형: 완전 탐색과 시뮬레이션 모두 구현의 핵심이 되는 경우가 많음.
  - 완전 탐색: 모든 경우의 수를 주저 없이 다 계산하는 해결 방법
  - 시뮬레이션: 문제에서 제시한 알고리즘을 한 단계씩 차례대로 직접 수행
- 피지컬: 구현 문제는 언어의 문법에 능숙하고 코드 작성 속도가 빨라야 함.

---

### DFS/BFS
#### 사전 개념
- 탐색: 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정
- 대표적인 탐색 알고리즘: DFS, BFS
- 스택: 박스 쌓기
- 큐: 대기 줄
- 재귀 함수: 내부적으로 스택 자료구조와 동일함. 따라서, 스택을 활용해야 하는 상당수 알고리즘은 재귀 함수를 이용해서 간편하게 구현할 수 있음.
- 그래프 개념
  - 그래프 탐색: 하나의 노드를 시작으로 다수의 노드를 방문하는 것
  - 노드(Node): 비유 - 도시 (정점이라고도 함.)
  - 간선(Edge): 비유 - 도로
  - 두 노드는 인접하다 = 두 노드가 간선으로 연결되어 있다
- 그래프 표현 방식
  - 인접 행렬
    - 의미: x, y 두 노드간의 연결을 graph[x][y]로 표현
    - 시간 복잡도: O(N^2) (노드 N^2만큼 필요)
    - 두 노드의 연결 체크: graph[x][y]의 값으로 직관적으로 확인 가능
    - 인접 노드 체크: N^2만큼 반복문을 돌아 확인 가능
    - 사용 tip: 간선이 많을 떄 사용
  - 인접 리스트
    - 의미: x, y 두 노드간의 연결을 graph<x>내에 y원소로 표현
    - 시간 복잡도: O(N) (간선의 개수)
    - 두 노드의 연결 체크: graph<x>의 원소에서 y가 나올 때까지 탐색
    - 인접 노드 체크: 각 리스트에 담겨 있는 원소 확인
    - 사용 tip: 간선이 적을 때 사용

#### DFS(Depth-First-Search) 깊이 우선 탐색
- 의미: 그래프에서 깊은 부부을 우선적으로 탐색하는 알고리즘.
- 기초: 스택 자료 구조에 기초함.

#### BFS(Breadth-First-Search) 너비 우선 탐색
- 의미: 가까운 노드부터 탐색하는 알고리즘.
- 기초: 큐 자료 구조에 기초함.
- 속도: 보통 DFS보다 BFS 구현이 좀 더 빠르게 작동함.

#### 문제 풀이 TIP

---
### 백트랙킹
- 의미: 탐색 알고리즘 중의 하나로, 노드가 특정 조건을 위배했을 때 되돌아가서 다른 노드 탐색하는 알고리즘
- 가지치기(pruning): 더 이상 탐색할 필요가 없는 노드를 제외
- 특징: DFS와 유사하며, 혼용하여 사용가능함. (재귀라는 맥락을 공유)
- 어떻게 보면 DFS는 백트랙킹의 일종임. 
- 사용처
  - 순열, 조합 (가능한 모든 조합을 찾아야 할 때)



---



---

### 이진 탐색
- 소스코드
```java
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        return -1;
    }
```
- 순차 탐색
  - 의미: 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법
  - 사용처: 보통 정렬되지 않은 리스트에서
  - 시간 복잡도: O(N)
- 이진 탐색
  - 의미: 찾으려는 데이터(target)와 중간점 위치에 있는 데이터(mid)를 반복적으로 비교해서 원하는 데이터를 찾는 방법
  - 사용처: 보통 정렬된 리스트에서, 탐색 범위가 큰 상황에서(ex. 10억) (큰 수를 보면 당연하듯이 가장 먼저 이진 탐색을 떠올릴 것!)
  - 요소: 변수 3개 이용(start, mid, end)
  - 시간 복잡도: O(logN)
  - 구현: 재귀 함수 혹은 반복문을 사용
  - '파라메트릭 서치' 유형 해결 가능
    - 의미: 최적화 문제를 결정 문제로 바꾸어 해결하는 기법
    - 결정 문제: 예 혹은 아니오로 답하는 문제
    - 사용처: 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제 (가장 큰, 가장 작은 등 최적화 요구)

---

### 다이나믹 프로그래밍 (동적 계획법)
- 의미: 메모리를 적절히 사용하여 수행 시간 효율성을 비약적으로 향상시키는 방법
- 원리: 이미 계산된 결과(작은 문제)를 별도의 메모리 영역에 저장하여 필요할 때 재활용함.
- 조건: 큰 문제를 동일한 작은 문제로 나누어 풀 수 있는가?
  - 최적 부분 구조: 큰 문제를 작은 문제로 나눌 수 있으며 작은 문제의 답을 모아서 큰 문제를 해결
  - 중복되는 부분 문제: 동일한 작은 문제를 반복적으로 해결
- 방식
  - 탑다운(하향식)
    - 메모이제이션
      - 의미: 한 번 계산한 결과를 메모리 공간에 메모하는 기법
      - 다이나믹 프로그래밍을 구현하는 방법 중의 하나
      - 값을 기록해 놓는다는 점에서 캐싱(Caching)이라고도 함.
  - 보텀업(상향식) !!
    - 다이나믹 프로그래밍의 전형적인 형태
    - DP 테이블: 결과 저장용 리스트
- 문제 접근 방법
  - 가장 먼저 그리기, 구현, 완전 탐색 등으로 아이디어 생각해보기
    - 다른 알고리즘이 떠오르지 않는다면 다이나믹 프로그래밍 고려
  - 우선 재귀함수로 풀이 시도(탑다운). 동일한 작은 문제가 발견되면 리팩토링.

### LIS(Longest Increasing Subsequence) 최장 증가 부분 수열
- 의미: 특정 수열에서 오름차순으로 정렬된 가장 긴 부분 수열을 찾는 알고리즘
- 풀이 종류
  - dp
  - 이진탐색
- 원리: 각 원소의 지위, 랭크를 매기는 작업을 선행함. 
  - 해당 원소에서 그 다음으로 올 수 있는 원소들을 dp에서 +1로 표시하는 것.
- 결과: dp 배열에서 가장 큰 값이 최장 증가 부분 수열의 길이임.
- 소스코드
```java

//dp 배열 1로 초기화

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (list.get(j) < list.get(i)) { // dp자리 아니라 수열 자리다!! 조심
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
```

---

### 최단 경로
#### 다익스트라 알고리즘
- 의미: 특정한 노드에서 출발하여 다른 모든 노드로 가는 최단 경로를 계산함.
- 동작 조건: 음의 간선이 없을 때
  - 현실 세계의 도로(간선)은 음의 간선으로 표현되지 않음.
- 분류: 그리디 알고리즘으로 분류됨.
  - 매 상황에서 가장 비용이 적은 노드를 선택해 임의의 과정을 반복함.
- 동작 **과정**
  1. 출발 노드 설정
  2. 최단 거리 테이블 초기화
  3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드 선택
  4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
  5. 위 과정에서 3, 4번 반복
- 특징
  - 그리디: 매 상황에서 방문하지 않았으면서 가장 비용이 적은 노드를 선택해 임의의 과정을 반복함.
  - 다이나믹 프로그래밍 기반: 단계를 거치며 한 번 처리된 노드의 최단 거리는 고정되어 변동되지 않음.
    - 한 단계당 하나의 노드에 대한 최단 거리를 확실히 찾는 것으로 이해할 수 있음.
  - 테이블: 각 노드까지의 최단 거리 정보가 저장됨.
    - 완벽한 형태의 최단 거리 정보를 구현하려면 소스코드에 추가적인 기능을 포함해야 함.
- 간단한 구현 방법
  - 시간 복잡도: O(V^2)
    - V: vertex(정점)이며 그래프 알고리즘에서 노드의 개수를 나타냄.
    - N: 자료구조의 크기나 배열의 길이를 나타냄.
    - 최단 거리가 가장 짧은 노드 선택: O(V) 걸림.
    - 한계: 노드의 개수가 10000개가 넘는다면 불리함.
  - 소스코드 // 접는 방법?
```java
import java.util.*;

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    public static boolean[] visited = new boolean[100001];
    // 최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}
```

- 개선된 알고리즘(우선순위 큐)
  - 시간 복잡도: O(ElogV)  (E: 간선의 개수) (성능이 잘 이해 안 됨. 다시 봐보기)
  - 소스코드
```java
import java.util.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); // 현재 노드까지의 비용 
            int now = node.getIndex(); // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}
```

#### 플로이드 워셜 알고리즘
- 의미: 모든 노드에서 다른 모든 노드까지의 최단 경로를 계산함.
- 정보 저장: 2차원 테이블에 최단 거리 정보 저장함.
- 과정
  - 다익스트라 알고리즘처럼 단계 별로 거쳐가는 노드를 기준으로 수행함.
  - 다만, 매 단계 방문하지 않은 노드 중 최단 거리를 갖는 노드를 찾는 과정은 불필요함.
- 시간 복잡도: O(N^3)
- 점화식
  <img width="765" alt="스크린샷 2024-01-11 오후 4 17 21" src="https://github.com/NewCodes7/algorithm-study/assets/123712285/6b04835d-6e8e-4163-b3d1-3b42be466e5d">
- 소스코드
```java
import java.util.*;

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M)
    // 노드의 개수는 최대 500개라고 가정
    public static int n, m;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
```
