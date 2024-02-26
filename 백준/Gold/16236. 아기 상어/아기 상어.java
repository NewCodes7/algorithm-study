import java.io.*;
import java.util.*;

public class Main {
    private static int[][] graph;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[] shark;
    private static int n;
    private static int dist = Integer.MAX_VALUE;
    private static boolean[][] visited;
    private static List<int[]> fishes = new ArrayList<>(); // 할당!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        // 그래프 입력
        visited = new boolean[n][n];
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) shark = new int[]{i, j, 2, 0}; // 좌표, 크기, 스택
            }
        }

        int time = 0;
        while(true) {
            bfs(new int[]{shark[0], shark[1], 0});

            int x = n;
            int y = n;

            if (!fishes.isEmpty()) {
                if (fishes.size() == 1) {
                    x = fishes.get(0)[0];
                    y = fishes.get(0)[1];
                } else { // 물고기가 여러 개라면
                    for (int i = 0; i < fishes.size(); i++) {
                        // 아... fishes에는 depth가 다 다를 수 있음!!! dfs이기에 최단 거리가 아닌 fish가 먼저 add될 수 있음!!
                        if (dist != fishes.get(i)[2]) continue;
                        int x2 = fishes.get(i)[0];
                        int y2 = fishes.get(i)[1];
                        if (x2 < x) {
                            x = x2;
                            y = y2;
                        }
                        if (x2 == x) {
                            if (y2 < y) { // 아.. 여기!!! y를 n이라 해버림
                                y = y2;
                            }
                        }
                    }
                }

            } else {
                break;
            }

            // 지도 상의 상어 위치 업데이트
            graph[shark[0]][shark[1]] = 0;
            graph[x][y] = 9; // 0, 1이어야 하는데 0,0이 됨.

            time += dist; // 시간 업데이트
            shark[0] = x; // 상어 위치 업데이트
            shark[1] = y;

            shark[3]++; // 물고기 먹기
            if (shark[3] == shark[2]) { // 레벨업
                shark[2]++;
                shark[3] = 0;
            }

            // 초기화
            fishes.clear();
            dist = Integer.MAX_VALUE;
            visited = new boolean[n][n];
        }

        System.out.println(time); // 아.. 여기서..
    }

    public static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0];
            int y = c[1];
            int depth = c[2];


            if (depth != 0) { // 상어 크기 때문에
                if (graph[x][y] > shark[2] || depth > dist) { // 못지나가거나, 더 멀다면 종료
                    continue; // break가 아닌 continue
                }

                if (graph[x][y] < shark[2] && graph[x][y] != 0) { // 물고기 일단 저장
                    fishes.add(new int[] {x, y, depth});

                    dist = depth;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];

                if (!(nx < 0 || nx > n-1 || ny < 0 || ny > n-1)) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, depth+1});
                    }
                }
            }
        }
    }

    public static void dfs(int depth, int x, int y) {
        if (depth != 0) { // 상어 크기 때문에
            if (graph[x][y] > shark[2] || depth > dist) { // 못지나가거나, 더 멀다면 종료
                return;
            }

            if (graph[x][y] < shark[2] && graph[x][y] != 0) { // 물고기 일단 저장
                fishes.add(new int[] {x, y, depth});
                dist = depth;
            }
        }


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!(nx < 0 || nx > n-1 || ny < 0 || ny > n-1)) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(depth+1, nx, ny);
                    visited[nx][ny] = false; // 백트랙킹!!! 복원!!!

                }
            }
        }
    }
}

/*
아기 상어 상태 - 좌표, 크기
게임 상태 - 아기상어보다 작은 물고기가 잇는가?, 그 물고기까지 갈 수 있는가?

그래프 입력 받기 - 아기 상어 위치 확인,

while(자신보다 작은 물고기가 있을 동안만)
그래프 탐색: 먹을 수 있는 물고기인지 확인(크기 작은가?, 갈 수 있는가?)  & 가장 가까이 있는 물고기 확인
bfs - visited이용해서 하나씩 방문
    가는 도중 큰 물고기가 있다면 break;
    작은 물고기 만났다면 move & eat -> if (isChecked) return;
        다른 물고기가 있는지 확인 - 가장 위, 왼쪽 선택
        시간 초 계산

    작은 물고기를 만났더라도 같은 거리에 있는 물고기 더 탐색해야 함. - continue ( 찾은 depth보다 크다면 멈추기)

반복시행
dfs
종료조건 - 찾은 idx, depth
반복문



먹을 수 있는 물고리 리스트가 비어있다면 시간 반환



dfs 시간 초과 걸림... dfs 풀이가 없는 이유가 있었네.. 최소 거리 찾아야 한다면 bfs가 답이긴 한 듯.
 */