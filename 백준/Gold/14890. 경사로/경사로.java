import java.io.*;
import java.util.*;

public class Main {
    private static int n, l, cnt = 0;
    private static double[][] graph;
    private static double[][] graph2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        graph = new double[n][n];
        graph2 = new double[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                graph2[i][j] = graph[i][j];
            }
        }

        check();
//        for (int i = 0; i < n; i++) {
//            System.out.print(graph2[i][0] + " ");
//        }
        System.out.println(cnt);
    }

// 경사로를 둔다면 0.5 추가해서 오류 방지
    // 그러나 이전꺼를 업데이트하는 건 영향을 미치지 않음.
    // 이후꺼를 업데이트 하는 건 영향 있음. 이후 후 이전 할 때.

    public static void check() {
        // 줄 하나씩 확인 (가로줄)
        for (int i = 0; i < n; i++) { // 테스트
            double before = graph[i][0];
            double before2 = graph2[0][i];

            version(before, 0, i); // 가로

            // 아.. 가로가 원래 그래프를 방해하는구나..
            version(before2, 1, i); // 세로

        }
    }

    public static void version(double before, int version, int i) {
        oneloop:
        for (int j = 1; j < n; j++) {
            double c;
            if (version == 0) {
                c = graph[i][j];
            } else {
                c = graph2[j][i];
            }

            if (c != before) {
                if (c - before == 0.5 || c - before == 1.5) break oneloop;

                if (c - before == 1) { // 현재가 더 높을 때
                    int last = j-l;
                    if (last < 0) break oneloop;
                    for (int k = j-2; k >= last; k--) { // before의 이전부터 검사 l-1번
                        if (version == 0) {
                            if (before != graph[i][k]) break oneloop;
                        } else {
                            if (before != graph2[k][i]) break oneloop;
                        }
                    }
                }

                if (before - c == 1 || before - c == 1.5) { // 그 전이 더 높을 때
                    int last = j + l - 1;
                    if (last > n-1) break oneloop;
                    for (int k = j+1; k <= last; k++) { // c의 이후부터 검사
                        if (version == 0) {
                            if (c != graph[i][k]) break oneloop;
                        } else {
                            if (c != graph2[k][i]) break oneloop;
                        }
                    }
                    if (version == 0) {
                        for (int k = j; k <= last; k++) { // 경사로 반영
                            graph[i][k] += 0.5;
                        }
                    } else {
                        for (int k = j; k <= last; k++) { // 경사로 반영
                            graph2[k][i] += 0.5;
                        }
                    }

                    j += l-1;
                    if (j >= n) j = n-1; // 값 넘어가서 업데이트 안 되는 것 방지
                }

                if (Math.abs(before - c) >= 2) {
                    break oneloop;
                }
            }

            if (version == 0) {
                before = graph[i][j];
            } else {
                before = graph2[j][i];
            }
//            before = c; // 0.5 업데이트 한 것까지 반영해야해!!!

            if (j == n-1) {
                cnt++; // 여기까지 수행되었다면 줄 인정.
//                System.out.println(i + " " + version);
            }
        }
    }

}

/*
3:24 ~

아 세로에 대한 대비가 부족했다.

반복문 돌기
같은지 확인
    같으면 넘어가고
    다르면 차이가 1인지 확인
        차이가 2 이상이라면 stop
        차이가 1이라면 해당 블럭이 L개 있는지 확인
            있다면 경사로 두고 다시 시작
            없다면 stop

틀을 만들어두고 재설계 진행 주석달면서 자세히 ㄱㄱ 이거 좋다.
 */

