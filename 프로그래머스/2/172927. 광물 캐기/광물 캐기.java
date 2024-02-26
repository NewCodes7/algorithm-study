import java.util.*;

class Solution {
    private static int answer = Integer.MAX_VALUE;
    private static int n = 0;
    
    public int solution(int[] picks, String[] minerals) {
        for (int c : picks) {
            n += c;
        }
        
        back(picks, minerals, 0, 0);
        
        return answer;
    }
    
    public static void back(int[] picks, String[] minerals, int depth, int sum) {
        if (depth == n || depth == Math.ceil((double)minerals.length/5)) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;
            picks[i]--;
            back(picks, minerals, depth+1, sum + calculate(minerals, i, depth));
            picks[i]++;
        }
    }
    
    public static int calculate(String[] minerals, int idx, int depth) {
        int sum = 0;
        for (int i = depth*5; i < depth*5 + 5; i++) {
            if (i > minerals.length-1) break;
            
            if (minerals[i].equals("diamond")) { // 문자열 비교!!
                if (idx == 0) sum += 1;
                if (idx == 1) sum += 5;
                if (idx == 2) sum += 25;
            }
            if (minerals[i].equals("iron")) {
                if (idx == 0) sum += 1;
                if (idx == 1) sum += 1;
                if (idx == 2) sum += 5;
            }
            if (minerals[i].equals("stone")) {
                sum += 1;
            }
        }
        
        return sum;
    }
}

/*
9:02~

완탐으로 가도 될 듯.
시행횟수: 곡괭이 수만큼 or minerals / 5만큼

백트랙킹 picks[i]--;
sum 합산하기 

if - 최소 갱신
*/