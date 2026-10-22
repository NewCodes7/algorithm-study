import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];
            graph.get(x).add(new int[]{y, cost});
            graph.get(y).add(new int[]{x, cost});
        }
        // System.out.println(graph);

        int[] distS = dijkstra(s, graph);
        int[] distA = dijkstra(a, graph);
        int[] distB = dijkstra(b, graph);
        // System.out.println(Arrays.toString(distS));

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < distS.length; i++) {
            int distSum = distS[i] + distA[i] + distB[i];
            if (distSum != 0) {
                answer = Math.min(answer, distSum);
            }
        }

        return answer;
    }

    private int[] dijkstra(int start, List<List<int[]>> graph) {
        int[] answer = new int[graph.size()]; // 각 지점별 최소거리
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            // 음 이럴 때 인접리스트가 더 유리하네. 한 지점과 연결된 다른 모든 지점을 찾고 싶을 때
            List<int[]> connected = graph.get(curr);
            for (int i = 0; i < connected.size(); i++) {
                int[] c = connected.get(i);
                int cost = answer[curr] + c[1];
                if (c[0] != start && answer[c[0]] == 0 || cost < answer[c[0]]) {
                    answer[c[0]] = cost;
                    queue.offer(c[0]);
                }
            }
        }

        return answer;
    }
}

/*
10:24~11:13 설계만 30분 구현 19분
설계에 쫄지 말아야 하는 이유!!
처음에는 어떻게 풀 지 막막했는데 그래도 마지막 설계에서 갈 길 보여서 금방 구현한 듯

피드백
1. 다익스트라 정리하기
   다익스트라 내가 구현한 알고리즘이 맞나?
2. 풀이 태도 정립: 설계에 집중!! sol1, sol2 등등 여러 풀이한 구분해서 고안하기
3. 한 정점과 연결된 다른 모든 정점을 보고 싶다면 인접 리스트가 유리함
   반대로 인접 행렬이 유리한 경우가 있나?
4. 더 좋은 다른 풀이도 있나?

무지 -> 어피치
합승을 하지 않아도 됨
결국 구하고자 하는 건 무지 + 어피치 최소

인접행렬로 그래프 표현하는 게 깔끔할 듯 n이 크지도 않으니까
시간 효율 좋으니 (인접 리스트보다 얼마나 더 좋지?)

1. fares 순회 -> 인접행렬 만들기
2. 최저 합산 찾기

fares 배열 크기는 최대 20000

sol1) 모든 경우의 수 탐색
A, B 가능한 경우를 모두 구하고
A, B 각 경우의 수에 대해서 겹치는 구간 보면서 합산 구하기

sol2) DP & BFS
dp로 각 지점에 대해 a, b 합산 최저 구하기 (과정은 안 필요하니)
그리고 합승인지 아닌지를 구분해서
배열을 두 개 두기
   동승버전: int[][] 장소를 index로 삼고, [비용]
   개별버전: int[][] 장소를 index로 삼고, [a비용, b비용]
큐를 두고 주변 이웃 가는 거 더 싼게 있다면 큐 삽입
   주변 이웃 중 어느 것보다도 비싸면 그 순간 멈추기
   int[] 삽입 {현재 노드, 비용, a인지b인지}?
그 지점에 대해서 a에 대한 최소인지, b에 대한 최소인지를 구분해야 할 듯

음.. 뭔가 애매하다 실제로 될 것 같지가 않은데
동승이었다가 아니었다가 동승이었다가 등등..

sol3) 동승 끝난 지점을 미리 정해두기 (최대 200개)
그러면 다익스트라로 바꿀 수 있다
A에서 출발했을 때 각 지점까지의 최단 거리
B에서 ,,
다익스트라 어떻게 구현하더라? bfs처럼 하되 그걸 메모해두면 되려나

1. 출발지에서 각 동승 지점까지의 최소 비용 계산
   다익스트라

2. a와 b 각각에서 각 동승 지점까지의 최소 비용 계산
   다익스트라

3. 더 해서 최소인 것 찾기

*/
