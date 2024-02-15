import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 1; i < s.length; i++) {
            if (s[i].equals("0") && s[i-1].equals("1")) {
                oneCnt++;
            }
            if (s[i].equals("1") && s[i-1].equals("0")) {
                zeroCnt++;
            }
        }

        if (s[s.length-1].equals("1")) {
            oneCnt++;
        } else {
            zeroCnt++;
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
     }
}
