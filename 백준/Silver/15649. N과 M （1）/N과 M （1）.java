import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[] arr;
    static boolean[] ck;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[2 * M];
        ck = new boolean[N + 1];
        back(0);
        System.out.print(sb);
    }

    static void back(int idx) {
        if (idx == M) {
            arr[2 * M - 1] = '\n';
            sb.append(arr); // arr를 통째로
            return ;
        }

        for (int i = 1; i <= N; i++) {
            if (!ck[i]) {
                ck[i] = true; // 방문 처리
                arr[2 * idx] = (char)(i + '0'); // append 편하게 하려고 ' ' 이것도 쓰려고 char로 쓴 듯.
                arr[2 * idx + 1] = ' '; // 미리 출력 형식 고려
                back(idx + 1);
                ck[i] = false;
            }
        }
    }
}