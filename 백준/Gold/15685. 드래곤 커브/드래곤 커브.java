import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {1, 0, -1, 0}; // 조정
    private static final int[] dy = {0, -1, 0, 1};
    private static int[][] totalMap = new int[101][101]; // 101!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 정보 받기
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            List<List<Integer>> map = new ArrayList<>();
            for (int j = 0; j < 101; j++) {
                map.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            map.get(x).add(y);
            int[] point = new int[] {x + dx[d], y + dy[d]};
            map.get(point[0]).add(point[1]);
            totalMap[x][y] = 1;
            totalMap[point[0]][point[1]] = 1;

            for(int k = 0; k < g; k++) {
                makeCurve(map, point, x, y); // 해야 되나?, 끝점 업데이트
            }
        }

        int answer = 0;
        for(int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (totalMap[i][j] == 1 && totalMap[i+1][j] == 1 && totalMap[i][j+1] == 1 && totalMap[i+1][j+1] == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        // 합산
    }

    public static int[] makeCurve(List<List<Integer>> map, int[] point, int startX, int startY) {
        int diffX = point[0] + point[1];
        int diffY = point[1] - point[0];

        List<int[]> curve = new ArrayList<>();
        // map 자체를 바꾸기. 인접 리스트. 각 좌표마다 바꿔서 삽입
        for (int x = 0; x < map.size(); x++) {
            for (int j = 0; j < map.get(x).size(); j++) {
                int y = map.get(x).get(j);
                int newX = -y + diffX;
                int newY = x + diffY;
                totalMap[newX][newY] = 1;
                curve.add(new int[] {newX, newY});
            }
        }

        for (int[] c : curve) {
            map.get(c[0]).add(c[1]);
        }

        // 다음 끝점 = 이동한 시작점
        point[0] = -startY + diffX;
        point[1] = startX + diffY;

        return point;
    }
}
// map 단위로 실행하다가 완료되면 옮기기
// 설계 24분