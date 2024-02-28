import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static class Tomato {
        int x;
        int y;
        int time;

        public Tomato(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean isAllChecked = true;
        List<Tomato> tomatoList = new ArrayList<>();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //토마토인것 저장해두기
                if (map[i][j] == 1) {
                    tomatoList.add(new Tomato(i, j, 0));
                }
                if (map[i][j] == 0) {
                    isAllChecked = false;
                }
            }
        }

        // 처음부터 다 익었을 경우
        if (isAllChecked) {
            System.out.println(0);
            return;
        }

        int answer = bfs(tomatoList, n, m);

        // 다 익을 수 없는 경우
        for (int[] a : map) {
            for (int b : a) {
                if (b == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(List<Tomato> tomatoList, int n, int m) {
        Queue<Tomato> q = new LinkedList<>();
        for (Tomato t : tomatoList) {
            q.offer(t);
        }

        // 가장 높은 시간 처리해야 함.
        int maxTime = 0;

        while (!q.isEmpty()) {
            Tomato t = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;

                if (map[nx][ny] == 0) { // visited 안 써도 될 듯. 1로 처리
                    q.offer(new Tomato(nx, ny, t.time+1));
                    map[nx][ny] = 1; // 이것
                    maxTime = Math.max(maxTime, t.time+1);
                }
            }
        }

        return maxTime;
    }
}

/*
2:45~
x,y바뀐거 조심!

1인 것 처음에 저장해두고 큐에 넣어두기

bfs
0인것만 주워

0이 없어야 다익음.

불필요하게 큐에 넣지 말아야 함. visited로 관리.

시간은 어떻게 컨트롤? int로
 */
