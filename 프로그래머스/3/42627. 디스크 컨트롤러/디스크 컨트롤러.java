import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Queue<int[]> q = new LinkedList<>();
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] c : jobs) {
            q.offer(c);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int time = -1; // 시간
        int total = 0; // 총 실행시간
        int ing = 0; // 실행중인 디스크의 남은 시간
        
        while (!(q.isEmpty() && pq.isEmpty() && ing == 0)) {
            time++; // 기준 시간
            if (ing != 0) {
                ing--; // 실행중인 것 감소
                total++;
            }
            if (!pq.isEmpty()) {
                total += pq.size(); // 대기중인 것 증가. null이어서 size 메서드 못하나?
            }
           
            while (!q.isEmpty() && q.peek()[0] == time) {
                pq.offer(q.poll()[1]);
            }
            // if (!q.isEmpty()) {
            //     while (q.peek()[0] == time) {
            //         pq.offer(q.poll()[1]);
            //     }
            // } 실수
            
            if (!pq.isEmpty()) {
                if (ing == 0) {
                    ing += pq.poll();
                }
            }
        }
        
        return total / jobs.length;
    }
}

/*
10:58~11:28 43

짧은 요청을 먼저?
ㅇㅇ 그래야 짐이 많을 때 대기시간이 줄어듦. 

가장 첫번째는? 가장 먼저, 요청 시간 짧은.

대기중인 것 중에서!!

time흐르면서
대기 -> pq 등록
*/