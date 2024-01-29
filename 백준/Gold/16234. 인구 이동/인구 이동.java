import java.io.*;
import java.util.*;

public class Main {
    private static int l, r, n;
    private static int cnt = -1;
    private static boolean isUnited = true;
    private static boolean[][] visited;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (isUnited) {
            isUnited = false;
            visited = new boolean[n][n]; // 방문 초기화!!
            map = open(map);
            cnt++;
        }

        System.out.println(cnt);
    }

    public static int[][] open(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    List<int[]> union = new ArrayList<>();
                    dfs(map, i, j, union);
                    map = sum(map, union);
                    if (union.size() != 1) {
                        isUnited = true;
                    }
                }
            }
        }

        return map;
    }

    public static void dfs(int[][] map, int x, int y, List<int[]> union) {
        visited[x][y] = true;
        union.add(new int[] {x, y, map[x][y]});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > map.length - 1 || ny < 0 || ny > map.length - 1) {
                continue;
            }

            int differ = Math.abs(map[x][y] - map[nx][ny]);
            if (!visited[nx][ny] && differ >= l && differ <= r) { // 이상!!
                dfs(map, nx, ny, union);
            }
        }
    }

    public static int[][] sum(int[][] map, List<int[]> union) {
        int sum = 0;
        int people = 0;
        for (int[] c : union) {
            people += c[2];
        }

        for (int[] c : union) {
            map[c[0]][c[1]] = people / union.size();
        }

        return map;
    }

}