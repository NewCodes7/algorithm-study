import java.util.*;

public class Solution {
    public int solution(int n) {
        int count = 0;
        
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                count++;
                n = (n - 1) / 2;
            }
        }
        
        return count;
    }
}

// DP 풀이 (효율성 걸림)
//         int[] dp = new int[n + 2]; // 거리에 따른 건전지 사용량
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 1;
        
//         for (int i = 3; i <= n; i++) {
//             if (i % 2 == 0) {
//                 dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2]);
//             } else {
//                 dp[i] = dp[i - 1] + 1;
//             }
//         }

//         return dp[n];

/*
5:02

k칸 점프 - 건전지 사용
순간이동(현재까지 온 거리 x 2 ) 

처음 점프는 고정. 
2의 제곱 성질

dp인 것 같은데? 
매번 두 가지 경우의 수 존재
    한 칸 점프
    순간이동

대신 3 이런 건 순간이동으로 갈 수 없음

문제
    런타임 에러 -> n=1일 때 고려!
    효율성: 메모리 초과, 시간 초과 -> dp가 아닌가? 결과적 사고?

결과적 사고
    N이 2로 나누어 떨어진다면, 그 수로 타겟을 바꿔도 됨.
    그리고 2로 나누어 떨어지지 않는다면, -1 빼면 됨. 
    
    위 과정을 1이 될 때까지 반복.
*/