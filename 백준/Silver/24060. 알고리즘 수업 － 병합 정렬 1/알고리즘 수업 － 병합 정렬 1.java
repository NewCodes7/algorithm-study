import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] sorted;
    private static int count;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sorted = new int[n];
        merge_sort(arr, 0, n - 1);

        if (count < k) {
            System.out.println("-1");
        }
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2;

        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left; // 왼쪽 부분리스트의 시작점
        int r = mid + 1; // 오른쪽 부분리스트의 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            } else {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
            count++;
            if (count == k) {
                System.out.println(arr[i]);
            }
        }
    }
}

/*

 */