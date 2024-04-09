import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dx = {0, 0, 1, 1};
    private static int[] dy = {0, 1, 0, 1};
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (isAllSameColor(paper, 0, 0, paper.length)) {
            if (paper[0][0] == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            divide(paper, 0, 0, paper.length / 2);
        }

        System.out.println(white + "\n" + blue);
    }

    public static void divide(int[][] paper, int startX, int startY, int l) {
        for (int i = 0; i < 4; i++) {
            int x = startX + l * dx[i];
            int y = startY + l * dy[i];

            if (!isAllSameColor(paper, x, y, l)) {
                divide(paper, x, y, l / 2);
            } else {
                if (paper[x][y] == 1) {
                    blue++;
                } else {
                    white++;
                }
            }
        }
    }

    public static boolean isAllSameColor(int[][] paper, int x, int y, int l) {
        int flag = paper[x][y];
        for (int p = x; p < x + l; p++) {
            for (int q = y; q < y + l; q++) {
                if (paper[p][q] != flag) {
                    return false;
                }
            }
        }

        return true;
    }
}

/*

 */