import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][m + 1];
        int[][] map = new int[n + 1][m + 1];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 가로, 세로 구분하고 a,b를 더 이전 걸로 하면 될 듯
            int x = Math.min(a, c);
            int y = Math.min(b, d);
            int shift = 1; // 가로
            if (a == c) shift = 2; // 세로

            if (map[x][y] != 0) {
                // 똑같은 좌표 나올 수 있음을 방지
                if (map[x][y] == 1 && shift == 2) {
                    map[x][y] = 3; // 가로, 세로 둘다 막힌거
                }

                if (map[x][y] == 2 && shift == 1) {
                    map[x][y] = 3; // 가로, 세로 둘다 막힌거
                }
            } else {
                map[x][y] = shift;
            }
        }

        // 제일 왼쪽, 제일 아래쪽 경우의 수 1로 초기화
        for (int i = 0; i <= n; i++) { // 가로
            dp[i][0] = 1;
            if (map[i][0] == 1 || map[i][0] == 3) break; // 아 이렇게 하면 안 됨! 부실 공사 시작점에는 그래도 갈 수 있잖아! 이게 순서가 뒤에 있었어야 함
        }
        for (int i = 0; i <= m; i++) { // 세로
            dp[0][i] = 1;
            if (map[0][i] == 2 || map[0][i] == 3) break; // 여기도 마찬가지로 오타!! 가로인 걸 그대로 복사해버림 (테케 개수에 의존하면 안 될 듯)
        }

        // dp 수행 - 경우의 수 더하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i - 1][j] != 1 && map[i - 1][j] != 3) { // 가로
                    dp[i][j] += dp[i - 1][j];
                }

                if (map[i][j - 1] != 2 && map[i][j - 1] != 3) { // 세로 여기 오타 있었음!! i - 1
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}

/*
long 사용하기!!

아랫줄부터 훑으면 될 듯!

 */