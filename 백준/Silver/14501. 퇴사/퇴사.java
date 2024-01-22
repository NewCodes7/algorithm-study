import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] result;
    private static int[][] plan;
    public static void back(int idx, int total) {
        if (idx >= n) {
            return;
        }

        for (idx = idx; idx < n; idx++) {
            if (idx + plan[idx][0] - 1 < n) {
                result[idx + plan[idx][0] - 1] = Math.max(result[idx + plan[idx][0] - 1], total + plan[idx][1]);
            }

            back(idx + plan[idx][0], total + plan[idx][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        result = new int[22];
        plan = new int[22][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] day = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            plan[i] = day;
        }

        back(0, 0);

        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}