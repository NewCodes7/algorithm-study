import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] arr = new int[n + 2];
        Arrays.fill(arr, 1);
        
        for (int c : lost) {
            arr[c]--;
        }
        
        for (int c : reserve) {
            arr[c] ++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                if (arr[i-1] == 2) {
                    arr[i-1]--;
                    arr[i]++;
                    continue;
                } 
                if (arr[i+1] == 2) {
                    arr[i+1]--;
                    arr[i]++;
                    continue;
                }
            }
        }
        
        for (int c : arr) {
            if (c != 0) answer++;
        }
        answer -= 2; // n+2 길이만큼 배열 생성했으니 2 빼야 함.
        
        return answer;
    }
}