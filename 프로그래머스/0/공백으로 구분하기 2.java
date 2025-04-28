import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = Arrays.stream(my_string.split(" ")).filter(c -> !c.equals("")).toArray(String[]::new);
        return answer;
    }
}