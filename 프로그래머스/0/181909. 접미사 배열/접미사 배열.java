import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> answer = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        char[] arr = my_string.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.insert(0, arr[i]);
            answer.add(sb.toString());
        }

        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
}