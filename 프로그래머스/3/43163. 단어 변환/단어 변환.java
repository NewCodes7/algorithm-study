import java.util.*;

class Solution {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] d;
    
    public static int getDifference(String a, String b) {
        int count = 0;
        String[] arrA = a.split("");
        String[] arrB = b.split("");
        
        for (int i = 0; i < arrA.length; i++) {
            if (!arrA[i].equals(arrB[i])) { // 조심!!
                count++;
            }
        }
        
        return count;
    }
    
    public static int bfs(List<Integer> start, String target, String[] words) {
        Queue<Integer> q = new LinkedList<>();
        for (Integer c : start) {
            q.offer(c);
            visited[c] = true;
        }
        
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    d[y] += d[x];     
                    q.offer(y);
                    visited[y] = true;
                    if (words[y].equals(target)) return d[y];
                }
            }
        }
        
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        visited = new boolean[n];
        d = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            d[i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && getDifference(words[i], words[j]) == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        List<Integer> startQ = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (getDifference(begin, words[i]) == 1) {
                if (words[i].equals(target)) return 1;
                startQ.add(i);
            }
        }
        
        System.out.println(graph);

        
        /*
        begin을 0이라 하면
        begin과 다른 개수만큼을 부여하면 됨. 
        +1씩 해나가기. 그러나 begin만을 기준으로 하면 안 됨. 기준은 계속 바뀜.
        
        word 각각을 node라 생각하고,
        순서대로 0번부터 순서 부여
        하나씩 다른 걸 저장해두자.
        */
        // 아 dfs처럼 해버림. 그럼 이렇게 하면 dfs로도 최단 경로 구할 수 있겠네 (보류)
        
        return bfs(startQ, target, words);
    }
}