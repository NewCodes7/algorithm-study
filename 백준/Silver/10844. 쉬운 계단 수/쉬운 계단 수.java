import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());

        long[][] steps = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            steps[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    steps[i][0] = steps[i - 1][1] % mod;
                } else if (j == 9) {
                    steps[i][9] = steps[i - 1][8] % mod;
                } else {
                    steps[i][j] = (steps[i - 1][j - 1] + steps[i - 1][j + 1]) % mod;
                }
            }
        }

        long answer = 0; // 이건 long으로!
        for (int i = 1; i < 10; i++) {
//            answer += steps[n][i] % mod; // 여기도 나눠줘야 해! 이건 의미가 없지!!
            answer = (answer + steps[n][i]) % mod;
        }

        System.out.println(answer);
    }
}

/*
숫자 범위 조심!!

이렇게 가기는 힘들 듯. 가다가 제한되는 게 생겨버리니.. 새로운 방식을 도입해야 함!!

 */