import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static boolean[][] visited;
    private static int max = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(arr));

        // 실제로는 모든 좌표에 대해서 수행하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;

                back(arr[i][j], 1, i, j);
//                back(0, 0, i, j, new LinkedList<>()); 여기가 문제였음.
                except(arr[i][j], i, j);
                // 아.. 여기서 visited false를 안 챙겼네...!!!!!!!!!! (블로그 보고 깨달음)
                    // 역시 이런 곳에서 그냥 막 하다가 치명적인 실수 나옴. 하나하나 눌러야 해!
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void back(int sum, int depth, int x, int y) {
        if (depth == 4) {
            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > arr.length -1 || ny < 0 || ny > arr[0].length - 1) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            back(sum + arr[nx][ny], depth + 1, nx, ny);
            visited[nx][ny] = false;
        }
    }

    public static void except(int sum, int x, int y) {
        int originalSum = sum;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;

                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx > arr.length -1 || ny < 0 || ny > arr[0].length - 1) {
                    continue;
                }

                sum += arr[nx][ny];
            }
            // 3개가 완성이 안 되었을 경우가 있을 수 있음. 벽에 부딪혀서!
            // 근데 해당 경우는 당연히 max 후보가 될 수 없으니 max에 할당해도 괜찮지 않나?
            max = Math.max(max, sum);
            sum = originalSum;
        }

    }
}

/*
500 * 500 = 250,000개
250000 * 5 = 1,250,000
완탐으로 해도 시간 복잡도는 크게 문제 없을 듯.
근데 회전, 대칭까지 고려하면.. 그래도 문제 없음.

그런데 완탐으로 하려면 하나하나 다 구현해야 하나?
-> 블록을 대칭, 회전시키는 대신에 arr[][] 판을 이동시키는 방법이 있음. 총 8개의 판 구비

이렇게 하는 게 맞을까?
BFS & 백트랙킹으로 할까?

아 왜 더 크게 나오지?
배열 직접 보려했는데 이것도 잘 안 되네.. -> 이 또한 대충 짜면 안 됨 ㅠㅠ 리팩토링
아!! 이미 갔던 곳이면 가면 안 됨. 머릿 속으로 직접 해보니 알겠네!! - 역시 손으로 끄적여야 하나
visited 체크 못했네.. bfs인데. 감이 좀 떨어져서 그런듯

ㅗ자 모양은 따로 처리해줘야 하나? (테케 3덕분에)
    어떻게 처리하지? 가운데 찍어두고 처리하면 될 듯.

틀렸습니다. -> 왜 틀렸을까? 생각하지 못한 엣지케이스가 있을 듯
*/