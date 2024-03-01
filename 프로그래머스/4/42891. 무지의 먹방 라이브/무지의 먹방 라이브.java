import java.util.*;

class Solution {
    private static class Food implements Comparable<Food> {
        int idx;
        int amount;
        
        public Food(int idx, int amount) {
            this.idx = idx;
            this.amount = amount;
        }
        
        @Override
        public int compareTo(Food other) {
            return this.amount - other.amount;
        }
    }
    
    public int solution(int[] food_times, long k) {
        int answer = 0;
        
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i+1, food_times[i]));
        }
        
        boolean[] visited = new boolean[food_times.length+1];
        int minus = 0;
        int cnt = 0; // 다 먹은 음식 개수
        while (!pq.isEmpty()) {
            Food c = pq.poll();
            
            if ((long)(c.amount - minus) * (food_times.length-cnt) <= k) {
                k -= (c.amount - minus) * (food_times.length-cnt);
                minus += c.amount-minus; // 여기서!!
                visited[c.idx] = true;
                cnt++;
            } else {
                pq.offer(c);
                break;
            }
        }
        
        int idx = -1;
        if (food_times.length - cnt == 0) return -1;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) idx++;
            if (idx == k % (food_times.length - cnt)) { // 여기서 에러
                return i;
            }
        }
        
        return -1;
    }
}

/*
제일 적은 것부터 정렬

남은시간 확인 
그만큼 플러스 해두기

그게 안 된다면 %해서 반복문 돌기 이때 순서 어떻게? 
    boolean[]으로? ㅇㅇ 2십만이니까 괜찮음  
*/