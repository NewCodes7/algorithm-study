import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length()-1-i));
        }
        answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }
}