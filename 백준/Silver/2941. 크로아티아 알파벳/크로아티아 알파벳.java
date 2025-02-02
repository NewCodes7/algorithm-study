import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] arr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        for (String str : arr) {
            input = input.replaceAll(str, "0");
        }

        System.out.println(input.length());
    }
}
