import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());
        arr = new int[m];

        back(1, 0);

        System.out.println(sb);
    }

    private static void back(int at, int depth) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            back(i, depth + 1);
        }
    }
}