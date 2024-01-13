import java.util.*; // 이거 하고 시작하자

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = yellow/i + 2;
                int y = i + 2;
                if (brown + yellow == x*y) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        
        return answer;
    }
}