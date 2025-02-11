import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.length() < m) {
                continue;
            }

            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            int num = b.getValue().compareTo(a.getValue());
            if (num != 0) {
                return num;
            }
            
            int num2 = Integer.compare(b.getKey().length(), a.getKey().length());
            // compareTo는 int에서는 사용 불가능. 
            if (num2 != 0) {
                return num2;
            }

            return a.getKey().compareTo(b.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getKey()).append("\n");
        }

        System.out.println(sb);
    }
}