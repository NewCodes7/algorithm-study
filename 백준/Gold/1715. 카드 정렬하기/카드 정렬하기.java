import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while (pq.size() != 1) {
            int c = pq.poll() + pq.poll();
            total += c;
            pq.add(c);
            if (pq.size() == 0) {
                break;
            }
        }

        System.out.println(total);
        // 더하는 횟수는 정해져 있음. n-1번
        // 그렇다면 중복해서 더해지는 걸 작게 유지할 필요가 있음.
    }
}
