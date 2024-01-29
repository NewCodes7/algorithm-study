import java.io.*;
import java.util.*;

public class Main {
    private static String answer = "NO"; // 스태틱?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] maps = new int[n][n];
        List<int[]> teachers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String c = st.nextToken();
                int converted = 0; // 0: 빈 곳
                if (c.equals("S")) converted = 1; // 1: 학생
                if (c.equals("T")) {
                    converted = 2; // 2: 선생님
                    teachers.add(new int[] {i, j});
                }
                maps[i][j] = converted;
            }
        }

        dfs(maps, 0, 0, 0, teachers); // 뎁스 0이어야 하는 이유

        System.out.println(answer);

    }

    public static void dfs(int[][] maps, int x, int y, int depth, List<int[]> teachers) {
        if (depth == 3) {
            if (isSafe(maps, teachers)) {
                answer = "YES"; // 바로 종료하는 법?
//                System.out.println(Arrays.deepToString(maps));
            }
            return;
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps.length; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 3;
                    dfs(maps, i, j, depth + 1, teachers);
                    maps[i][j] = 0;
                }
            }
        }
    }

    public static boolean isSafe(int[][] maps, List<int[]> teachers) {
        for (int i = 0; i < teachers.size(); i++) {
            int[] teacher = teachers.get(i);

            List<Integer> filteredX = getFilteredArr(maps, teacher, true);
            List<Integer> filteredY = getFilteredArr(maps, teacher, false);

            for (int j = 0; j < filteredX.size(); j++) {
                if (j != 0) {
                    if (filteredX.get(j) == 1 && filteredX.get(j-1) == 2) {
                        return false;
                    }
                }
                if (j != filteredX.size() - 1) {
                    if (filteredX.get(j) == 1 && filteredX.get(j+1) == 2) {
                        return false;
                    }
                }
            }

            for (int j = 0; j < filteredY.size(); j++) {
                if (j != 0) {
                    if (filteredY.get(j) == 1 && filteredY.get(j-1) == 2) {
                        return false;
                    }
                }
                if (j != filteredY.size() - 1) {
                    if (filteredY.get(j) == 1 && filteredY.get(j+1) == 2) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static List<Integer> getFilteredArr(int[][] maps, int[] teacher, boolean a) {
        List<Integer> filtered = new ArrayList<>();
        if (a) {
            for (int j = 0; j < maps.length; j ++) {
                if (maps[teacher[0]][j] != 0) {
                    filtered.add(maps[teacher[0]][j]);
                }
            }
        } else {
            for (int j = 0; j < maps.length; j ++) {
                if (maps[j][teacher[1]] != 0) {
                    filtered.add(maps[j][teacher[1]]);
                }
            }
        }

        return filtered;
    }
}