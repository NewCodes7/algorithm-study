import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while (true) {
            int min = pq.poll();
            if (pq.size() == 0) {
                if (min < K) return -1;
            }
            if (min < K) {
                int min2 = pq.poll();
                pq.offer(min + min2*2);
            } else {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}