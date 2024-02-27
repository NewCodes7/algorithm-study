import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 1;
        int cctv = routes[0][1];
        
        for (int i = 1; i < routes.length; i++) {
            if (cctv >= routes[i][0] && cctv <= routes[i][1]) {
                continue;
            } else {
                cctv = routes[i][1];
                answer++;
            }
        } 
        
        return answer;
    }
}

/*
8:21~

어차피 모두다 사라져야 함. 
이왕이면 가성비 좋은 곳에 두는 게 맞음. 
-> (전처리) 결과적 사고에 가까움

어차피 -20 ~ -15 구간에 하나는 둬야 함.
-> 순차적 사고, 분할적 사고

제일 뒤에 두는 게 맞음
*/