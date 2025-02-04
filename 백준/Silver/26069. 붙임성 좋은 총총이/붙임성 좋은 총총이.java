import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");
        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            boolean b1 = set.contains(a);
            boolean b2 = set.contains(b);

            if (b1 && b2) {
                continue;
            } else if (b1 && !b2) {
                set.add(b);
                answer++;
            } else if (!b1 && b2) {
                set.add(a);
                answer++;
            } 
        }

        System.out.println(answer);
    }
}
