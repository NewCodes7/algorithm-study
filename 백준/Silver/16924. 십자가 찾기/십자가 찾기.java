import java.io.*;
import java.util.*;

public class Main {
    private static int[] d = {1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String c= br.readLine();
            for (int j = 0; j < m; j++) {
                if (c.charAt(j) == '.') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
//                graph[i][j] = Integer.parseInt(String.valueOf(c.charAt(j))); // 메서드 숙지
            }
        }

        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0) {
                    int cnt = 0;
                    int[] points = new int[4];
                    points[0] = i + d[0];
                    points[1] = i + d[1];
                    points[2] = j + d[2];
                    points[3] = j + d[3];

                    outerloop:
                    while (true) {
                        if (points[0] < 0 || points[0] > n-1) break outerloop;
                        if (points[1] < 0 || points[1] > n-1) break outerloop;
                        if (points[2] < 0 || points[2] > m-1) break outerloop;
                        if (points[3] < 0 || points[3] > m-1) break outerloop;

                        if (graph[points[0]][j] == 0) break outerloop;
                        if (graph[points[1]][j] == 0) break outerloop;
                        if (graph[i][points[2]] == 0) break outerloop;
                        if (graph[i][points[3]] == 0) break outerloop;

                        graph[points[0]][j] = 2;
                        graph[points[1]][j] = 2;
                        graph[i][points[2]] = 2;
                        graph[i][points[3]] = 2;

                        cnt++;
                        for (int k = 0; k < 4; k++) {
                            graph[i][j] = 2;

                            points[k] += d[k];
                        }
                    }

                    if (cnt != 0) {
                        answer++;
                        sb.append((i+1) + " " + (j+1) + " " + cnt + "\n");
                    }
                }
            }
        }

        boolean isGood = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) isGood = false;
            }
        }

        if (isGood) {
            System.out.println(answer);
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }


    }
}

/*
완전탐색으로 해결가능



반복문 - 1혹은 2라면 상하좌우로 0이 되기 전까지 탐색 후 2로 변경
    되는 것 2로 바꾸기 // 0그냥 1별 2처리

반복문 - 1이 있는지 체크
    1이 있다면 -1
    1이 없다면 저장해둔 정답 출력

출력할 땐 +1씩

 */