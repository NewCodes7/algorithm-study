import java.io.*;
import java.util.*;

public class Main{
    private static int n, m;
    private static List<Integer> result = new ArrayList<>();

    public static void permute(int count) {
        if (count == m) { // m이 3이든 4이든 적용될 수 있어야함. 백트랙킹 내부코드에서 수정할 필요가 있어보임.
            StringBuilder sb = new StringBuilder();
            for (int c : result) {
                sb.append(c).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!result.contains(i)) {
                result.add(i);
                count++;
                permute(count);
                result.remove(result.size()-1);
                count--;
            }

        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        permute(0);
     }
}
