import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String c : operations) {
            String[] s = c.split(" ");
            
            if (s[0].equals("I")) {
                pq.offer(Integer.parseInt(s[1]));
            }
            
            if (c.equals("D -1")) {
                if (pq.size() == 0) continue;
                pq.poll();
            }
            
            if (c.equals("D 1")) {
                if (pq.size() == 0) continue;
                if (pq.size() == 1) {
                    pq.poll();
                    continue;
                }
                int[] temp = new int[pq.size()-1];
                int i = 0;
                while (pq.size() != 1) {
                    temp[i] = pq.poll();
                    i++;
                }
//                 for (int i = 0; i < pq.size()-1; i++) {
                    
//                     //d아 pq 길이 변경ㅇ!
//                 }
                pq.poll();
                
                
                for (int d : temp) {
                    pq.offer(d);
                }
            }
            
        }
        
        
        if (pq.size() == 0) {
            return new int[]{0, 0};
        }

        answer[1] = pq.poll();
        
        if (pq.size() == 0) {
            answer[0] = answer[1];
            return answer;
        }
        
        int i = 0;
        while (pq.size() != 1) {
            pq.poll();
        }

        answer[0] = pq.poll();
        
        return answer;
    }
}

/*
3:06~ 
두 우선순위 큐 선언

최소힙 
최대힙

두 큐 교집합 원소를 바탕으로 계산하기

삭제 연산 무시하는 건? 상관없나? 어차피 레거시이니.
ㄴㄴ 연관있을 수 있음.

덱으로 compareTo 오버라이딩 안되는군..
*/