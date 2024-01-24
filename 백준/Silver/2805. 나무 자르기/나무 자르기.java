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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long start = 0;
        long end = arr[arr.length - 1] - 1;
        long result = start;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            for (int c : arr) {
                if (c > mid) {
                    total += c - mid;
                }
            }

            if (total >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}