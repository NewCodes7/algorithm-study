import java.util.Arrays;

// 학습용 개선안. 사용자 원본은 코딩 테스트 공부.java에 보존.
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = 0;
        int targetCop = 0;
        for (int[] problem : problems) {
            targetAlp = Math.max(targetAlp, problem[0]);
            targetCop = Math.max(targetCop, problem[1]);
        }

        int startAlp = Math.min(alp, targetAlp);
        int startCop = Math.min(cop, targetCop);
        int[][] dp = new int[targetAlp + 1][targetCop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[startAlp][startCop] = 0;

        for (int a = startAlp; a <= targetAlp; a++) {
            for (int c = startCop; c <= targetCop; c++) {
                // 공부만으로도 순회하는 모든 상태에 도달할 수 있음.
                int time = dp[a][c];
                if (a < targetAlp) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], time + 1);
                }
                if (c < targetCop) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], time + 1);
                }

                for (int[] problem : problems) {
                    if (a < problem[0] || c < problem[1]) {
                        continue;
                    }
                    int nextAlp = Math.min(targetAlp, a + problem[2]);
                    int nextCop = Math.min(targetCop, c + problem[3]);
                    dp[nextAlp][nextCop] = Math.min(
                        dp[nextAlp][nextCop], time + problem[4]
                    );
                }
            }
        }
        return dp[targetAlp][targetCop];
    }
}
