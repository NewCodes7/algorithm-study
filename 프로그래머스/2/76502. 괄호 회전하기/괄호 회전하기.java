import java.util.Stack;

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 0;
        int answer = 0;
        s += s;
        
        Stack<Character> stack = new Stack<>(); // 이런 방법도 있군!
        for (int i = 0; i < s.length() / 2; i++) { // 2 나누기!!
            for (int j = i; j < i + (s.length()) / 2; j++) {
                char c = s.charAt(j);
                if (c == '[' || c == '{' || c == '(') {
                    stack.add(c);
                } else {
                    if (stack.empty()) {
                        answer--;
                        break;
                    }
                    char b = stack.peek();
                    boolean check = (b == '[' && c == ']') 
                        || (b == '{' && c == '}') 
                        || (b == '(' && c == ')');
                    if (check) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            if (stack.empty()) {
                answer++;
            }
        }
        
        
        return answer;
    }
}