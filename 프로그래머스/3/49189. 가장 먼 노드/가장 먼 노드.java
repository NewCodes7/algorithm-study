import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int[] d;
    private static int max = 0;
    private static List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        d = new int[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        bfs(n);
        
        for (int i = 0; i <= n; i++) {
            if (d[i] == max) answer++;
        }
        
        return answer;
    }
    
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int c = q.poll();
            
            for (int i = 0; i < graph.get(c).size(); i++) {
                int next = graph.get(c).get(i);
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    d[next] = d[c] + 1;
                    
                    if (d[next] > max) {
                        max = d[next];
                    }
                }
            }
        }
        
    }
}

/*

*/