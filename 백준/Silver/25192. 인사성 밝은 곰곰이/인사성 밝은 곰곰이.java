import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Boolean> chat = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                chat = new HashMap<>();
            } else {
                if (!chat.containsKey(input)) {
                    answer++;
                    chat.put(input, true);
                }
            }
        }

        System.out.println(answer);
    }
}
