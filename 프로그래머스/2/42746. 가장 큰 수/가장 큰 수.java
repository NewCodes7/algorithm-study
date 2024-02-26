import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]); // vs String.valueOf
        }
        
        Arrays.sort(arr, (c1, c2) -> (c2+c1).compareTo(c1+c2));
        
        if (arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
/*
4 4 42 -> 44'42'
4 1 42 -> 4'42'1
두 자리, 세자리가 들어왔을 때 이게 최선인지를 점검해야 함. 
유일한 숫자라면 그냥 들어가도 무방함. but 845, 8, 7, 6 이런식으로 있다면 점검. 845, 8, 1, 2

9 -> 0까지 순차적 점검하는 방법
첫자리 9인놈 찾고, 
    유일하다면 배치
    중복이라면 점검
        조합인데 이거를 compareTo로 해결해버림..
*/