class Solution {
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        int targetSum = 0;
        for (int c : numbers) targetSum += c;
        targetSum = (targetSum - target) / 2;
        
        comb(0, targetSum, numbers, 0);
        
        return answer;
    }
    
    public static void comb(int sum, int targetSum, int[] numbers, int idx) {
        if (sum >= targetSum) {
            if (sum == targetSum) answer++;
            return;
        }
        
        for (int i = idx; i < numbers.length; i++) {
            comb(sum + numbers[i], targetSum, numbers, i+1); // idx+1이 아니라 i+1!!
        }
    }
}


/*
9:16~

총합 - 2 * (고른 합) == target

고른 합 = (총합 - target)/2

고른 합의 경우의 수가 답.

조합 통해서 해당 합 경우의 수 찾기
*/