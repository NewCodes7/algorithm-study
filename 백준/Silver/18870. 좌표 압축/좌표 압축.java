import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] arr2 = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr2);

        Map<Integer, Integer> map = new HashMap();
        int rank = 0;
        for (int c : arr2) {
            if (!map.containsKey(c)) { // map의 특성을 잘 활용한 재치있는 풀이.
                map.put(c, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.println(sb);
    }
}