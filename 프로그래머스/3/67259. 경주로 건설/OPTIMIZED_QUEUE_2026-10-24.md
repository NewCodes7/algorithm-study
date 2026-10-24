# 경주로 건설 — 개선 예시 (2026-10-24)

> **어시스턴트가 제안한 개선 예시이며 사용자 직접 풀이가 아닙니다.** 사용자 원본은 [경주로 건설.java](./경주로 건설.java)에 그대로 보관.

## 차이점

1. `Arrays.fill`로 3차원 배열 초기화.
2. `newCost`로 비용 전이 통합.
3. `inQueue`로 큐 내 같은 좌표 중복 삽입 방지. `poll` 직후 false로 복원.
4. 미사용 `visited` 제거.

~~~java
import java.util.*;

class Solution {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dp = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        dp[0][0][1] = 0;
        dp[0][0][2] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] inQueue = new boolean[n][n];
        q.offer(new int[]{0, 0});
        inQueue[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            inQueue[x][y] = false;

            for (int s = 0; s < 4; s++) {
                if (dp[x][y][s] == Integer.MAX_VALUE) continue;

                for (int next = 0; next < 4; next++) {
                    int nx = x + dx[next];
                    int ny = y + dy[next];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (board[nx][ny] == 1) continue;

                    int newCost = dp[x][y][s] + (s == next ? 100 : 600);
                    if (newCost < dp[nx][ny][next]) {
                        dp[nx][ny][next] = newCost;
                        if (!inQueue[nx][ny]) {
                            q.offer(new int[]{nx, ny});
                            inQueue[nx][ny] = true;
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int s = 0; s < 4; s++) {
            answer = Math.min(answer, dp[n - 1][n - 1][s]);
        }
        return answer;
    }
}
~~~
