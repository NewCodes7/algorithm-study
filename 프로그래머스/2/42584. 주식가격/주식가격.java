class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int c = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    c++;
                } else {
                    c++;
                    break;
                }
            }
            answer[i] = c;
        }
        return answer;
    }
}