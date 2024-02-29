import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[101][101]; // 0<= x <= 100
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] dragon = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            makeDragon(dragon, map);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void makeDragon(int[] dragon, boolean[][] map) { // x, y, d, g
        // 방향정보 수집
        List<Integer> shifts = new ArrayList<>();
        shifts.add(dragon[2]); // 방향 정보 삽입
        for (int idx = 0; idx < dragon[3]; idx++) {
            int start = shifts.size() - 1;
            for (int i = start; i >= 0; i--) {
                shifts.add((shifts.get(i) + 1) % 4);
            }
        }

        // 색칠하기 (or 동시에)
        int x = dragon[0];
        int y = dragon[1];
        map[x][y] = true;
        for (int i = 0; i < shifts.size(); i++) {
            x += dx[shifts.get(i)];
            y += dy[shifts.get(i)];
            map[x][y] = true;
        }
    }
}

/*
9:34~
0: x좌표가 증가하는 방향 (→)
1: y좌표가 감소하는 방향 (↑)
2: x좌표가 감소하는 방향 (←)
3: y좌표가 증가하는 방향 (↓)

0세대 0
1세대 1 (0 / 1)
2세대 2 1 (0, 1 / 2, 1)
3세대 2 3 2 1 (0, 1, 2, 1 / 2 3 2 1)

3 -> 0

데칼코마니 1씩 증가.

 */
