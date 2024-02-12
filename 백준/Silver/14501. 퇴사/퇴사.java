import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken()); // 상담 하는데 걸리는 일 수
            P[i] = Integer.parseInt(st.nextToken()); // 돈
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                DP[i + T[i]] = Math.max(DP[i + T[i]], DP[i] + P[i]); // 그냥 갈 것인가? 써먹을 것인가?
            }
            DP[i+1] = Math.max(DP[i+1], DP[i]); // 현재 누적값 vs 다음 누적값 (그냥 가게하는)
        }

        System.out.println(DP[N]);
    }
}