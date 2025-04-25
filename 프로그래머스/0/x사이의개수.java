import java.util.*;

class Solution {
    public int[] solution(String myString) {
        boolean isEndX = false;
        if (myString.charAt(myString.length() - 1) == 'x') {
            isEndX = true;
        }
        String[] arr = myString.split("x");
        System.out.println(Arrays.toString(arr));
        int[] answer = new int[arr.length];
        if (isEndX) { 
            answer = new int[arr.length + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].length();
        }
        
        return answer;
    }
}

// TODO:
// upgrade, split