import java.util.*; // 이거 하고 시작하자

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<List<Integer>> carpet = new ArrayList<>();
        
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = Math.max(yellow/i + 2, i + 2);
                int y = Math.min(yellow/i + 2, i + 2);
                if (brown + yellow == x*y) {
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }
        
        System.out.print(Arrays.toString(answer));
        
        return answer;
    }
}