import java.util.*;

class Solution {
    private static class Food{
        int idx;
        int amount;
        
        public Food(int idx, int amount) {
            this.idx = idx;
            this.amount = amount;
        }
    }
    
    public int solution(int[] food_times, long k) {
        int minAmount = 100000001;
        Deque<Food> d = new ArrayDeque<>();
        for (int i = 0; i < food_times.length; i++) {
            d.offer(new Food(i+1, food_times[i]));
            minAmount = Math.min(minAmount, food_times[i]);
        }
        
        for (long i = k; i > 0; i--) {
            int size = d.size();
            if (size == 0) break;
            
            if (minAmount * size < i) {
                int nextMinAmount = 100000001;
                for (int j = 0; j < size; j++) {
                    Food c = d.poll();
                    c.amount -= minAmount;
                    if (c.amount > 0) {
                        nextMinAmount = Math.min(nextMinAmount, c.amount);
                        d.offer(c);
                    }
                }
                
                i -= minAmount * size-1; // 아 원래 사이즈로 해야 함!!
                minAmount = nextMinAmount;
            } else if (minAmount * size == i) {
                while (!d.isEmpty()) {
                    Food c = d.poll();
                    if (c.amount != minAmount) {
                        return c.idx;
                    }
                }
            } else {
                Food c = d.poll();
                c.amount--;
                if (c.amount > 0) d.offer(c);
            }
            
        }
        
        if (d.isEmpty()) return -1;
        
        int answer = d.poll().idx;
        
        return answer;
    }
}

/*
11:48~
시간 복잡도 줄여야 해...! 결과적 사고 가보자

지금 최소인 amount * d.size() <= k
    모조리 amount만큼 빼기
그런데 짜잘한 녀석들이 있따면? 상관x 길이는 20만이기에.

10,000,000,000,000

일단 다른 풀이로 해보고, 추가적인 조치  더해보기
*/