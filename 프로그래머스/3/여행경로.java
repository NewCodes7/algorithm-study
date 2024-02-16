import java.util.*;

class Solution {
    private static String[] answer;
    private static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> b[1].compareTo(a[1]));
        
        List<String> spot = new ArrayList<>();
        spot.add("ICN");
        dfs(tickets, "ICN", spot, 0);
        
        return answer;
    }
    
    public static void dfs(String[][] tickets, String current, List<String> spot, int idx) {
        if (idx == tickets.length) {
            answer = new String[spot.size()];
            for (int i = 0; i < spot.size(); i++) {
                answer[i] = spot.get(i);
            }
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                spot.add(tickets[i][1]);

                dfs(tickets, tickets[i][1], spot, idx + 1);

                spot.remove(spot.size() - 1);
                visited[i] = false;
            }
        }
        
        

    }
}
/*
bfs, 우선순위 큐 ㄴㄴ 근데 가면 삭제해야 함. 

dfs
인접 그래프로 나타내기 어려움. index가 없어서. 그러면 그냥 배열로
인접 그래프 + sort
방문했으면 해당 티켓 삭제
정답 배열에 하나씩 저장
*/

// 가능한 경로가 2개 이상이라면!!!! 불가능한 경로는 제외시켜야 해... 너무 불친절아녀?
// 문제를 다시 읽는 게 관건이었네. 코드 자체 문제가 아니라.

// 각 티켓 사용 확인을 위해 처음엔 삭제 및 삽입을 고려했지만, 이는 좋은 방법이 아니다. 다시 복구할 때 어려움. 즉, 확장성에 무리가 있음. 무언가 사용, 방문확인할 때는 visited로 처리.