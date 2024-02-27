import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, l, r;
    private static int[][] graph;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n]; // 이거 빼먹엏서 Null에러 이런 거 빼먹지 좀 마!
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true) {
            boolean isMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        boolean temp = bfs(new int[] {i, j});
                        if (temp) isMoved = true;
                    }
                }
            }

            if (isMoved) {
                visited = new boolean[n][n];
                time++;
            } else {
                break;
            }
        }

        System.out.println(time);
    }

    public static boolean bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        boolean isMoved = false;
        Queue<int[]> moveList = new LinkedList<>();
        moveList.offer(start);
        int total = graph[start[0]][start[1]];

        while (!q.isEmpty()) {
            int[] c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];

                if (nx < 0 || nx > n-1 || ny < 0 || ny > n-1) continue;

                if (!visited[nx][ny]) {
                    int diff = Math.abs(graph[c[0]][c[1]] - graph[nx][ny]);
                    if (diff >= l && diff <= r) {
                        int[] next = new int[]{nx, ny};

                        total += graph[nx][ny];
                        moveList.offer(next);
                        q.offer(next);
                        visited[nx][ny] = true;
                        isMoved = true;
                    }
                }
            }
        }

        move(total, moveList);

        return isMoved;
    }

    public static void move(int total, Queue<int[]> q) {
        int avg = total / q.size();

        while (!q.isEmpty()) { // good
            int[] c = q.poll();
            graph[c[0]][c[1]] = avg;
        }
    }
}