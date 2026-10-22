class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        // 최대 찾기 
        int alp_max = 0; 
        int cop_max = 0;
        for (int[] problem : problems) {
            alp_max = Math.max(alp_max, problem[0]);
            cop_max = Math.max(cop_max, problem[1]);
        }
        
        // dp 초기화 
        int[][] dp = new int[alp_max + 2][cop_max + 2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        alp = Math.min(alp, alp_max);
        cop = Math.min(cop, cop_max);
        dp[alp][cop] = 0;
        
        // dp 탐색
        for (int a = alp; a <= alp_max; a++) {
            for (int c = cop; c <= cop_max; c++) {
                dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                
                // problems
                for (int i = 0; i < problems.length; i++) {
                    int[] problem = problems[i];
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];

                    int alp_new = Math.min(alp_max, a + alp_rwd);
                    int cop_new = Math.min(cop_max, c + cop_rwd);

                    if (a >= alp_req && c >= cop_req) {
                        dp[alp_new][cop_new] = Math.min(dp[alp_new][cop_new], dp[a][c] + cost);
                    }
                }
            }
        }
        
        return dp[alp_max][cop_max];
    }
}

/*
dp[알고력][코딩력]

dp[3][2] = dp[2][2] + 1 
출발점에서 도착점까지 모든 경우의 수에 대해서 계산 
그 상황에서 할 수 있는 최선을 계산해보기 
오름차순으로 
오름차순으로 하게 되면 중간에 더 효율적인 게 나와서 이후 거를 다시 바꿔야 하는 경우가 없어짐 


*/
