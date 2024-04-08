import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parents;

    static class Node implements Comparable<Node> {
        int a, b, cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 그래프 입력 받기
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        Collections.sort(list);

        // 유니온 파인드 부모 배열 초기화
        parents = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parents[i] = i;
        }

        // 크루스칼 알고리즘
        int sum = 0;
        for (Node node : list) {
            int a = node.a;
            int b = node.b;
            int cost = node.cost;
            if (find(a) == find(b)) {
                continue;
            }

            sum += cost;
            union(a, b); // a, b 위치 바꾸면?
        }

        System.out.println(sum);
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return find(parents[a]);
        }
    }

    public static void union(int a, int b) {
        int p = find(a);
        int q = find(b);

        if (p != q) {
            parents[q] = p;
        }
    }
}

/*

 */