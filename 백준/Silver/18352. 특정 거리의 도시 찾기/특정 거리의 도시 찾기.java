import java.io.*;
import java.util.*;

public class Main{
    private static List<List<Integer>> graph = new ArrayList<List<Integer>>(); // 차이점?
    private static boolean[] visited; // visited를 distance로 대체할 수 있는 이유?
    private static int[] distance;

    private static void bfs(int start) { // 스태틱?
        Queue<Integer> q = new LinkedList<>(); // 큐 공부하기
        q.offer(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (distance[y] == -1) { // 이미 갱신된 건 최소가 보장된 것
                    distance[y] = distance[x] + 1;
                    q.offer(y);
                }
            }
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 다익스트라와의 차이점?

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        distance = new int[n+1];

        for (int i = 0; i <= n; i++) { // 등호
            graph.add(new ArrayList<Integer>());
            distance[i] = -1;
        }
        distance[x] = 0;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        bfs(x);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (distance[i] == k) {
                sb.append(i + "\n");
            }
        }

        if (sb.toString() == "") sb.append("-1");

        System.out.println(sb.toString());
     }
}
