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
        int c = Integer.parseInt(st.nextToken());
        dp[0] = c;

        for (int i = 1; i < n; i++) {
            c = Integer.parseInt(st.nextToken());

            if (dp[i-1] < 0) {
                dp[i] = c;
            } else {
                dp[i] += dp[i-1] + c; // 리팩토링 가능
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

/*

반복문
    양수이면
        더하기
    음수이면
        더했던 것 이전의 최댓값과 비교하기

아 음수가 나왔다고 해서 바로 끝나는 건 아님!!

2 1 -4 3 4 -4 6 5 -5 1
2
3 1
-1 -3 -4
2 0 -1 3

10^5

일단 DP는 종이에 많이 시행해보는 연습해야 할 듯!

자바 xml 자동으로?
 */