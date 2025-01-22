import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        String[] nums = br.readLine().split(" ");
        int[] sum = new int[n];
        sum[0] = Integer.parseInt(nums[0]);
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(nums[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if (a == 1) {
                sb.append(sum[b - 1]).append("\n");
                continue;
            }

            sb.append(sum[b - 1] - sum[a - 2]).append("\n");
        }

        System.out.println(sb);
    }
}