import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> people = new ArrayList<>();
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people.add(Integer.parseInt(st.nextToken()));
            dp[i] = 1;
        }

        Collections.reverse(people);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (people.get(j) < people.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int c : dp) {
            max = Math.max(max, c);
        }

        System.out.println(n - max);
    }
}