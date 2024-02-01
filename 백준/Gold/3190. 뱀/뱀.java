import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];
//        List<int[]> apple = new ArrayList<>(); 사과 따로 생성할 필요없었음. 있는지 없는지 확인하는 건 map이 더 편해. 기억해라!!
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, Integer> shifts = new HashMap<>(); // 이건 리스트보다는 맵!
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = -1;
            if (st.nextToken().equals("D")) {
                d = 1;
            }

            shifts.put(s, d);
        }


        // 게임 시작
        Deque<int[]> d = new ArrayDeque<>();
        d.add(new int[] {1, 1});
        int shift = 1;
        int seconds = 0;

        outerLoop:
        while(true) {
            seconds++;
            // 1. 몸길이 늘리기
            int[] c = d.getFirst(); // 머리 꺼내기
            int nx = c[0] + dx[shift];
            int ny = c[1] + dy[shift];
            int[] head = new int[]{nx, ny};
            d.addFirst(head); // 여기서 실수 나왔었나? 머리 넣어두고 벽 검사해여함. 근데 머리 넣어두면 몸통닿았는지 확인 어려움.

            // 2. 부딪혔는지 확인
            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                break;
            }
            d.pollFirst(); // 머리 잠시 빼두기
            for (int[] arr : d) {
                if (arr[0] == nx && arr[1] == ny) {
                    break outerLoop;
//                    break; // 아..! for 문을 break 한거잖아!!!!
                }
            }
            d.addFirst(head); // 원상 복구

            // 3. 사과 체크 (있다면 유지, 없다면 꼬리 삭제)
            if (map[nx][ny] != 1) {
                d.pollLast();
            } else {
                map[nx][ny] = 0; // 사과 먹은 것 체크
            }
            // 여기까지 해서 움직임 1회 종료

            // 4. 방향 체크
            if (shifts.containsKey(seconds)) {
                shift += shifts.get(seconds);
                if (shift == 4)
                    shift = 0;
                if (shift == -1)
                    shift = 3;
            }
        }

        System.out.println(seconds);
    }
}