import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int maxInt = -1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++) {
                int nextInt = Integer.parseInt(st.nextToken());
                if (maxInt < nextInt) {
                    maxInt = nextInt;
                    y = i+1;
                    x = j+1;
                }
            }
        }

        sb.append(maxInt).append("\n").append(y).append(" ").append(x);
        System.out.print(sb);
    }
}