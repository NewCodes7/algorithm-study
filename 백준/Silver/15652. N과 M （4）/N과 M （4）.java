import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static char[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void back(int idx, int i) {
        if (idx == M) {
            arr[2*M - 1] = '\n';
            sb.append(arr);
            return;
        }

        for (i = i; i <= N; i++) {
            arr[2 * idx] = (char) (i + '0'); // 그냥 i로 저장하면 그저 아스키코드로 됨. 0 평행이동!!
            arr[2 * idx + 1] = ' ';
            back(idx + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[2 * M];

        back(0, 1);

        System.out.println(sb.toString());
    }
}