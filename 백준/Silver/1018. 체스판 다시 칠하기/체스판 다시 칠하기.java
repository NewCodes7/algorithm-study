import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine(), ""); // 구분자 이렇게 하면 안 되나?
            String c = br.readLine();
            for (int j = 0; j < m; j++) {
                if (c.charAt(j) == 'W') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }

        int w = getCount(checkBoard(board, 0)); // 보드 계속 연속해서 사용할 수 없음 주소 같아서.
        int b = getCount(checkBoard(board, 1));
        System.out.println(Math.min(w, b));
    }

    public static int[][] checkBoard(int[][] board, int color) { // 구현은 문제를 잘 읽는 게 정말 중요...
        int unit = color;
        int[][] chess = new int[board.length][board[0].length]; // 새로 생성.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (j % 2 == 0 && board[i][j] != unit) {
                    chess[i][j] = 2;
                }
                if (j % 2 == 1 && board[i][j] == unit) {
                    chess[i][j] = 2;
                }
            }

            unit = color;
            if (i % 2 == 0) {
                unit++;
                if (unit == 2) {
                    unit = 0;
                }
            }
        }
        return chess;
    }

    public static int getCount(int[][] chess) {
        int min = (int) 1e9;
        for (int i = 8; i <= chess.length; i++) {
            for (int j = 8; j <= chess[0].length; j++) {
                min = Math.min(min, getCount2(chess, i, j));
            }
        }
        return min;
    }

    public static int getCount2(int[][] chess, int n, int m) {
        int count = 0;
        for (int i = n - 8; i < n; i++) { // i = 0이라 해버림..
            for (int j = m - 8; j < m; j++) {
                if (chess[i][j] == 2) count++;
            }
        }
        return count;
    }
}