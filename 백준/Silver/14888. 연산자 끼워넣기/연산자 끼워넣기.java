import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int max = -Integer.MAX_VALUE; // 여기서...!! 음수 나올 수도 있어!!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(nums, arr, 1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void back(int[] nums, int[] arr, int depth, int sum) {
        if (depth == n) {
//            System.out.println(Arrays.toString(arr));
            min = Math.min(sum, min);
            max = Math.max(sum, max);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] == 0) continue;
            int original = sum;
            arr[i]--;
            if (i == 0) sum += nums[depth];
            if (i == 1) sum -= nums[depth];
            if (i == 2) sum *= nums[depth];
            if (i == 3) sum /= nums[depth];

            back(nums, arr, depth+1, sum);

            sum = original;
            arr[i]++;
        }
    }
}

/*
그때 했던 것처럼 배열 각각을 기준으로 해서 백트랙

입력 받기

 */