import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][];
        graph[0] = new int[] {Integer.parseInt(br.readLine())};

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            int[] pair = new int[cnt];

            for (int j = 0; j < cnt; j++) {
                int c = Integer.parseInt(st.nextToken());
                int a = 0, b = 0;
                if (j != 0) {
                    a = graph[i-1][j-1] + c;
                }
                if (j != cnt - 1) { 
                    b = graph[i-1][j] + c;
                }
                pair[j] = Math.max(a, b);
            }

            graph[i] = pair;
        }

        System.out.println(Arrays.stream(graph[graph.length-1]).max().getAsInt());
    }
}