import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());

        int[] steps = new int[n+2]; // n이 1일 때 런타임 에러 방지
        for (int i = 0; i < n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+2]; // n이 1일 때 런타임 에러 방지
        dp[0] = steps[0];
        dp[1] = steps[0] + steps[1];
        dp[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + steps[i], dp[i-3] + steps[i-1] + steps[i]);
        }

        System.out.println(dp[n-1]);
    }
}

/*

1. 한 계단 (이전에 한 계단) steps[i-1] + steps[i]
2. 두 계단 dp[i-2] + steps[i]

3개의 케이스가 있음.
 */