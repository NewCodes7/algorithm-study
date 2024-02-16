import java.io.*;
import java.util.*;

public class Main{
	public static void main (String args[]) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        int[][] resultArr = new int[n][m];
        
        for (int i = 0; i < n * 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                resultArr[i % n][j] += Integer.parseInt(st.nextToken());
                if (i >= n) {
                    sb.append(resultArr[i % n][j]).append(" ");
                }
            }
            if (i >= n) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
	}
}