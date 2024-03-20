import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ") = ");
            sb.append(process(a, b, c) + "\n");
        }

        System.out.println(sb);
    }

    public static int process(int i, int j, int k) {
        if ((i > 0 && j > 0 && k > 0 && i <= 20 && j <= 20 && k <= 20) && arr[i][j][k] != 0) {
            return arr[i][j][k];
        } else if (i <= 0 || j <= 0 || k <= 0) {
            return 1;
        } else if (i > 20 || j > 20 || k > 20) {
            return arr[20][20][20] = process(20, 20, 20);
        } else if (i < j && j < k) {
            return arr[i][j][k] = process(i, j, k-1) + process(i, j-1, k-1) - process(i, j-1, k);
        } else {
            return arr[i][j][k] = process(i-1, j, k) + process(i-1, j-1, k) + process(i-1, j, k-1) - process(i-1, j-1, k-1);
        }
    }
}

/*
다시 처음부터!
설계하고 들어가자!
문제 꼼꼼히 읽고!
차분하게 한 줄 한 줄 !! 쉬운 문제는 없다!


 */