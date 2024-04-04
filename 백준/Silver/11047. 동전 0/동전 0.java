import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Stack<Integer> units = new Stack();
        for (int i = 0; i < n; i++) {
            units.push(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int c = units.pop();

            int d = k / c;
            answer += d;
            k -= d * c;

            if (k == 0) break;
        }

        System.out.println(answer);
    }
}

/*

 */