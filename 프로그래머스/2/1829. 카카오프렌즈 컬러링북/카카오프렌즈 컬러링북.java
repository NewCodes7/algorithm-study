import java.util.*;

class Solution {
    private static boolean[][] visited;
    private static int numberOfArea;
    private static int maxSizeOfOneArea;
    private static int a;
    private static int b;
    private static int[] dx;
    private static int[] dy;
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        a = m; 
        b = n;
        visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                visited[i][j] = false;
            }
        }
        
        // 방문되지 않은 걸로 bfs에 넘겨주기 0 아닌 걸로
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(picture, i, j);
                    numberOfArea++;
                }
            }
        }

        // 정답 처리
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public static void bfs(int[][] picture, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int areaCount = 1;
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                
                if (nx < 0 || nx >= a || ny < 0 || ny >= b) continue; // 주의
                
                if (!visited[nx][ny] && picture[c[0]][c[1]] == picture[nx][ny]) {
                    
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    areaCount++;
                }
            }
        }
        
        maxSizeOfOneArea = Math.max(areaCount, maxSizeOfOneArea);
    }
}

/*
[1, 1, 1, 0]
[1, 2, 2, 0]
[1, 0, 0, 1]
[0, 0, 0, 1]
[0, 0, 0, 3]
[0, 0, 0, 3]

bfs를 여러 번 하면 될 듯.
*/