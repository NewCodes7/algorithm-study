import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열, 최댓값 초기화
        int[] sequence = new int[n];
        sequence[0] = Integer.parseInt(st.nextToken());
        int max = sequence[0];

        for (int i = 1; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());

            // 이전 값이 0보다 크면 연속해서 더할 필요 있음.
            if (sequence[i - 1] >= 0) {
                sequence[i] += sequence[i - 1];
            }

            max = Math.max(max, sequence[i]);
        }

        System.out.println(max);
    }
}