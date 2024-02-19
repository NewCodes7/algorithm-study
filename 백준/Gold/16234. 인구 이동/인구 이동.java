import java.io.*;
import java.util.*;

public class Main {
    private static int n, l, r;
    private static int[][] map;
    private static List<int[]> union = new ArrayList<>();
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = -1;
        boolean isGoing = true;
        while (isGoing) {
            isGoing = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int unionCnt = move(new int[] {i, j});
                        if (unionCnt != 1) {
                            isGoing = true;
                        }
                        union.clear();
                    }
                }
            }

            cnt++;
            visited = new boolean[n][n];
        }

        //했던 곳을 다시? 아 한 번의 시행에서 여러 연합군이 있을 수 있음.
        System.out.println(cnt);
    }

    public static int move(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true; // false일 때로 인자 넘겨야함.

        int total = map[start[0]][start[1]];
        int cnt = 1;
        union.add(new int[] {start[0], start[1]});

        while(!q.isEmpty()) {
            int[] c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                if (nx < 0 || nx > n-1 || ny < 0 || ny > n-1) continue;
                if (visited[nx][ny]) continue;

                int differ = Math.abs(map[c[0]][c[1]] - map[nx][ny]);
                if (differ >= l && differ <= r) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                    total += map[nx][ny];
                    cnt++;
                    union.add(new int[] {nx, ny});
                }
            }
        }

        // 평균내기
        if (cnt != 1) { // 이거 빠뜨림 ㅠㅠ
            for (int i = 0; i < union.size(); i++) {
                int avg = total / cnt;
                map[union.get(i)[0]][union.get(i)[1]] = avg;
            }
        }

        return cnt;
    }
}