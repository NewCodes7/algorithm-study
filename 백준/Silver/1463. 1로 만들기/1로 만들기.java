import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}

/*
바텀업

1 2 3 4 5 6
0 1 1 2 3 2

 */