class Solution {
    private static int answer = 0;
    public int solution(int[] number) {
        comb(number, 0, 0, 0);
        
        return answer;
    }
    
    public static void comb(int[] number, int sum, int depth, int idx) {
        if (depth == 3) {
            if (sum == 0) {
                answer ++;
            }
            return;
        }
        
        for (int i = idx; i < number.length; i++) {
            comb(number, sum+number[i], depth+1, i+1);
        }
    }
}