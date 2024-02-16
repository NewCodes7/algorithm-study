import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 666;
        int idx = 0;
        while (true) {
            if (check666(answer)) {
                idx++;
                if (idx == n) break;
                answer++;
            } else {
                if (answer % 10 < 6) {
                    answer += 6 - answer % 10;
                } else {
                    answer += 10 - answer % 10;
                }
            }
            // 666 있는지 확인
            // 있으면 cnt++;
            // 없으면 그리고 6보다 작다면 6으로, 6보다 크거나 같다면 0으로,
        }

        System.out.println(answer);
    }

    public static boolean check666(int answer) {
        int cnt = 0;
        while (answer >= 6) { // 조정
            int c = answer % 10;
            if (c == 6) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == 3) return true;
            answer /= 10;
        }

        return false;
    }
}