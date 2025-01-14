import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String str = br.readLine();
        
        Map<Character, Integer> rank = new HashMap<>();

        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char cur = Character.toUpperCase(arr[i]);

            if (rank.containsKey(cur)) {
                rank.put(cur, rank.get(cur) + 1);
            } else {
                rank.put(cur, 1);
            }
        }

        char maxStr = '?';
        int maxCount = 0;
        for (char key : rank.keySet()) {
            if (rank.get(key) > maxCount) {
                maxStr = key;
                maxCount = rank.get(key);
            } else if (rank.get(key) == maxCount) {
                maxStr = '?';
            }
        }

        System.out.println(maxStr);
    }
}