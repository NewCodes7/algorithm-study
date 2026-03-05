import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        Map<String, Integer> map1 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            char c = Character.toLowerCase(arr1[i]);
            
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                sb.setLength(0);
            }
            
            if (sb.length() == 2) {
                if (map1.containsKey(sb.toString())) {
                    map1.put(sb.toString(), map1.get(sb.toString()) + 1);
                } else {
                    map1.put(sb.toString(), 1);
                }
                sb.setLength(0);
                sb.append(c);
            }
        }
        
        Map<String, Integer> map2 = new HashMap<>();
        sb.setLength(0);
        for (int i = 0; i < arr2.length; i++) {
            char c = Character.toLowerCase(arr2[i]);
            
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                sb.setLength(0);
            }
            
            if (sb.length() == 2) {
                if (map2.containsKey(sb.toString())) {
                    map2.put(sb.toString(), map2.get(sb.toString()) + 1);
                } else {
                    map2.put(sb.toString(), 1);
                }
                sb.setLength(0);
                sb.append(c);
            }
        }
        
        int count = 0;
        for (String key : map1.keySet()) {
            int a = map1.get(key);
            if (map2.containsKey(key)) {
                count += Math.min(a, map2.get(key));
            }
        }
        
        int total = 0;
        for (Integer num : map1.values()) {
            total += num;
        }
        for (Integer num : map2.values()) {
            total += num;
        }
        total -= count;
        
        double answer = 1;
        if (total != 0) {
            answer = (double) count / total;
        }
        
        // System.out.println(map1);
        // System.out.println(map2);
        // System.out.println(count);
        // System.out.println(total);
        
        return (int) Math.floor(answer * 65536);
    }
}

/*
10:20~

자르다가 특수문자 포함되어 있으면 필터링, 소문자로 

str1만 잘라도 될 듯. contains하면 되지 않나 
아니네 합집합 개수 세려면 다 잘라야 하네 

str1 자르기 -> 유효한 토큰 개수 -> str2 자르기 -> 유효한 토큰 개수 -> 교집합 -> 합집합 -> 정답 

영어만 있는지 확인하는 건 Character.isAlpahbetic 

아 다중집합을 고려 안했네,,조건 빼먹음 ...
*/