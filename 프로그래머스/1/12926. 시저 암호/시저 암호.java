import java.util.*;

class Solution {
    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) return c; // 문자열 관련 메서드 Character이용
        int offset = Character.isUpperCase(c) ? 'A' : 'a'; // 문자열을 인트로 저장함. 아스키코드.
        int position = c - offset; // 절대적인 위치에서 상대적인 위치로 변경하는 작업. 평행이동 원리와 유사함.
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }
    
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) { // String to CharArray
            sb.append(push(c, n));
        }
        return sb.toString();
    }
}

// 구조 먼저 짜두는 것도 좋다. 개괄적인.