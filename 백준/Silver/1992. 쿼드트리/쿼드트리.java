import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) temp[j] - 48; // char to int 제대로!!!
            }
        }

        if (n == 1) { // 예외처리!!!
            System.out.println(arr[0][0]); // 아 괄호까지!! 아니야 괄호는 아니야!!
            return;
        }

        dq(0, 0, n);
        System.out.println(sb);
    }

    private static void dq(int i, int j, int d2) {
        if (j - i == 1) {
            sb.append("(" + arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] + ")");
            return;
        } 

        int d = d2 / 2;
        int a1 = check(i, j, d);
        int a2 = check(i, j + d, d);
        int a3 = check(i + d, j, d);
        int a4 = check(i + d, j + d, d);

        sb.append("(");

        if (a1 == a2 && a2 == a3 && a3 == a4 && a4 != -1) {
            if (d2 == arr.length) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(a1);
            if (d2 == arr.length) {
                return;
            }
            sb.append(")");
            return;
        }

        if (a1 == -1) {
            dq(i, j, d);
        } else {
            sb.append(a1);
        }
        if (a2 == -1) {
            dq(i, j + d, d);
        } else {
            sb.append(a2);
        }
        if (a3 == -1) {
            dq(i + d, j, d);
        } else {
            sb.append(a3);
        }
        if (a4 == -1) {
            dq(i + d, j + d, d);
        } else {
            sb.append(a4);
        }

        sb.append(")");
    }

    private static int check(int a, int b, int d) {
        int num = -1;
        for (int i = a; i < a + d; i++) {
            for (int j = b; j < b + d; j++) {
                if (num == -1) {
                    num = arr[i][j];
                } else {
                    if (num != arr[i][j]) {
                        return -1;
                    }
                }
            }
        }

        return num;
    }
}