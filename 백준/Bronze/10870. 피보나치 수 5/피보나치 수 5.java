import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int answer = fibo(n);
        System.out.println(answer);
    }

    private static int fibo(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

}