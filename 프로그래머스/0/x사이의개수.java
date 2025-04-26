import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] arr = myString.split("x");
        int[] answer = new int[arr.length];
        if (myString.endsWith("x")) { 
            answer = new int[arr.length + 1];
        }
        
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].length();
        }
                
        return answer;
    }
}