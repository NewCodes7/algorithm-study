import java.util.*;

class Solution {
    private static int answer = 0;
    
    public int solution(int n, int k) {
        String[] c = Integer.toString(n, k).split("");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (c[i].equals("0") ) { // sb 길이 0일 떄!!!!
                if (sb.length() == 0) continue;
                check(Long.parseLong(sb.toString())); // 왜 오류?
                sb.setLength(0); // 초기화 방법
            } else {
                sb.append(c[i]);
            }
        }
        
        if (sb.length() != 0) check(Long.parseLong(sb.toString()));
        
        return answer;
    }
    
    public static void check(long n) {
        if (n == 1) return;
        for (long i = 2; i <= Math.sqrt(n); i++) { // 등호
            if (n % i == 0) return;
        }
        
        answer++;
    }
}

// 런타임 에러 외우자.. long 자료형