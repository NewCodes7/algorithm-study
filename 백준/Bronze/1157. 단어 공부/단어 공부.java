import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String str = br.readLine();
        
        // Map<Character, Integer> rank = new HashMap<>();
        int[] rank = new int[26];

        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int idx = Character.toUpperCase(arr[i]) - 'A';
            rank[idx]++;
        }

        char maxStr = '?';
        int maxCount = 0;
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] > maxCount) {
                maxStr = (char) (65 + i);
                maxCount = rank[i];
            } else if (rank[i] == maxCount) {
                maxStr = '?';
            }
        }

        System.out.println(maxStr);
    }
}
