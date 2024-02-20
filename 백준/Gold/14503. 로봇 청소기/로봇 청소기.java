import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] robot = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int shift = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cleaned = 0;
        while(true) {
            // 1. 현재 칸 청소 안 되어 있으면 청소
            if (map[robot[0]][robot[1]] == 0) {
                map[robot[0]][robot[1]] = 2; // 2: 청소완료
                cleaned++;
            }

            // 2. 주변 4칸 탐색 -> 청소할 게 있냐?
            boolean isAvailableClean = false;
            for (int i = 0; i < 4; i++) {
                int nx = robot[0] + dx[i];
                int ny = robot[1] + dy[i];
                if (map[nx][ny] == 0) {
                    isAvailableClean = true;
                    break; // 내부만
                }
            }

            if (!isAvailableClean) {
                robot[0] -= dx[shift];
                robot[1] -= dy[shift];
                if (map[robot[0]][robot[1]] == 1) break; // 이걸 빠뜨림.
            } else {
                shift -= 1;
                if (shift == -1) shift = 3;
                int nx = robot[0] + dx[shift];
                int ny = robot[1] + dy[shift];
                if (map[nx][ny] == 0) {
                    robot[0] += dx[shift];
                    robot[1] += dy[shift];
                }
            }
        }

        System.out.println(cleaned);
    }
}