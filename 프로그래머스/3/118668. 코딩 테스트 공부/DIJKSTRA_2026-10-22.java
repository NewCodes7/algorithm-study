import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        // 최대 찾기 
        int alp_max = 0; 
        int cop_max = 0;
        for (int[] problem : problems) {
            alp_max = Math.max(alp_max, problem[0]);
            cop_max = Math.max(cop_max, problem[1]);
        }
        
        // dp 초기화 
        // 크게 키울 필요가 없음. 한 쪽 넘으면 최대로 두면 되기에. 변별력은 없으니까
        int[][] dp = new int[alp_max + 1][cop_max + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // 다익스트라 느낌으로 우선순위 큐 토대로 dp 갱신 
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // pq 사용법 숙지필요!
        alp = Math.min(alp, alp_max);
        cop = Math.min(cop, cop_max);
        pq.offer(new int[]{alp, cop, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int alp_cur = curr[0];
            int cop_cur = curr[1];
            int cost_cur = curr[2];
            
            // 여기서 dp 바로 할당하면 안 됨. 그 사이 더 최소가 할당됐을 수 있음
            if (cost_cur < dp[alp_cur][cop_cur]) {
                dp[alp_cur][cop_cur] = cost_cur;
            } else { // 이것까지!! 할 필요가 없는 노드임 
                continue;
            }
            
            // 정답 체크
            if (alp_cur >= alp_max && cop_cur >= cop_max) {
                return cost_cur;
            }
            
            // (1, 0)
            // dp 현재 더 적은 거 있는 지 검사해야 하나? 
            int alp_new = Math.min(alp_cur + 1, alp_max);
            if (cost_cur + 1 < dp[alp_new][cop_cur]) {
                pq.offer(new int[]{alp_new, cop_cur, cost_cur + 1});
            }
            
            // (0, 1)
            int cop_new = Math.min(cop_cur + 1, cop_max);
            if (cost_cur + 1 < dp[alp_cur][cop_new]) {
                pq.offer(new int[]{alp_cur, cop_new, cost_cur + 1});
            }
            
            // problems
            for (int i = 0; i < problems.length; i++) {
                int[] problem = problems[i];
                int alp_req = problem[0];
                int cop_req = problem[1];
                int alp_rwd = problem[2];
                int cop_rwd = problem[3];
                int cost = problem[4];
                
                alp_new = Math.min(alp_max, alp_cur + alp_rwd);
                cop_new = Math.min(cop_max, cop_cur + cop_rwd);
                int cost_new = cost_cur + cost;
                
                if (alp_cur >= alp_req && cop_cur >= cop_req && cost_new < dp[alp_new][cop_new]) {
                    pq.offer(new int[]{alp_new, cop_new, cost_new});
                }
            }
        }
        
        return 0;
    }
}

/*
1945~2008 23분 효율성 테스트는 런타임 에러, 시간 초과 

dp[알고력][코딩력]
알고력과 코딩력은 최대 150까지만 됨 
각 알고력과 코딩력에 도달하기까지 걸린 시간을 메모 

가장 최소인 것들을 토대로 최소를 갱신하기 
PriorityQueue
처음에는 alp, cop
(1, 0), (0, 1), problems들 중 하나 
다익스트라 느낌으로 
cost는 더 낮아질 수 없음. 음의 가중치가 없으니 

---

2012~2027 15분 
dp 조건 걸었지만 여전히 에러 

가지치기를 해야하는데 그러면 
cost는 앞으로 점점 높아질 거고 
그러면 알고력, 코딩력을 토대로 걸러볼까 
cost는 더 높은데 기존의 알고력, 코딩력보다 낮은 건 거르기 
그런데 이게 수치적으로 어느정도의 효과를 가져다줄까? 
음 이렇게 하니 오히려 시간 복잡도 올라간 느낌

---

ai 피드백

아 내가 놓친 게 있었구나! - 150 제한 

피드백
1. 알고력, 코딩력으로 하는 게 구현 자체는 더 쉽네 
2. continue 사용 주의! 
    while 문 내에서 
    // for (int i = alp_cur; i < dp.length; i++) {
    //     for (int j = cop_cur; j < dp[i].length; j++) {
    //         if (cost_cur <= dp[i][j]) {
    //             continue; // 이 중 반복문이어서 안쪽 루프에만 적용됨!
    //         }
    //     }
    // }
    바깥까지 하려면? 
3. PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // pq 사용법 숙지필요!
    () 안에 들어갈 수 있는 것들? 
4. dp를 하면서 일일이 모든 범위에 대해서 적을 필요 없음. 답의 조건과 상관없는 부분이라면 변형해서 저장 가능
    int alp_new = Math.min(alp_cur + 1, alp_max);로 저장 


*/
