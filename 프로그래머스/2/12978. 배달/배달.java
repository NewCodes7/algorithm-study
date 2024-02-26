import java.util.*;

class Solution {
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] d;
    
    private static class Node implements Comparable<Node> {
        int idx;
        int cost;
        
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2])); // 양방향 그래프!! 코드 한줄 생각!!
        }

        dijkstra(1);
        System.out.println(Arrays.toString(d));
        
        for (int i = 1; i <= N; i++) {
            if (d[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        
        while (!pq.isEmpty()) {
            Node c = pq.poll();
            
            if (c.cost > d[c.idx]) continue;
            
            for (int i = 0; i < graph.get(c.idx).size(); i++) {
                Node next = graph.get(c.idx).get(i);
                int cost = c.cost + next.cost;
                
                if (d[next.idx] > cost) {
                    pq.offer(new Node(next.idx, cost));
                    d[next.idx] = cost;
                }
            }
        }
    }
}