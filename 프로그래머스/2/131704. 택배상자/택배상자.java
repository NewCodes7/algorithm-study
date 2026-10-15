import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int n = order.length;
        int depth = 0;
        
        for (int i = 1; i <= n; i++) { // i는 택배 번호
            // i가 order[depth]랑 같다면 바로 적재
            if (i == order[depth]) {
                depth++;
            } else { // i가 order[depth]랑 다르다면 stack 적재 
                stack.push(i);
                continue;
            }
            
            // while문 stack.peek이 order[depth] 같다면 적재 적재 적재 
            while (!stack.isEmpty() && stack.peek() == order[depth]) {
                stack.pop();
                depth++;
            }
        }
        
        return depth;
    }
}

/*
09:19~09:30 11분
의사코드로 이 아래에 설계하기보다는 뭔가 자연스럽게 코드 자체에 주석 넣고 바로 작성하게 됨 
난이도가 쉽게 느껴져서 그런가 
좀 직관적이라면 여기에 설계하기보다는 위에서 바로 주석 먼저 작성하고 코드 작성해도 좋을 듯 
*/
