import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long left = 1, right = K;
        long ans = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2; 
            long cnt = 0;
            
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N); // 대각선이 아닌 가로로 보면 해결방안이 있음. (아이디어 간단한 걸로 찾자.)
            }

            if (cnt < K) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}