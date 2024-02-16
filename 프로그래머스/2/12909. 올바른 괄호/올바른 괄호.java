import java.util.Stack;

class Solution {
    boolean solution(String s) {
        if (s.charAt(0) == ')') return false;
        

        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.empty()) return false;
                stack.pop();
            } else {
                stack.add(0); // 0 == (
            }
        }
        
        if (stack.empty()) { // 스택 메서드 정리
            return true;
        } 

        return false;
    }
}