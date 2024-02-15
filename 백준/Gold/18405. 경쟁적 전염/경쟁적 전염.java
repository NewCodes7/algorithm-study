import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int virus; // 아.. static이라 해버림..아 그래서 마지막에 저장된 걸로 값이 다 바뀌어버림. 다 3으로

    public Node(int x, int y, int virus) {
        this.x = x;
        this.y = y;
        this.virus = virus;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y; // 와 여기 오타! x라 해버림
    }

    public int getVirus() {
        return this.virus;
    }

    @Override
    public int compareTo(Node other) { // 여기서 문제 생긴건가?
        return this.getVirus() - other.getVirus();
    }
}

public class Main {
    private static int[][] graph;
    private static int n, s;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void bfs(PriorityQueue<Node> q1, int idx) {
        if (idx == s) {
            return;
        }

        PriorityQueue<Node> q2 = new PriorityQueue<>();
        while (!q1.isEmpty()) {
            Node current = q1.poll();

            for (int i = 0; i < 4; i++) {
                int x = current.getX() + dx[i];
                int y = current.getY() + dy[i];

                if (x < 1 || x > n || y < 1 || y > n) {
                    continue;
                }

                if (graph[x][y] == 0) {
                    graph[x][y] = current.getVirus();
                    q2.offer(new Node(x, y, graph[x][y]));
                }
            }
        }
        bfs(q2, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        PriorityQueue<Node> q1 = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int virus = Integer.parseInt(st.nextToken());
                graph[i][j] = virus;
                if (virus != 0) {
                    Node node = new Node(i, j, virus);
                    q1.offer(node);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bfs(q1, 0);

        System.out.println(graph[x][y]);
    }
}