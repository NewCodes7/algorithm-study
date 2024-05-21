import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[][] apples;
    private static Map<Integer, String> shifts = new HashMap<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int shift = 1; // 오른쪽 (왼쪽 -> 3)
    // 아래 오른쪽 위 왼
    private static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        apples = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            apples[x][y] = 2; // 사과
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String shift = st.nextToken();

            shifts.put(second, shift);
        }

//        System.out.println(Arrays.deepToString(map));
//        System.out.println(shifts);

        map[1][1] = 1;
        snake.add(new int[] {1, 1});

        int currentTime = 0;
        boolean isGoing = true;
        while (isGoing) {
            currentTime++;
            isGoing = move(currentTime);
        }

        System.out.println(currentTime);

    }

    public static boolean move(int currentTime) {
        int[] head = snake.getFirst();
        int[] nextHead = new int[] {head[0] + dx[shift], head[1] + dy[shift]};

        // 뱀의 몸에 닿았거나, 벽에 닿았는지 확인
        if (isSafe(nextHead)) {
            snake.addFirst(nextHead);
            map[nextHead[0]][nextHead[1]] = 1;
        } else {
            return false;
        }

        // 사과 확인
        if (apples[nextHead[0]][nextHead[1]] == 2) {
            apples[nextHead[0]][nextHead[1]] = 0;
        } else {
            int[] tail = snake.getLast();
            map[tail[0]][tail[1]] = 0;
            snake.removeLast();
        }

        // 방향 전환 확인
        if (shifts.containsKey(currentTime)) {
            if (shifts.get(currentTime).equals("L")) {
                shift++;
                if (shift == 4) {
                    shift = 0;
                }
            } else {
                shift--;
                if (shift == -1) {
                    shift = 3;
                }
            }
        }

        return true;
    }

    public static boolean isSafe(int[] nextHead) {
        // 맵에서 벗어났는지 확인
        if (nextHead[0] < 1 || nextHead[0] > map[0].length - 1 || nextHead[1] < 1 || nextHead[1] > map[0].length - 1) {
            return false;
        }

        // 뱀의 몸인지 확인
        if (map[nextHead[0]][nextHead[1]] == 1) {
            return false;
        }

        return true;
    }
}

/*
문제 조건
1. 게임 시작 시 뱀 몸의 길이 1, 맨 위 맨 왼쪽(1, 1), 오른쪽
2. 매 초 머리를 늘려 이동, 방향 전환(왼쪽 L, 오른쪽 D)도 존재
3. 사과 유무에 따라 꼬리 유지 or 삭제
4. 벽이나 몸에 부딪히면 게임 끝

1초마다 이동하는 함수 구현하기
    뱀의 머리 방향에 따라 움직이기 & time++
    벽이나 몸에 부딪혔는지 확인하기
        부딪혔다면 게임 끝
        아니라면 고고
    사과가 있다면 뱀 꼬리 유지, 없다면 자르기
    방향 전환해야하는지 체크

time 플러스한 뒤 이동 체크해야겠지?
2차원 배열 위에서 사과, 뱀의 위치, 방향 전환 표현하기
0 - 아무것도 없음
1 - 뱀
2 - 사과

0 - 아무것도 없음
1 - 왼쪽
2 - 오른쪽
한 배열에 표현하는 게 효과적일까?
    왼쪽이면서 사과라면? -> 방향 정보는 따로 해두는 게 나을 듯. -> 배열, 큐가 아닌 맵으로!!

뱀을 덱으로 구현해도 되긴 하겠다!

추가 변수 -> 뱀의 머리 방향, 뱀의 머리와 꼬리 좌표

덱으로 가자!!
 */