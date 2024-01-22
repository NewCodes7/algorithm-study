import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[501];
        int[] dp = new int[501];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            v[a] = b;
        }

        for (int i = 0; i < 501; i++) {
            dp[i] = 0;
        }

        for (int i = 1; i < 501; i++) {
            for (int j = 0; j < i; j++) {
                if (v[j] < v[i]) { // dp 자리 아니다!!
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxValue = 0;
        for (int c : dp) {
            maxValue = Math.max(maxValue, c);
        }
        
        System.out.println(n - maxValue);
    }
}