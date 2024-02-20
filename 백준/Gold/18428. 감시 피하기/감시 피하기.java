import java.io.*;
import java.util.*;

public class Main {
    private static String answer = "NO";
    private static boolean solutionFound = false;

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

        back(maps, 0, 0, 0, teachers); 

        System.out.println(answer);
    }

    public static void back(int[][] maps, int x, int y, int depth, List<int[]> teachers) {
        if (depth == 3) {
            if (isSafe(maps, teachers)) {
                answer = "YES";
                solutionFound = true; // 바로 종료
            }
            return;
        }

        for (int i = 0; i < maps.length && !solutionFound; i++) {
            for (int j = 0; j < maps.length && !solutionFound; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 3;
                    back(maps, i, j, depth + 1, teachers);
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

            if (!safe(filteredX)) {
                return false;
            }
            if (!safe(filteredY)) {
                return false;
            }
        }

        return true;
    }

    public static boolean safe(List<Integer> filtered) {
        for (int j = 0; j < filtered.size(); j++) {
            if (j != 0) {
                if (filtered.get(j) == 1 && filtered.get(j-1) == 2) {
                    return false;
                }
            }
            if (j != filtered.size() - 1) {
                if (filtered.get(j) == 1 && filtered.get(j+1) == 2) {
                    return false;
                }
            }
        }

        return true;
    }

    public static List<Integer> getFilteredArr(int[][] maps, int[] teacher, boolean isX) {
        List<Integer> filtered = new ArrayList<>();
        if (isX) {
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