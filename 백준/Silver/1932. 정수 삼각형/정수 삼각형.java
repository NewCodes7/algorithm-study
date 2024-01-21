import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][];
        graph[0] = new int[] {Integer.parseInt(br.readLine())};

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            int[] pair = new int[cnt];

            for (int j = 0; j < cnt; j++) { // 메서드 기억.. 실시간으로 개수 변하나?
                int c = Integer.parseInt(st.nextToken());
                int a = 0;
                int b = 0;
                if (j != 0) {
                    a = graph[i-1][j-1] + c;
                }
                if (j != cnt - 1) { // 여기도 마찬가지
                    b = graph[i-1][j] + c;
                }
                pair[j] = Math.max(a, b);
            }
            graph[i] = pair;
        }

        System.out.println(Arrays.stream(graph[graph.length-1]).max().getAsInt());
    }
}