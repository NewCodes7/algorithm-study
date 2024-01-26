import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] order;
    private static int idx = 1;

    public static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        order[start] = idx;

        while(!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    idx++;
                    order[y] = idx;
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        order = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < order.length; i++) {
            sb.append(order[i] + "\n");
        }

        System.out.println(sb);
    }
}