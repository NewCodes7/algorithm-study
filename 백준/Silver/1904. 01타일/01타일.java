import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 15746;
        }

        System.out.println(arr[n]);
    }
}

/*
1 -> 1
2 -> 2
3 -> 3
4 -> 5

피보나치인 것 증명하기
프로그래밍에게 맡기는 것도 중요하지만, dp에서는 능동적으로 규칙성 찾는 것 중요하다!

00, 1

15746으로 나누기!!

제곱 연산이 무한을 넘겨 버림. 2의 5000제곱 해버리니..

dp는 다시 다 풀어봐야 할 듯
 */