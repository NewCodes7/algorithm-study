import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] struc = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            struc[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            if (struc[i] == 0) {
                q.offerFirst(c);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        // q에서 하나씩 뽑으며 작동시키기
        StringBuilder sb = new StringBuilder();
        int size = q.size();
        for (int i = 0; i < m; i++) {
            sb.append(q.poll() + " ");
        }

        sb.deleteCharAt(sb.length() -1);

        System.out.println(sb);
    }
}