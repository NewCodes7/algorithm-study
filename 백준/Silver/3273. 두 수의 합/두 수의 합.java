import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int left = 0;
        int right = n-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                left++;
                right--;
                answer++;
            } else if (sum > x) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer);

    }
}

/*

 */