import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, (a, b) -> {
            // while (a.length() != 4) {
            //     a += a.charAt(a.length() - 1);
            // }
            // while (b.length() != 4) {
            //     b += b.charAt(b.length() - 1);
            // }
            //System.out.println(a);
            //System.out.println(b);
            return (b + a).compareTo(a + b);
        });
        StringBuilder sb = new StringBuilder();
        // System.out.println(Arrays.toString(nums));
        for (String s : nums) {
            sb.append(s);
        }
        
        if (sb.toString().startsWith("0")) {
            return "0";
        }
        
        return sb.toString();
    }
}

/*
10:32 ~ 

그리디? 

가장 큰 것 기준으로 정렬하고 합치면 될 듯 
숫자로 비교하는 게 아니라 string으로 비교하면 될 듯 

compareTo 



*/