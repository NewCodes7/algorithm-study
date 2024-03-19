import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        fibo(n);
        fibo2(n);
        sb.append(cnt + " " + (n-2));

        System.out.println(sb);
    }

    public static int fibo(int n) {
        if (n == 1 || n == 2) {
            cnt++;
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2); // 원리 학습하기
        }
    }

    public static int fibo2(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }
}

/*
5 - 4,3
4 - 3,2
3 - 2,1
3 - 2,1
 */
