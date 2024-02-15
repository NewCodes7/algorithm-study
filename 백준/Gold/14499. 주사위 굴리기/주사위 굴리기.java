import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {0, 0, 0, -1, 1};
    private static final int[] dy = {0, 1, -1, 0, 0};
    private static int[] dice;
    private static int[] point;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[7];
        point = new int[] {x, y};
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int[] order = new int[k];
        int ceil = dice[6];
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            ceil = moveDice(order[i], point);
            if (ceil != -1) {
                sb.append(ceil).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static int moveDice(int order, int[] point) {
        int x = point[0] + dx[order];
        int y = point[1] + dy[order];
        if (x < 0 || x > map.length-1 || y < 0 || y > map[0].length-1) {
            return -1;
        }

        if (order == 1) {
            int dice1 = dice[1];
            dice[1] = dice[3]; // 내(3)가 이제 아랫면이야!
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = dice1;
        }

        if (order == 2) {
            int dice1 = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = dice1;
        }

        if (order == 3) {
            int dice1 = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = dice1;
        }

        if (order == 4) {
            int dice1 = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = dice1;
        }

        point[0] = x;
        point[1] = y;
        if (map[point[0]][point[1]] != 0) { // 주사위에 복사
            dice[1] = map[point[0]][point[1]];
            map[point[0]][point[1]] = 0;
        } else {
            map[point[0]][point[1]] = dice[1];
        }

        return dice[6];
    }

            /*
          2
        4 1 3
          5
          6
         */

    // 지도 0이라면 주사위가 지도에 복사
    // 지도 0아니라면 지도가 주사위에 복사 (지도 칸은 0으로)
    // 바깥은 출력무시
    // 주사위 윗면 출력

    // 문제에서 주어진 자료를 최대한 활용해야 한다!! 출제의도! 괜히 주지 않아.
    // 이런 문제도 있다. 전처리가 더 무거운 문제.
}