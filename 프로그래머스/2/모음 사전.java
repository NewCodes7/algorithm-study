import java.util.*;

class Solution {
    private static final String[] alphabet = {"A", "E", "I", "O", "U"};
    private static int count = 0;
    private static boolean isSearched = false; // 안에서 하면 즉각적으로 반영이 안 됨.
    
    public static void dict(StringBuilder sb, String word) {
        if (sb.toString().equals(word)) {
            isSearched = true;
        }
        
        if (sb.length() == 5 || isSearched) {
            return;
        }
        
        for (String c : alphabet) {
            sb.append(c);
            count++;
            dict(sb, word);
            if (isSearched) return;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dict(sb, word);
        int answer;
        return count;
    }
}   

// 리팩토링: 첫 문자에 따라 초기 카운트 세팅가능.