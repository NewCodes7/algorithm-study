import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'W') {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        // 8,1 9,2 10,3
        for (int i = 0; i < n-7; i++) {
            for (int j = 0; j < m-7; j++) {
                count(graph, new int[]{i, j});
            }
        }

        System.out.println(answer);
    }

    public static void count(int[][] graph, int[] start) {
        int res = 0;
        int res2 = 0;

        for (int i = start[0]; i < start[0]+8; i++) {
            for (int j = start[1]; j < start[1]+8; j++) {
                if (i % 2 == 0 && j % 2 != graph[i][j]) { // 0, 1, 0 이 아니라면
                    res++;
                }
                if (i % 2 == 1 && j % 2 == graph[i][j]) { // 0, 1, 0 이라면
                    res++;
                }

                if (i % 2 == 0 && j % 2 == graph[i][j]) { // 0, 1, 0 이 아니라면
                    res2++;
                }
                if (i % 2 == 1 && j % 2 != graph[i][j]) { // 0, 1, 0 이라면
                    res2++;
                }
            }
        }

        answer = Math.min(res, answer);
        answer = Math.min(res2, answer);
    }
}

/*


 */