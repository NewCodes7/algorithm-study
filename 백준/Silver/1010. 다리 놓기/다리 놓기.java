import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (m / 2 < n) {
                n = m - n;
            }

            double answer = 1;

            for (int a = m; a >= m - n + 1; a--) {
                answer *= a;
            }
            for (int b = n; b > 0; b--) {
                answer /= b; 
            }

            sb.append((int) answer).append("\n");
        }

        System.out.println(sb);
    }
}