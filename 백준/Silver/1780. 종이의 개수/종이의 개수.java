import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static int[] answer = new int[3];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dq(0, 0, n);

        sb.append(answer[0]).append("\n");
        sb.append(answer[1]).append("\n");
        sb.append(answer[2]);
        System.out.println(sb);
    }

    public static void dq(int iStart, int jStart, int size) {
        int num = arr[iStart][jStart];
        for (int i = iStart; i < iStart + size; i++) {
            for (int j = jStart; j < jStart + size; j++) {
                if (num != arr[i][j]) {
                    num = -2;
                    break;
                }
            }
        }

        if (num == -2) {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dq(iStart + newSize * i, jStart + newSize * j, newSize);
                }
            }
        } else {
            answer[num + 1]++;
        }
    }
}
