import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int front = 0;
        int back = 0;

        for (int i = 0; i < n.length() / 2; i++) {
            front += Integer.parseInt(Character.toString(n.charAt(i)));
        }
        for (int i = n.length() / 2; i < n.length(); i++) {
            back += Integer.parseInt(Character.toString(n.charAt(i)));
        }
        
        String answer = "READY";
        if (front == back) answer = "LUCKY";

        System.out.println(answer);
     }
}
