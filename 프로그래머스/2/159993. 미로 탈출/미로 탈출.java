import java.util.*;

class Solution {
    private static int[][] d, graph;
    private static int n, m;
    private static boolean[][] visited;
    private static int[] start, lever, exit;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        d = new int[n][m];
        visited = new boolean[n][m];
        graph = new int[n][m];
        
        // 그래프 전처리 - 구분 필요없었네 그냥 지나갈 수 있는 길이면 다 1로 해도 됐었음. d도 따로 선언 안 하고.
        for (int i = 0; i < n; i++) {
            String[] arr = maps[i].split("");
            for (int j = 0; j < m; j++) {
                int c = 1;
                if (arr[j].equals("X")) c = 0;
                if (arr[j].equals("S")) start = new int[]{i, j};
                if (arr[j].equals("L")) lever = new int[]{i, j};
                if (arr[j].equals("E")) exit = new int[]{i, j};
                graph[i][j] = c;
            }
        }
        
        bfs(start);
        int time1 = d[lever[0]][lever[1]];
        if (time1 == 0) return -1;
        
        // visited 초기화, d배열 초기화
        visited = new boolean[n][m];
        d = new int[n][m];
        
        bfs(lever);
        int time2 = d[exit[0]][exit[1]];
        if (time2 == 0) return -1;
    
        return time1 + time2;
    }
    
    public static void bfs(int[] arr) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(arr);
        visited[arr[0]][arr[1]] = true;
        
        while (!q.isEmpty()) {
            int[] c = q.poll(); // 레버 맞으면 빨리 중단 가능 
            
            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                
                if (nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                
                if (!visited[nx][ny] && graph[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    d[nx][ny] = d[c[0]][c[1]]+1;
                }
            }
        }
    }
}


/*
2:23~2:47  지금까지 30분 3~4분 검토

bfs
-1

s - 1
o - 1
x - 0
e - 3
l - 2

d배열 따로
visited

1(s) -> 2 일단 최단 경로로 레버로 가야해. 이것부터도 못가면 -1빨리 반환
visited 초기화 
2 -> 3 그다음 레버에서 도착지까지 최단경로

결국 bfs 2번 하면 됨. 우선 레버가는 데까지 구현해보자.
*/