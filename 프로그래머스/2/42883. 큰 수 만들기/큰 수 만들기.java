import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        
        int start = 0;
        int length = number.length() - k;
        
        for (int i = 0; i < length; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    start = j + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}
// 부분 문제로 나타내는 것이 중요!!