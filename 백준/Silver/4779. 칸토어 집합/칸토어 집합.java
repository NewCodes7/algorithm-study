import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        // 입력 받기
        while (true) {
            int n;
            try {
                n = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                break;
            }
            int count = (int) Math.pow(3, n);
            arr = new boolean[count];
            recursion(0, count);

            for (int i = 0; i < count; i++) {
                if (arr[i]) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
            }
    
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursion(int start, int end) {
        if (end - start == 1) {
            arr[start] = true;
            return;
        }

        int slice = (end - start) / 3;

        recursion(start, start + slice);
        recursion(end - slice, end);
    }
}