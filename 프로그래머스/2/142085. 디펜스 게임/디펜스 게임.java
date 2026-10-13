import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // 무적권이 더 많다면 다 통과하므로 바로 반환 
        if (k >= enemy.length) {
            return enemy.length;
        }
        
        // 최대 정보 알아내기 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < enemy.length; i++) {
            // 일단 무적권 k 채워 
            if (pq.size() < k) {
                pq.offer(enemy[i]);
                continue;
            }
            
            // 현재 무적권 최소보다 큰 게 있을 때 
            if (enemy[i] > pq.peek()) {
                if (sum + pq.peek() <= n) {
                    sum += pq.poll();
                    pq.offer(enemy[i]);
                } else {
                    return i;
                }
            } else {
                if (sum + enemy[i] <= n) {
                    sum += enemy[i];
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}

/*
10:20~10:46 25
10:53~11:08 14
11:11~11:22 10
49분 시간초과 + 실패 -> 68.8
enemy 이중반복이어서 넘네. <- 다 풀고나서 히든테케 고려할 때 예외테케만을 고려하기보다는 시간복잡도 자체도 고려하기 

11:23~11:31 8분 
총 57분 투자 

아.. 무적권을 어디서 썼는지 추적할 필요가 없네
우선순위 큐에 싹 enemy 넣어두고 상위 k개 짜르면 되네 
하나씩 순회하면서 큐에 넣고
상위 k개 제외하고 현재 n에 충족하는지 확인 

피드백
1. pq 관련 사용법 정리하기 
2. 중첩 클래스 정리하기 
3. 실수했던 부분들 정리하기 
4. 사고방식 정리 - 시간복잡도 

힌트 받고 
84.4 + 실패 


현재 남은 병사 < enemy[i] 라면 무적권을 무조건 써야 함 
조합으로 풀기엔 시간 복잡도 너무 높음

확실한 건 무적권을 처음부터 다 써버리면 불리함 

높은 적들일 때 무적권을 써야 함 
처음부터 순회하면서 높은 enemy 순으로 무적권 쓸 곳 체크해두면 될 듯 
그런데 강한 적들이 뒤에 있다면 무적권을 다 못 쓸 수도 있음 
그러면 가장 뒤에 있는 무적권을 앞 중에서 가장 최대인 곳에서 쓰기 
만약 최대가 여러 개라면 앞 or 뒤 -> 앞 우선 (비용은 똑같고 앞에서 먼저 지불하는 것일뿐)

1. enemy 순회하면서 max인 것들 무적권 체크해두기 
2. 가장 끝에 있는 무적권까지 도달할 수 있는지 확인 
    도달할 수 있다면 진행하기 
        enemy 처음부터 순회하면서 n 차감시켜나가기
        return answer
    도달할 수 없다면
        가장 뒤에 있는 무적권을 앞 중에서 가장 최대이면서 앞에 있는 곳에 옮기기 
        2로 다시 돌아가기 

그런데 굳이 거꾸로 안 가고 순차적으로 가다가 멈춰도 될 듯 

*/
