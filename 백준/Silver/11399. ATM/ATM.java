import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] times = new Integer[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.valueOf(st.nextToken()); // parseInt로는 안 됨!
        }

        Arrays.sort(times, Collections.reverseOrder()); // primitive 적용 불가능

        int sumTimes = 0;
        for (int i = 0; i < n; i++) {
            sumTimes += times[i] * (i + 1);
        }

        System.out.println(sumTimes);
    }
}

/*

 */