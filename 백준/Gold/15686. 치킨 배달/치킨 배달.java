import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int minCityD = (int) (1e9);
    private static int n, m;
    private static List<int[]> chicken = new ArrayList<>();
    private static List<int[]> selectedChicken = new ArrayList<>();
    private static List<int[]> house = new ArrayList<>();

    public static void getChicken(int idx, int i) {
        if (idx == m) {
            getDistance();
            return;
        }

        for (i = i; i < chicken.size(); i++) {
            selectedChicken.add(chicken.get(i));
            getChicken(idx + 1, i + 1);
            selectedChicken.remove(selectedChicken.size() - 1);
        }
    }

    public static void getDistance() {
        int totalD = 0;
        for (int[] h : house) {
            int chickenD = (int) (1e9);
            for (int[] c : selectedChicken) {
                chickenD = Math.min(chickenD, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
            }
            totalD += chickenD;
        }
        minCityD = Math.min(minCityD, totalD);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 2) chicken.add(new int[] {i, j});
                if (c == 1) house.add(new int[] {i, j});
            }
        }

        getChicken(0, 0);

        System.out.println(minCityD);
    }
}
