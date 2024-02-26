import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sugarBag = new int[2]; // 3, 5

        while(true) {
            if (n < 0) {
                sugarBag[0] = -1;
            }
            if (n % 5 == 0) break;
            n -= 3;
            sugarBag[0]++;
        }

        sugarBag[1] = n / 5;

        if (sugarBag[0] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(sugarBag[0] + sugarBag[1]);
        }
    }
}