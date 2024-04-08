import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] drinks = new int[10000];
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10000];
        dp[0] = drinks[0];
        dp[1] = dp[0] + drinks[1];
        dp[2] = Math.max(dp[1], Math.max(dp[0] + drinks[2], drinks[1] + drinks[2]));
        for (int i = 3; i < n; i++) {
//            if (i >= 4) { 신경 쓸 필요 없음. dp[i-1]때문에 알아서 카운트됨.
//                temp = Math.max(dp[i - 4] + drinks[i - 1] + drinks[i], temp);
//            }
            dp[i] = Math.max(dp[i - 2] + drinks[i], Math.max(dp[i - 3] + drinks[i - 1] + drinks[i], dp[i-1]));
        }

        System.out.println(dp[n-1]);
    }
}

/*
한 개 건너뛰거나, 두 개 건너뛰거나

음... 이게 온전히 되려나?
최소면 알아서 떨어지겠지.
그리고 알아서 잘 채워지겠는데

계단이랑 비교해서 다시 풀어봐야 할 듯

이거 유지하는 건 어덯게 비교?

boolean으로?
두개연속 true이면 그냥 전진
아니면 drink

내 기존 코드 뭐가 문제지?
두 칸 띄는 거
 */