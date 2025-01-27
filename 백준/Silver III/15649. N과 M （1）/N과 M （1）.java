import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        back(n, m, new StringBuilder(), 0);

        System.out.println(result);
    }

    private static void back(int n, int m, StringBuilder sb, int depth) {
        if (depth == m) {
            result.append(sb.toString()).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (sb.toString().contains(Integer.toString(i))) {
                continue;
            }

            sb.append(i).append(" ");
            back(n, m, sb, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
