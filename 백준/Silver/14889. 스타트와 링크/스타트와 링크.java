import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] arr;
    private static int[] pair;
    private static int[] pair2;
    private static boolean[] chk;

    private static List<Integer> score = new ArrayList<>();

    public static void back(int idx, int i) {
        if (idx == N/2) {
            int startTeam = 0;
            int linkTeam = 0;

            List<Integer> list = new ArrayList<>();
            for (int h = 0; h < N; h++) {
                if (!chk[h]) {
                    list.add(h);
                }
            }
            pair2 = list.stream().mapToInt(Integer::intValue).toArray();

            for (int k = 0; k < N/2; k++) {
                for (int j = 0; j < N/2; j++) {
                    startTeam += arr[pair[k]][pair[j]] + arr[pair[j]][pair[k]];
                    linkTeam += arr[pair2[k]][pair2[j]] + arr[pair2[j]][pair2[k]];
                }
            }
            score.add(Math.abs(startTeam - linkTeam));
            return;
        }

        for (i = i; i < N; i++) { // 이대로 더해버리면 중복됨. 선수 경우의 수만 고른다 생각해야 함.
            // swap을 한다면? 애초에 설계를 잘 못함. ㄴㄴ 경우의 수 더많아짐.
            chk[i] = true;
            pair[idx] = i;
            back(idx + 1, i + 1);
            chk[i] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        pair = new int[N/2];
        pair2 = new int[N/2];
        chk = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0);
        
        System.out.println(Collections.min(score) / 2);

        // 입력 읽기
        // n개의 배열로 뭉쳐도 됨. ㄴㄴ 1, 3, 6 세 명이 같은 팀이면 3개의 값 필요. 4명이면 6개의 값
        // 1, 2, 99, 100 일단 ㄱ
    }
}