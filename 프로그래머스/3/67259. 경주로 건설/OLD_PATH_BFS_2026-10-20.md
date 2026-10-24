# 경주로 건설 — 이전 풀이(경로 연결 리스트 기반) 보존

- 기록일: 2026-10-20
- 다음 버전: [3차원 DP + 큐 기반 재탐색](./경주로 건설.java) (2026-10-24)
- 이전 풀이 코드와 주석을 **저장소에 있던 내용 그대로** 보존함. 문제점은 [이전 피드백](./FEEDBACK_2026-10-20.md) 참고.

~~~java
import java.util.*;

class Solution {
    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};
    private int[][] score;

    private static class Path {
        public int cost;
        public int[] road;
        public Path beforePath = null;

        public Path(int[] start) {
            cost = 0;
            road = start;
        }

        // 깊은 복사
        public Path(Path path) {
            cost = path.cost;
            beforePath = path;
            road = new int[2];
        }

        public int getX() {
            return road[0];
        }

        public int getY() {
            return road[1];
        }

        public int getCost() {
            return cost;
        }

        public boolean contain(int x, int y) {
            int a = road[0];
            int b = road[1];
            Path currP = this;

            while (currP != null) {
                a = currP.road[0];
                b = currP.road[1];
                if (a == x && b == y) {
                    return true;
                }
                currP = currP.beforePath;
            }

            return false;
        }

        public void addRoad(int[] road) {
            this.road = road;
        }

        public void addCost() {
            cost += 100;

            Path currP = this;
            int depth = 0;
            while (currP.beforePath != null && depth < 2) {
                currP = currP.beforePath;
                depth++;
            }
            if (depth != 2) {
                return;
            }

            int currX = getX();
            int currY = getY();
            int x = currP.road[0];
            int y = currP.road[1];

            if (x != currX && y != currY) {
                cost += 500;
            }
        }
    }

    public int solution(int[][] board) {
        score = new int[board.length][board[0].length];
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                score[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Path> queue = new ArrayDeque<>();
        queue.offer(new Path(new int[]{0, 0}));

        while (!queue.isEmpty()) {
            Path path = queue.poll();
            int x = path.getX();
            int y = path.getY();

            if (x == board.length - 1 && y == board[0].length - 1) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0
                    || nx > board.length - 1 || ny > board[0].length - 1) continue;
                if (board[nx][ny] == 1) continue;

                if (!path.contain(nx, ny)) {
                    Path newPath = new Path(path);
                    newPath.addRoad(new int[]{nx, ny});
                    newPath.addCost();
                    if (newPath.cost - 500 <= score[nx][ny]) { // >가 아니라 >= 같은 코스트 중에 그 이전에 회전 안 한 더 우월한 게 있을 수도 있으니 // 또한 이전 방향 고려했을 때 500만큼 오차는 넣어줘야 함
                        score[nx][ny] = Math.min(score[nx][ny], newPath.cost);
                        queue.offer(newPath);
                    }
                }
            }
        }

        return score[score.length - 1][score[0].length - 1];
    }
}

/*
07:45~08:18 33분 메모리 초과 52점
메모리 초과된 원인?
애초에 해결법?
메모리 초과는 무슨 기준이지?

최대한 코너를 덜 만들어야 함
bfs 괜찮을 것 같은데
크기가 크지도 않고

그런데 특정 골목을 공통적으로 지나가는 경로가 있을 것
각 bfs 원소마다 지나온 길들을 따로 기억하기

0929~0945 16분 메모리 초과 52점
roads를 복사하는 게 아니라. 참조만 해도 되잖아.
연결리스트!!

0945~1000 15분 96점 1개 틀림
근본적인 문제를 해결해야 하나보다
유망하지 않은 큐 원소는 삭제하는 법?
dp로 가는 건 어때
경로가 필요한 게 아니라 최솟값만 필요하잖아 !!

1개 틀린 건 뭐지.... 힌트 좀

일단 힌트 받아서 풀이 완료 !
*/
~~~
