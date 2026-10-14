import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        
        Queue<Integer[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(new Integer[]{destination, 0});
        visited[destination] = true;
        while (!q.isEmpty()) {
            Integer[] curr = q.poll();
            
            for (int i = 0; i < sources.length; i++) {
                if (curr[0] == sources[i]) {
                    answer[i] = curr[1];
                }
            }
            
            for (int i = 0; i < map.get(curr[0]).size(); i++) {
                int next = map.get(curr[0]).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Integer[]{next, curr[1] + 1});
                }
            }
        }
        
        return answer;
    }
}

/*
22:33~22:44 11분
*/
