import java.io.*;
import java.util.*;

public class Main {
    private static int[] numbers;
    private static int[] op;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        back(numbers[0], 0);

        StringBuilder sb = new StringBuilder();
        sb.append(Collections.max(answer)).append("\n").append(Collections.min(answer));
        System.out.println(sb.toString());
    }

    public static void back(int sum, int depth) {
        if (depth == numbers.length - 1) {
            answer.add(sum);
            return;
        }

        if (op[0] > 0) {
            op[0]--;
            back(sum + numbers[depth + 1], depth + 1);
            op[0]++;
        }
        if (op[1] > 0) {
            op[1]--;
            back(sum - numbers[depth + 1], depth + 1);
            op[1]++;
        }
        if (op[2] > 0) {
            op[2]--;
            back(sum * numbers[depth + 1], depth + 1);
            op[2]++;
        }
        if (op[3] > 0) {
            op[3]--;
            back(sum / numbers[depth + 1], depth + 1);
            op[3]++;
        }
    }
}