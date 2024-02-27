import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int answer = 0;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        int count = 0;
        for (int i = 0; i < costs.length; ++i) {
            int v1 = costs[i][0];
            int v2 = costs[i][1];
            int cost = costs[i][2];

            // 두 정점 연결 확인
            boolean isConnected = false;
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v1);
            visited[v1] = true;

            while (!queue.isEmpty()) {
                int src = queue.poll();

                for (int next : graph[src]) {
                    if (next == v2) {
                        isConnected = true;
                        break;
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }

            // 연결안 되어 있지 않은 경우 간선 적용
            if (!isConnected) {
                graph[v1].add(v2);
                graph[v2].add(v1);
                answer += cost;
            }

            if (count == n) {
                break;
            }
        }

        return answer;
    }
}
