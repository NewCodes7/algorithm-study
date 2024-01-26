class Solution {
    private static boolean[] visited; 
    // 아 컴퓨터는 3개 잖아. 모든 인접 행렬을 방문할 필요가 없어. 양방향 그래프이기에. 
    
    public static void dfs(int n, int[][] computers, int x) {
        visited[x] = true;
        
        for (int i = 0; i < n; i++) {
            int computer = computers[x][i];
            if (computer == 1 && !visited[i] && x != i) {
                dfs(n, computers, i); // y를 할 필요가 없는 듯?
            } 
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
}