import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        // 테스트 케이스 입력 받기
        int max = 0;
        int[] tests = new int[t];
        for (int i = 0; i < t; i++) {
            tests[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tests[i]);
        }

        // dp 수행
        StringBuilder sb = new StringBuilder();
        for (int j = 6; j <= max; j++) {
            dp[j] = dp[j-1] + dp[j-5];
        }

        for (int i = 0; i < t; i++) {
            sb.append(dp[tests[i]]).append("\n");
        }

        System.out.println(sb);
    }
}

/*
1, 1, 1, 2, 2, 3, 4, 5, 7, 9

12, 16, 21, 28, 37, 49, 65(1개전+5개전)

4, 5, 7, 9, 12, 16

 */