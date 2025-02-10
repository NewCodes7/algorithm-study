import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        HashSet<String> set = new HashSet<>();


        for (int i = 1; i <= input.length; i++) {
            for (int j = 0; j + i <= input.length; j++) {
                String str = new String(Arrays.copyOfRange(input, j, j + i));
                set.add(str);
            }
        }

        System.out.println(set.size());
    }
}
