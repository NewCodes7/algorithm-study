import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] word = new char[15][5];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length();  j++) {
                word[j][i] = str.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (word[i][j] != 0) {
                    sb.append(word[i][j]);
                }
            }
        }
        System.out.print(sb);
    }
}