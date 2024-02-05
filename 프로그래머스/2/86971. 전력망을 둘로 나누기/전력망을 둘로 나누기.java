import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = (int) 1e9;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n-1; i++) {
            graph.get(wires[i][0]).add(wires[i][1]); // 그 반대도 추가해야 함. 양방향 그래프나 마찬가지.
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        for (int i = 0; i < n-1; i++) {
            graph.get(wires[i][0]).remove(Integer.valueOf(wires[i][1])); // 원리?
            graph.get(wires[i][1]).remove(Integer.valueOf(wires[i][0])); // 삭제도 마찬가지로 양쪽에!!
            
            int count = bfs(graph, 1, 1, n); // count 0이 아니라 1시작.
            answer = Math.min(Math.abs(count - (n - count)), answer);
            
            graph.get(wires[i][0]).add(wires[i][1]); // 원상복구
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        return answer;
    }
    
    public static int bfs(List<List<Integer>> graph, int start, int count, int n) {
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        if (graph.get(start).isEmpty()) start++;
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            List<Integer> list = graph.get(q.poll());
            for (int c : list) {
                if (!visited[c]) {
                    count++;
                    q.offer(c);
                    visited[c] = true;
                }

            }
        }
        
        return count;
    }
}

/*
트리 형태로 연결!
트리 노드 & dfs? 
인접리스트 & dfs? 끊을 것 선택 -> dfs로 세기
*/