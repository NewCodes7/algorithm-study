import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(combination(m, n)).append("\n");
        }
        System.out.println(sb);
    }

    // mCn 계산 (정수 연산 사용)
    private static long combination(int m, int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= (m - i);
            result /= (i + 1);
        }
        return result;
    }
}
