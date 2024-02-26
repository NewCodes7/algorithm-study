import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[speeds.length];
        
        Queue<Integer> q = new LinkedList<>();
        q.add((int) Math.ceil((double) (100 - progresses[0]) / speeds[0]));
        int idx = 0;
        for (int i = 1; i < speeds.length; i++) {
            int reserve = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (q.peek() < reserve) {
                answer[idx] = q.size();
                q.clear();
                idx++;
            }
            q.add(reserve);
        }
        answer[idx] = q.size();
        
        int cnt = 0;
        for (int c : answer) {
            if (c != 0) cnt++;
        }
        
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = answer[i];
        }
        
        return arr;
    }
}