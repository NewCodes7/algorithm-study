import java.io.*;
import java.util.*;

public class Main{
    private static int n, m, result = 0;
    private static int[][] graph;
    private static int[][] temp;
    private static int[] dx = {-1, 0, 1, 0}; // 이동시엔 이렇게!!
    private static int[] dy = {0, 1, 0, -1};

    public static void dfsVirus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) { // 행열로 생각해라!! xy!!
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    dfsVirus(nx, ny);
                }
            }
        }
    }

    public static int getScore() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    }

    public static void dfs(int count) {
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = graph[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        dfsVirus(i, j);
                    }
                }
            }

            int score = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 0) {
                        score++;
                    }
                }
            }

            result = Math.max(score, result);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    count += 1;
                    dfs(count);

                    graph[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        temp = new int[n][m];

        // 그래프 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);
     }
}
