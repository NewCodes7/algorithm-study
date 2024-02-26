import java.util.*;

class Solution {
    private static int time = 0;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for (int c : truck_weights) {
            q.offer(c);
        }
        
        // 다리 자체를 큐로 표현할 수 있음. 빈 공간은 그저 빈공간 0으로.
        Queue<Integer> bridge = new LinkedList<>(); // 0, 0, 0, 0
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int total_weigth = 0;
        while (!q.isEmpty()) {
            time++;
            total_weigth -= bridge.poll(); // 시간 경과에 따른 다리 갱신
            
            int c = q.peek();
            if (c + total_weigth <= weight) { // 견딜 수 있다면 출하
                c = q.poll();
                bridge.offer(c);
                total_weigth += c;
            } else { // 그저 킵고잉
                bridge.offer(0);
            }
        }
        
        time += bridge_length; // 마지막 차 지나가는 시간 계산
        
        return time;
    }
}

/*
2:57~

큐
트럭 peek 확인 
    하중 견딘다면, 출하
    못 견딘다면 1초 진행
*/