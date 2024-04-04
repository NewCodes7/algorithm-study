import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        for (int i = 1; i <= n; i++) { // 이렇게도 피할 수 있군!
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i-1][1] + r, dp[i-1][2] + r);
            dp[i][1] = Math.min(dp[i-1][0] + g, dp[i-1][2] + g);
            dp[i][2] = Math.min(dp[i-1][0] + b, dp[i-1][1] + b);
        }

        int answer = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(answer);
    }
}

/*

 */