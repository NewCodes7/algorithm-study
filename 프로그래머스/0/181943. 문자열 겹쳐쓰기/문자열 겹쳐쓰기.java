import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = my_string.toCharArray();
        char[] arr2 = overwrite_string.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (i >= s && arr2.length > i - s) {
                sb.append(arr2[i - s]);
            } else {
                sb.append(arr[i]);
            }
        }
        
        return sb.toString();
    }
}