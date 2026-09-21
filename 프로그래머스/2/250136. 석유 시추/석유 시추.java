import java.util.*;

class Solution {

    private int[] result;
    private boolean[][] visited;

    public int solution(int[][] land) {
        int answer = 0;

        // bfs로 덩어리들 합산하기
        int x = land.length;
        int y = land[0].length;
        result = new int[y];
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(land, i, j);
                }
            }
        }

        // 덩어리들 중 max 고르기
        answer = Arrays.stream(result).max().getAsInt();
        // System.out.println(Arrays.toString(result));

        return answer;
    }

    private void bfs(int[][] land, int startX, int startY) {
        int limitX = land.length;
        int limitY = land[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY});
        boolean[] mark = new boolean[land[0].length];
        int sum = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if (visited[x][y]) continue; // 이거 안 했어서 디버깅 좀 했음
            visited[x][y] = true;
            if (land[x][y] == 1) {
                // System.out.println(x + " " + y);
                mark[y] = true;
                sum++;
            } else {
                continue;
            }

            if ((x >= 0 && x < limitX && y + 1 >= 0 && y + 1 < limitY) && !visited[x][y + 1]) {
                q.offer(new int[] {x, y + 1});
            }
            if ((x + 1 >= 0 && x + 1 < limitX && y >= 0 && y < limitY) && !visited[x + 1][y]) {
                q.offer(new int[] {x + 1, y});
            }
            if ((x >= 0 && x < limitX && y - 1 >= 0 && y - 1 < limitY) && !visited[x][y - 1]) {
                q.offer(new int[] {x, y - 1});
            }
            if ((x - 1 >= 0 && x - 1 < limitX && y >= 0 && y < limitY) && !visited[x - 1][y]) {
                q.offer(new int[] {x - 1, y});
            }
        }

        for (int i = 0; i < mark.length; i++) {
            if (mark[i]) {
                result[i] += sum;
            }
        }
        // System.out.println(Arrays.toString(result));
    }
}

/*
17:21~17:59 38m

bfs로 덩어리들 모두 탐색
각 덩어리마다 누적해서 더하기

bfs 모든 좌표들에 대해서 하되
방문한 곳 따로 체크하기

피드백
1. 배열 최댓값 구하기: Arrays.stream(arr).max().getAsInt()
2. 시간복잡도 어떻게 되지? N*M*N*M?
3. bfs 깔끔하게 코드 작성한 거 맞나?
4. bfs에서 visited 원래 큐에서 꺼냈을 때 바로 visited 체크하고, false면 true로 주나?
5. 좀만 더 설계하고 들어갔으면 좋았겠다. 더 디테일하게 로직. 큰 아이디어만 생각하지 말고.
*/
