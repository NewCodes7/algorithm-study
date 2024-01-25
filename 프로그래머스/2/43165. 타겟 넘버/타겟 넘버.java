import java.util.*;

class Solution {
    private static int answer = 0;
    
    public static void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (target == sum) answer++;
            return;
        } else {
            dfs(numbers, target, depth+1, sum + numbers[depth]);
            dfs(numbers, target, depth+1, sum - numbers[depth]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
        /*
        (total - target) / 2만큼 -로 바꾸면 됨.
        해당 경우를 탐색하면 됨. 개수는?
        백트랙킹? ㄱㄱ
        
        // 매개변수와 같은 이름으로 필드에 선언해두면 안 되지. 그러면 이름바꾸는 방법밖에 없어?
        규칙 찾아서 이를 통해 풀려고 하니 오히려 더 복잡해짐. depth가 안 정해져 있어서.
        규칙 찾는 게 능사는 아님. 다양한 풀이를 고려해야 함. (출제의도파악)
        */
    }
}