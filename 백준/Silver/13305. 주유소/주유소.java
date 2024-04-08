import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        long[] edges = new long[n - 1];
        long[] oilPrices = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            edges[i] = Integer.parseInt(st.nextToken()); // integer로 해도 되나? long으로 해야 되나? 자동 형변환?
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oilPrices[i] = Integer.parseInt(st.nextToken());
        }

        /*
        2 3 1 edges
        5 2 4 1 prices
         */
        long sum = 0;
        long curr = oilPrices[0]; // 5
        for (int i = 1; i <= n - 1; i++) {
            sum += edges[i - 1] * curr;
            if (curr > oilPrices[i]) {
                curr = oilPrices[i];
            }
        }

        System.out.println(sum);
    }
}