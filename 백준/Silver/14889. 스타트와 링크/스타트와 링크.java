import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int answer = Integer.MAX_VALUE;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        back(0, list, 0);

        System.out.println(answer);
    }

    public static void back(int depth, List<Integer> list, int idx) {
        if (depth == n/2 - 1) {
            answer = Math.min(answer, sum(list));
            return;
        }

        for (int i = idx+1; i < n; i++) {
            list.add(i);
            back(depth+1, list, i);
            list.remove(list.size()-1);
        }
    }
    public static int sum(List<Integer> list) {
        int c = 0;
        int c2 = 0;
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.contains(i)) {
                list2.add(i);
            }
        }

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                c += graph[list.get(i)][list.get(j)] + graph[list.get(j)][list.get(i)];
            }
        }
        for (int i = 0; i < list2.size()-1; i++) {
            for (int j = i+1; j < list2.size(); j++) {
                c2 += graph[list2.get(i)][list2.get(j)] + graph[list2.get(j)][list2.get(i)];
            }
        }

        return Math.abs(c - c2);
    }


}

/*
총합 더해두기
조합! - N명 중에서 N/2명 뽑기
더하기!

순열 - visited, 종료조건 r개수

4 -> 4c2 6 -> 3 3c2
6 -> 6c3 20 -> 10 5c2

머리가 안 돌아ㅏㄱ.
 */