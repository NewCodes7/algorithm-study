import java.util.*;

class Solution {
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            bfs(i, n, computers);
            answer++;
        }
        
        return answer;
    }
    
    public static void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while (!q.isEmpty()) {
            int c = q.poll();
            visited[c] = true;
            for (int i = 0; i < n; i++) {
                if (i == c || visited[i]) continue;
                if (computers[c][i] == 1 || computers[i][c] == 1) {
                    q.offer(i);
                }
            }
        }
        
    }
    
}

// bfs를 여러번 (1번부터 n-1번까지) visited검사
    // 해당 idx 노드  큐 넣기 
    // while 반복하기 
        // 방문처리하기
        // 각 노드에 따라 가로줄과 세로줄 탐색 후 큐에 넣기
// answer++