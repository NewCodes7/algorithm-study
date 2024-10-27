import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] sizes = new int[10000001];
        for (int i = 0; i < tangerine.length; i++) {
            sizes[tangerine[i]]++;
        }
        
        Arrays.sort(sizes);
        
        int answer = 0;
        for (int i = sizes.length - 1; i >= 0; i--) {
            k -= sizes[i];
            answer++;
            if (k <= 0) {
                break;
            }
        }
        
        // System.out.println(Arrays.toString(sizes));
        
        return answer;
    }
}
/*
제일 개수가 많은 크기부터 가져가면 될 듯 (그리디처럼)
예외사항은 없으려나? 없을 듯 최소 최대도 무난

순회하면서 각각의 크기 개수 취합
더하면서 같아지면 스톱

*/