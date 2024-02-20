import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        int[] sorted = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 복사하는 거 생각보다 드물다. 이전에 가능한지 고민.
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(sorted, arr[i]);
            int cnt = 1;
            if (idx >= 0) {
                if (map.containsKey(sorted[idx])) {
                    cnt += map.get(sorted[idx]);
                }
                map.put(sorted[idx], cnt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int c : arr2) {
            if (map.get(c) == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(map.get(c)).append(" ");
            }
        }

        System.out.println(sb);
    }
}