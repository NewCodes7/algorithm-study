import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int s = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String operand = st.nextToken();

            if (operand.equals("all")) {
                s = (1 << 21) - 1;
            } else if (operand.equals("empty")) {
                s = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());

                if (operand.equals("add")) {
                    s = s | (1 << x);
                } else if (operand.equals("remove")) {
                    s = s & ~(1 << x);
                } else if (operand.equals("check")) {
                    int temp = s & (1 << x);
                    int c = 1;
                    if (temp == 0) c = 0;
                    sb.append(c).append("\n");
                } else if (operand.equals("toggle")) {
                    s = s ^ (1 << x);
                }
            }
        }

        System.out.print(sb);
    }
}

/*


 */