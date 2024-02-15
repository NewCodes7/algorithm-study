import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        boolean[][] paper  = new boolean[100][100];
        int area = 0;

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    if (!paper[j][k]) {
                        paper[j][k] = true;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}

// 틀렸을 떄 대처법: 기능 요구사항 점검, 예외사항 점채
// 모두 겹쳐있는 경우 100이  나와야 하지만 0이 나옴.
// 세 개 이상의 색종이가 겹칠 때 !!
// 설계할 떄 예외 사항도 고려하

// 애초에 문제풀이 전략이 잘못됐었네. 너무 어려운 길로 들어옴.
// 예외 사항까지 포함하려면 다시 코드를 짜야 함.
// 좌표평면 상을 2차원 배열로 표현하여 넓이를 구할 수 있다!