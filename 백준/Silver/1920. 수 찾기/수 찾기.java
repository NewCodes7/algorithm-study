import java.io.*;
import java.util.*;

public class Main {


    public static int binary(int[] arr, long target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            long target = Integer.parseInt(st.nextToken());
            sb.append(binary(arr, target, 0, n-1)).append("\n"); 
        }

        System.out.println(sb);
    }
}