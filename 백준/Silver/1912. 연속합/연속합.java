import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[n];
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            if (dp[i - 1] >= 0) dp[i] += dp[i - 1];
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}