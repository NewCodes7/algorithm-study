import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        
        while (!(Math.abs(a - b) == 1 && Math.max(a, b) % 2 == 0)) {
            a = (int) Math.ceil(a / 2.0); 
            b = (int) Math.ceil(b / 2.0);
            answer++;
        }

        return answer;
    }
}

/*
10^6 = 1,000,000
3,4 -> 2 -> 1
7,8 -> 4 -> 2

1 -> 1 -> 1 
8 -> 4 -> 2 

아 엣지 케이스.. !! 양옆이지만 붙지 않을 경우도 있어!!
2, 3

Math.ceil(a / 2)
*/