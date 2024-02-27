import java.util.*;

class Solution {
    private static Map<String, List<String>> closet = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (String[] cloth : clothes) {
            if (closet.containsKey(cloth[1])) {
                closet.get(cloth[1]).add(cloth[0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(cloth[0]);
                closet.put(cloth[1], list);
            }
        }
        
        for (List<String> s : closet.values()) {
            answer *= (s.size()+1);
        }
        
        return answer-1;
    }
}


/*
11:54~


*/