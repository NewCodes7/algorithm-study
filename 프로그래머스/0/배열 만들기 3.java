class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int s0 = intervals[0][0], e0 = intervals[0][1];
        int s1 = intervals[1][0], e1 = intervals[1][1];
        int[] answer = new int[e0 - s0 + e1 - s1 + 2];
        
        int idx = 0;
        for (int i = s0; i <= e0; i++) {
            answer[idx++] = arr[i];
        }
        for (int i = s1; i <= e1; i++) {
            answer[idx++] = arr[i];
        }
        
        return answer;
    }
}
