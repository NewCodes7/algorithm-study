import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        arr = new int[m];
        visited = new boolean[n + 1];

        dfs(n, m, 0);

        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int start;
        if (depth == 0) {
            start = 1;
        } else {
            start = arr[depth - 1];
        }

        for (int i = start; i <= n; i++) {
            if (visited[i]) continue;
            arr[depth] = i;
            visited[i] = true;
            dfs(n, m, depth + 1);
            visited[i] = false;
        }
    }
}