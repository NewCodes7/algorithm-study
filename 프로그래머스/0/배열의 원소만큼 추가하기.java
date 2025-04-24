import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int total = Arrays.stream(arr).sum();
        int[] answer = new int[total];

        int before = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                answer[before + j] = arr[i];
            }
            before += arr[i];
        }

        return answer;
    }
}