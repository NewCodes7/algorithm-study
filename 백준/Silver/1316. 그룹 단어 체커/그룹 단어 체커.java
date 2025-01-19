import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int answer = n;
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            boolean[] checker = new boolean[26];

            checker[arr[0] - 97] = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] == arr[j]) {
                    continue;
                } 

                if (!checker[arr[j] - 97]) {
                    checker[arr[j] - 97] = true;
                    continue;
                }

                answer--;
                break;
            }
        }

        System.out.println(answer);
    }

}