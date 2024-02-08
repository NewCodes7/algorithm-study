import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        char[] number = Integer.toString(n, k).toCharArray(); // 메서드 숙지!! 우선 의심되니 long으로
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '0' && sb.toString().length() != 0) { // char 숫자인거 놓침
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            if (number[i] != '0') {
                sb.append(number[i]);
            }
        }
        if (sb.toString().length() != 0) list.add(sb.toString());
        
        for(String c : list) {
            if (isPrime(Long.parseLong(c))) answer++; // 여기서 런타임에러.. 음. long으로 했어야 함.
        }
        
        return answer;
    }
    
    public static boolean isPrime(long n) {
        if (n == 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) { // 이유?
            if (n % i == 0) return false;
        }
        
        return true;
    }
}