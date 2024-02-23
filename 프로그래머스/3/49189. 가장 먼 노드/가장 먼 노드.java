import java.util.*;

class Solution {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] d;
    private static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        d = new int[n+1];
        visited = new boolean[n+1];
            
        for (int i = 0; i <= n; i++) { // 등호! 검증하길 잘했네
            graph.add(new ArrayList<>());
        }
        
        for (int[] c : edge) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }
        bfs(1);
        
        int max = Arrays.stream(d).max().getAsInt();
        for (int i = 1; i <= n; i++) {
            if (d[i] == max) {
                answer++;
            }
        }
        // System.out.println();
        
        return answer;
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int c = q.poll();
            
            for (int i = 0; i < graph.get(c).size(); i++) {
                int next = graph.get(c).get(i);
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    d[next] = d[c]+1;
                }
            }
        }
    }
}

/*
10:59~
양방향!

bfs 
    max, count 갱신
*/