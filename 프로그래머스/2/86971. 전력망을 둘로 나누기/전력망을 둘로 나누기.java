import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int cnt = 0;
    private static List<List<Integer>> graph = new ArrayList<>();
    
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        visited = new boolean[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int c = wire[0];
            // 아 그래프 간선 삭제하는 작업 안함. 메서드까지는 생각해뒀는데. 
            // 설계할 때 생각나는 거 있으면 우선 모조리 적어둬야 함.
            // 정갈하게 적어두는 건 마지막에 고치면 됨.
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            
            dfs(n, wires, c); // 왜 야기도 i야!!! c지 임마
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
            cnt = 0;
            visited = new boolean[n+1];
        }
        
        return answer;
    }
    
    public static void dfs(int n, int[][] wires, int c) { // c 방문처리?
        visited[c] = true;
        cnt++;
        
        for(int i = 0; i < graph.get(c).size(); i++) {
            if (!visited[graph.get(c).get(i)]) { // 여기도 마찬가지 그냥 i가 아니다!
                // visited[i] = true; // 여기서 해버리면 그 다음 dfs 이루어질 수 없음
                dfs(n, wires, graph.get(c).get(i)); // 그냥 i를 하는 게 아니지!!
            }
        }
    }
}

/*
완전탐색 쌉가능
반복문 - wires에서 하나씩 돌면서 끊긴 것을 기준으로 각각 dfs?
-> 이러려면 미리 그래프 저장해둬야 할 듯. 인접 리스트?
하나만 dfs해도 개수파악할 수 있음.

전처리 - 그래프 인접리스트 저장 (양방향!!)
반복문 - wires
    선택된 Wire 중 첫번째 골라서 dfs 시도
        반복문 - 선택된 wire의 리스트
            방문했는지 확인
                방문했으면, 넘겨
                안했으면, 현황+1하고 방문처리 후 dfs
    cnt 초기화
    절댓값 계산, 비교, 저장 (혹시 0이면 바로 리턴가능)

많이 쉬워보이거나 많이 길이 보여도 차분해야 한다. 꾹꾹 눌러서!!
*/