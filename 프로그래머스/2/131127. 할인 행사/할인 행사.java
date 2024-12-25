import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i <= discount.length - 10; i++) {
            int[] pocket = new int[want.length];
            
            for (int j = i; j < i + 10; j++) {
                int idx = Arrays.asList(want).indexOf(discount[j]);
                
                if (idx == -1) {
                    break;
                }
                
                pocket[idx]++;
            }
            
            if (Arrays.equals(pocket, number)) {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
9:41 ~ 9:46

문제를 잘 읽고 설계하는 데 집중

제대로 읽자.. 여전히 놓친 부분이 있었음

*/