import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1; // 0이 아니라 -1 !!
        int robotX = 0;
        int robotY = 0;

        // 2차원 배열로 변환
        int n = board.length;
        int m = board[0].length();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] arr = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (arr[j] == 'D') {
                    map[i][j] = 1;
                } else if (arr[j] == 'G') {
                    map[i][j] = 2;
                } else if (arr[j] == 'R') {
                    // map[i][j] = 3;
                    robotX = i;
                    robotY = j;
                }
            }
        }

        // 목표위치 도달할 수 없는지 체크
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (map[i][j] == 2) {
        //             if (j == 0 || j == m - 1 || i == 0 || i == n - 1) {
        //                 break;
        //             }
        //             if (map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
        //                 return -1;
        //             }
        //         }
        //     }
        // }
        // 갈 수 없는 경우가 골이 장애물에 둘러쌓여있을 때도 있겠네.
        // -> int answer = -1; // 0이 아니라 -1 !!
        // 애초에 위 체크 없었어도 됨. BFS 어차피 완전탐색하고 while 종료될테니 그 때에도 answer 갱신 없으면 -1 반환하면 되는 구조임

        // BFS
        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>(); // [x, y, count]
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[] {robotX, robotY, 0});
        visited[robotX][robotY] = true; // 이거 처음에 빼먹음
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            if (map[pos[0]][pos[1]] == 2) {
                answer = pos[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pos[0];
                int ny = pos[1];
                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    // 벽 or 장애물인지
                    if ((nx == -1 || nx == n || ny == -1 || ny == m)
                        || map[nx][ny] == 1) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if (!visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, pos[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return answer;
    }
}

/*
1908~1944 36m 테케 4개 실패
~1953 9m 디버깅 성공

G는 덩그러니 놓여져 있으면 안 되고
벽이나 장애물과 이웃해 있어야 함 <- 이걸 먼저 체크하기
-> 벽이랑 이웃한 게 아니라 벽에 있어야 함

2차원 배열로 바꾸기
BFS로 찾으면 될 듯
시간은 널널할 듯 싶음 맵이 100 정도여서.. 시간복잡도는 정확히 계산해봐야 알 듯
이미 방문한 노드 체크하기


벽과 로봇을 따로 마킹할 필요는 없엇음

피드백
1. bfs 처음에 세팅해야 하는 것 - queue, visited, 초기원소삽입, 초기원소방문체크
2. 도달할 수 없는 경우의 수가 생각보다 더 있었음. 예외 상황 제대로 꼼꼼하게, 경우의 수 최대한 꼼꼼하게 생각해보고 들어가자. 무조건 예외는 있을 것이다. 모든 경우를 고려하지 못했을 것이다는 마인드로.

*/
