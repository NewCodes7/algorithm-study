import java.util.*;

class Solution {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        bfs(maps);
        int answer = maps[maps.length-1][maps[0].length-1];
        if (answer == 1) {
            return -1;
        }
        return answer;
    }
    
    public static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                
                if (nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1) continue;
                if (maps[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    maps[nx][ny] = maps[c[0]][c[1]] + 1;
                }
            }
        }
    }
}

/*
12:03 ~ 

최단 거리이니까 bfs
(이런 경우는 dfs로 풀어도 됨. 인접 행렬 위에서 이동하는 경우.. 하지만, 인접 리스트에서 이동할 때는 dfs사용 x)

bfs 0,0 시작
1이면 가. 1이 아니면 가지마.
갔다면, 거리 업데이트 
(출발지 따로 숫자 설정 0으로?)
*/