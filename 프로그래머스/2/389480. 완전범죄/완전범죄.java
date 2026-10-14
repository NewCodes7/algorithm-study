import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        if (info[0][1] < m) {
            dp[info[0][1]] = 0;
        }
        if (info[0][0] < n) {
            dp[0] = info[0][0];
        }
        // System.out.println(Arrays.toString(dp));
        
        for (int i = 1; i < info.length; i++) {
            int a = info[i][0];
            int b = info[i][1];
            
            int[] newDp = new int[m];
            for (int c = 0; c < newDp.length; c++) {
                newDp[c] = -1;
            }
            
            // b가 훔칠 때 
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] == -1) {
                    continue;
                }
                if (j + b < m) { // 기존 dp랑 비교하면 안 되지 
                    newDp[j + b] = dp[j];
                }
            }
            
            // a가 훔칠 때 
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] == -1) {
                    continue;
                }
                if (dp[j] + a < n 
                    && (newDp[j] == -1 || dp[j] + a < newDp[j])) {
                    newDp[j] = dp[j] + a;
                }
            }
            dp = newDp;
        // System.out.println(Arrays.toString(dp));
        }
        
        // System.out.println(Arrays.toString(dp));
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) continue;
            answer = Math.min(answer, dp[i]);
        }
        if (answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }
}

/*
21:37~

n과 m이 작네. 쌓이는 개수로 dp하기엔 좋겠네 
결국에 어떤 과정으로 답을 찾아가는지는 중요하지 않고
최소 몇 개인지만 중요한거네 
그러면 dp가 딱이다. 

각 b의 개수에 따라서 a의 개수 몇까지 가능한지 메모해두면 될 듯 
그러면 대략 최대 40 * 120 순회만 하면 됨 

원래는 가지치기 2^40되지만.. b 기준으로 뭉개버리면 됨 

*/
