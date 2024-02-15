import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;
        
        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                sb.append(" ");
                isUpper = true;
            } else {
                if (isUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                isUpper = !isUpper;
            }
        }
        
        return sb.toString();
    }
}

// 문자열을 분해하고 싶을 때 방법

// 아.. 하나 이상의 공백. 

// 아 놓치면 안 된다고 요구 사항 제발!! 중요한 요구사항은 정리해두자. 아무리 레벨1이더라도