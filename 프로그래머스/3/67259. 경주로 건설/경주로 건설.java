import java.util.*;

class Solution {
    private int[] dx = new int[]{-1, 0, 1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};
    
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dp = new int[n][n][4]; // 임시로 10 -> n으로 바꿔야 함 !
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int s = 0; s < dp[i][j].length; s++) {
                    dp[i][j][s] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 for (int s = 0; s < 4; s++) {
//                     if (dp[i][j][s] == Integer.MAX_VALUE) continue;
                    
//                     for (int next = 0; next < 4; next++) {
//                         int nx = i + dx[next];
//                         int ny = j + dy[next];
//                         if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
//                             continue;
//                         }
//                         if (board[nx][ny] == 1) continue;
//                         if (s == next) {
//                             dp[nx][ny][s] = Math.min(dp[nx][ny][s], dp[i][j][s] + 100);
//                         } else {
//                             dp[nx][ny][next] = Math.min(dp[nx][ny][next], dp[i][j][s] + 600);
//                         }
//                     }
//                 }
//             }
//         }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
        
            // 현재 좌표 dp 처리 
            for (int s = 0; s < 4; s++) {
                if (dp[x][y][s] == Integer.MAX_VALUE) continue;

                for (int next = 0; next < 4; next++) {
                    int nx = x + dx[next];
                    int ny = y + dy[next];
                    if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
                        continue;
                    }
                    if (board[nx][ny] == 1) continue;
                    if (s == next) {
                        if (dp[nx][ny][s] > dp[x][y][s] + 100) q.offer(new int[]{nx, ny});
                        dp[nx][ny][s] = Math.min(dp[nx][ny][s], dp[x][y][s] + 100);
                    } else {
                        if (dp[nx][ny][next] > dp[x][y][s] + 600) q.offer(new int[]{nx, ny});
                        dp[nx][ny][next] = Math.min(dp[nx][ny][next], dp[x][y][s] + 600);
                    }
                }
            }
        }
        
        int answer = dp[n - 1][n - 1][0];
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dp[n - 1][n - 1][i]);
        }
        
        return answer;
    }
}

/*
dp[행좌표][열좌표][방향]

  0
3   1
  2


지금 왼쪽으로 이동하는 케이스가 안 되는 듯 

모든 방향에 대해서 순회했지만 실패함 72점
다시 꼬불한 길이 나올 수도 있어서 그런 듯 
bfs로 탐색할 길을 보여줘야 할 듯 

피드백
1. bfs와 dp의 조합 
    bfs로 dp 갱신할 곳을 탐색해주고 dp로 이전 계산값 활용해서 갱신 
    dp로만 안 되는 이유는 이중 반복문으로 board 순회하면서 dp 갱신하게 되면 
    오른쪽 아래 정해진 방향으로 가게 되는데 
    거슬러 올라가는 경우들이 종종 있을 수 있기에 이 순회 방향으로 최소를 단정지을 수 없기 때문
*/
