import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static class Ice {
        int x;
        int y;
        int amount;
        int minus;

        public Ice(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
            this.minus = minus;
        }

        public void setOneMinus() {
            minus++;
        }

        public void goTime() {
            amount -= minus;
            minus = 0;
            if (amount < 0) amount = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];

        Queue<Ice> q = new LinkedList<>();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                q.offer(new Ice(i, j, map[i][j]));
            }
        }

        int answer = 0;
        int year = 0;
        while (!q.isEmpty()) {
            year++;

            // 하나의 시행 (1년)
            for (int i = 0; i < q.size(); i++) {
                Ice ice = q.poll();

                // 사방 확인
                for (int j = 0; j < 4; j++) {
                    int nx = ice.x + dx[j];
                    int ny = ice.y + dy[j];

                    if (nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                    if (map[nx][ny] == 0) ice.setOneMinus();
                }

                q.offer(ice);
            }

            // 빙산 녹이기, 맵에도 반영해야 해..!
            boolean isNeeded = false;
            int size = q.size(); // 다 뽑아야 하기에..
            for (int i = 0; i < size; i++) {
                Ice c = q.poll();
                c.goTime();
                map[c.x][c.y] = c.amount;
                if (c.amount == 0) {
                    isNeeded = true;
                    continue;
                }
                q.offer(c);
            }

            // 빙산 bfs 확인하기
            if (isNeeded && !q.isEmpty() && bfs(q.peek(), n, m, map) != q.size()) { // 큐 비었는지 확인!!!, while에 있는 조건이 현재에는 영향을 미칠 수 없어!!
                answer = year;
                break;
            }

            // visited 초기화!!
            visited = new boolean[n][m];
        }

        System.out.println(answer);
    }

    public static int bfs(Ice ice, int n, int m, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {ice.x, ice.y});
        visited[ice.x][ice.y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];

                if (nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;

                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    cnt++;
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt;
    }
}

/*
2:52~

dfs bfs로 정답 상태인지 확인
    그렇지 않아도 될 듯? 각 빙산마다 사방이 뚤려있는지 확인하면 될  ㄴㄴ 아님 그렇지 않은 경우도 있음

300 300

언젠가는 빙산이 다 녹기 마련.
정답에 걸리지 않고 맵이 다 0으로 될 경우, 0 출력

10000개 X 10높이 = 십만
9,000,000,000

빙산 위치를 기억해둬야 할 듯.

반복문 -> 각 빙산 방문 하면서 뚤려 있는지 확인하기 (바로 녹이면 안됨!! -> 어떻게 구현? 변수를 하나 더 두기)
    어느 한 빙산이 없어지는 순간, bfs 작동 시켜보기 -> 이 때 개수가 남은 빙하 개수랑 다르면 답 출력해야함


 */
