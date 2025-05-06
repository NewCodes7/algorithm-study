import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = calculateStr(str1);
        Map<String, Integer> map2 = calculateStr(str2);
        
        int commonCount = 0;
        int unionCount = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                commonCount += Math.min(map1.get(key), map2.get(key));
                unionCount += Math.max(map1.get(key), map2.get(key));
            } else {
                unionCount += map1.get(key);
            }
        }
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                unionCount += map2.get(key);
            }
        }
        
        double simplicity = 1;
        if (unionCount != 0) {
            simplicity = (double) commonCount / unionCount; 
        }
        int answer = (int) (simplicity * 65536);
        
        return answer;
    }
    
    private Map<String, Integer> calculateStr(String str) {
        Map<String, Integer> map = new HashMap<>();
        char[] temp = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
            
            if (sb.length() != 2) {
                continue;
            }
            
            String target = sb.toString().toLowerCase();
            if (Character.isAlphabetic(target.charAt(0)) 
                && Character.isAlphabetic(target.charAt(1))) {
                if (map.containsKey(target)) {
                    map.put(target, map.get(target) + 1);
                } else {
                    map.put(target, 1);
                }
            }
            
            sb = new StringBuilder();
            sb.append(temp[i]);
        }
        
        return map;
    }
}
