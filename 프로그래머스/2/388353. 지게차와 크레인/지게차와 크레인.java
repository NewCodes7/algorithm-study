import java.util.*;

class Solution {
    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};

    public int solution(String[] storage, String[] requests) {
        char[][] map = new char[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            char[] arr = storage[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j];
            }
        }

        for (int i = 0; i < requests.length; i++) {
            String request = requests[i];
            if (request.length() == 1) {
                findWithCar(map, request);
                // System.out.println(Arrays.deepToString(map));
            } else if (request.length() == 2) {
                findWithCrain(map, request);
                // System.out.println(Arrays.deepToString(map));
            }
        }

        // 개수 세기
        int answer = map.length * map[0].length;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'x') {
                    answer--;
                }
            }
        }

        return answer;
    }

    public void findWithCar(char[][] map, String request) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != request.charAt(0)) { // str to char -> charAt하면되네 한 글자니까
                    continue;
                }

                if (check(map, i, j)) {
                    map[i][j] = 't';
                    continue;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 't') {
                    map[i][j] = 'x';
                }
            }
        }
    }

    public void findWithCrain(char[][] map, String request) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == request.charAt(0)) {
                    map[i][j] = 'x';
                }
            }
        }
    }

    public boolean check(char[][] map, int x, int y) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            if (currX == 0 || currY == 0
                || currX == map.length - 1 || currY == map[0].length - 1) {
                return true;
            }

            for (int a = 0; a < 4; a++) {
                int newX = currX + dx[a];
                int newY = currY + dy[a];
                if (map[newX][newY] == 'x' && !visited[newX][newY]) {
                    queue.offer(new Integer[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return false;
    }
}

/*
20:47~21:14 27분 10점 (런타임 에러)
예제는 잘 됐는데
런타임 에러 왜 뜨지?
실전이었다면 어떻게 잡아야 하지?

requests 순회
   하나면 지게차 -> 겉만 탐색
       완전탐색하면서 각 컨테이너 주변에 뚫린 게 있는지 확인 (아 이것도 주의해야 할 게 통하는 길이 있어야 함)
       뚫려 있는 건 소문자 x로 구분
   두개면 크레인 -> 완전탐색
순회하면서 x 개수 세기

50*50*100 -> 다 완전탐색한다 해도 시간복잡도 널널함

아 이거 주의해야 할 게 지게차 끌 때 처음ㅇ 끌 때 당시에만 접근이 가능한 것만 건드려야 해.

22:10~22:33 23분 디버깅

결국 차이는 무엇이었는가?
1. 처음에는 check할 때 dfs처럼 함. 그러다보니 실제 답과는 다를 수 있음
   false 하나 찾으면 바로 false 반환하니
   그런데 왜 런타임 에러가 발생했던 거지?
   런타임 에러는 주로 어쩔 때 발생하지?
   방문 표시하지 않고 여러 군데 들려서 너무 많이 호출돼서 그랬었나?
*/
