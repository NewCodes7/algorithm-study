import java.util.*;

class Solution {
    private static final String[][] orders = {
        {"*", "-", "+"},
        {"*", "+", "-"},
        {"-", "*", "+"},
        {"-", "+", "*"},
        {"+", "-", "*"},
        {"+", "*", "-"}
    };
    
    public static long calculate(long a, long b, String op) {
        if (op.equals("*")) { 
            return a * b;
        }
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        return 0;
    }
    
    private long calculate(List<String> tokens, String[] order) {
        for (String op : order) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i-1));
                    long rhs = Long.parseLong(tokens.get(i+1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result)); // 와 토큰 활용법 배우기
                    i -= 2; // 시행횟수 관리까지!!
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true); // 이런 방법이 있네.. 앞으로 이런 지점 있으면 바로 참고해보고 넘어와도 될 듯.
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        long max = 0; // Long의 이유 판단하자.
        for (String[] order : orders) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), order));
            if (value > max) {
                max = value;
            }
        }
        return max;
        
        // 표현 익히기 문자열.contains()
        // 네이밍
// 문자열, 배열, 리스트 길이
        // int to string
// 문자열 비교 주의!!
         //getAsInt의 역할?
    }
}