import java.util.*;

class Solution {
    private int n;
    private int k;
    private int[][] reqsSorted;
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        this.n = n;
        this.k = k;
        
        // 정렬 
        reqsSorted = reqs;
        // System.out.println(Arrays.deepToString(reqsSorted));
        
        // 멘토 유형 조합
        int[] type = new int[k + 1];
        Arrays.fill(type, 1);
        type[0] = 0;
        back(type, 0, 1);
        
        return answer;
    }
    
    private void back(int[] type, int depth, int start) {
        if (depth == n - k) {
            // System.out.println(Arrays.toString(type));
            int time = judge(type);
            answer = Math.min(answer, time);
            return;
        }
        
        for (int i = start; i <= k; i++) {
            type[i]++;
            back(type, depth + 1, i);
            type[i]--;
        }
    }
    
    private int judge(int[] type) {
        int time = 0; 
        for (int i = 1; i <= k; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < type[i]; j++) {
                pq.offer(0);
            }
            for (int j = 0; j < reqsSorted.length; j++) {
                int a = reqsSorted[j][0];
                int b = reqsSorted[j][1];
                int c = reqsSorted[j][2];
                if (c != i) continue;
                int t = pq.poll();
                if (a >= t) {
                    pq.offer(a + b);
                } else {
                    pq.offer(t + b);
                    time += t - a;
                }
            }
        }
        
        return time;
    }
}

/*
2105~2123 18

멘토 n명 20
상담 유형 1~k 5
각 멘토는 하나의 유형만 담당 
상담 요청 reqs 300

참가자 기다린 시간 = 상담 요청 ~ 멘토 상담 시작 

k개는 고정 
n-k에 대해 멘토 유형 분배
n-k 15
k 5
5h15
19c4

1. reqs는 각 유형 별로 a 시간 순으로 정렬해두기 
    Arrays.sort 하면 되려나 ? 
2. 멘토 유형 조합
    백트랙킹 
3. 각 유형 별로 req 처리 

2206~2023 17

35분 풀이
1. 생각보다 쉬운데? 
2. pq 재치 좋았다
3. 백트랙킹도 이제 감 잡은 듯 
4. 2차원 배열 정렬하는 법? 
5. dp로 시간 복잡도 개선 가능 
6. 정렬할 필요 없었음. 문제 제한사항도 꼼꼼히 읽자. 
*/
