import java.io.*;
import java.util.*;

public class Main{
    private static int n;
    private static List<String> op = new ArrayList<>();
    private static List<Integer> numbers = new ArrayList<>();
    private static List<Integer> repository = new ArrayList<>();
    private static int result;

    public static void permute(int start, int end) {
        if (start == end) {
            calculate();
            return;
        }

        for (int i = start; i < end; i++) {
            Collections.swap(op, start, i);
            permute(start + 1, end);
            Collections.swap(op, start, i); // backtrack
        }
    }

    public static void calculate() {
        result = numbers.get(0);
        for (int i = 0; i < n-1; i++) {
            if (op.get(i) == "+") {
                result += numbers.get(i+1);
            }
            if (op.get(i) == "-") {
                result -= numbers.get(i+1);
            }
            if (op.get(i) == "*") {
                result *= numbers.get(i+1);
            }
            if (op.get(i) == "/") {
                result /= numbers.get(i+1);
            }
        }
        repository.add(result);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        String[] oper = {"+", "-", "*", "/"};
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            while (count != 0) {
                op.add(oper[i]);
                count--;
            }
        }

        permute(0, n-1);

        System.out.print(Collections.max(repository) + "\n" + Collections.min(repository));
     }
}
