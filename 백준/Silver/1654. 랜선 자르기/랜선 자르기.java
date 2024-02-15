import java.io.*;
import java.util.*;

public class Main {
    private static long result;
    private static int n;
    public static void binary(int[] arr, int target, long start, long end) {
        while (start <= end) {
            long mid = (start + end) / 2;
            long k = getK(arr, mid);
            if (k >= target) {
                result = mid; // 굳이 리스트에 다 넣지 않아도 됨. 마지막께 최대란 게 보장되어 있음.
                start = mid + 1;
            } else { // 랜선이 많이 안 잘린 경우. 단위를 낮춰야 함.
                end = mid - 1;
            }
        }
    }

    public static long getK(int[] arr, long unit) {
        long k = 0;
        for (int c : arr) {
            k += c / unit;
        }
        return k;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        result = arr[arr.length-1];
        binary(arr, n, 1, arr[arr.length - 1]);

        System.out.println(result);
    }
}