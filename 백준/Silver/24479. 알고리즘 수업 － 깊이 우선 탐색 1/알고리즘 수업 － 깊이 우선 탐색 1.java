import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] order;
    private static int R, idx = 0;

    public static void dfs(int x) {
        visited[x] = true;
        idx++;
        order[x] = idx;

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        order = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // N개 줄이 아니라 M개 줄!!
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y); // 무방향 그래프여서 여기서 만족하면 안 됨!!
            graph.get(y).add(x);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < order.length; i++) {
            sb.append(order[i] + "\n"); // 여기서 급해서 그냥 i라해버림. 급하게 ㄴㄴ!!
        }

        System.out.println(sb);
    }
}