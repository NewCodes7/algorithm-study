import java.io.*;
import java.util.*;

public class Main {
    private static int[][] graph;
    private static int n;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String c = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(c.charAt(j))); // 그걸로 저장됨 그 아스키코드?
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list); // 내림차순은? 정리 ㄱㄱ
        StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");
        for (int c : list) {
            sb.append(c + "\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        graph[x][y] = 2; // 처리된.

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                if (!(nx < 0 || nx > n-1 || ny < 0 || ny > n-1) && graph[nx][ny] == 1) {
                    graph[nx][ny] = 2; // 그래야 안에서 안겹칠듯.

                    q.offer(new int[] {nx, ny});
                }
            }
        }

        return cnt;
    }
}
