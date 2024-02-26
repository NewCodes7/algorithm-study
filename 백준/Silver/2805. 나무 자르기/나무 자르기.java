import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        long start = 0;
        long end = max - 1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            for (int c : arr) {
                if (c > mid) {
                    total += c - mid;
                }
            }

            if (total >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}