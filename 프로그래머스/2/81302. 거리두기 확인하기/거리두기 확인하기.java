import java.util.*;

class Solution {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = 1;
        }
        
        int index = 0;
        for (String[] place : places) {
            char[][] room = convert(place);
            // System.out.println(Arrays.deepToString(room));
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (room[i][j] == 'P') {
                        visited = new boolean[5][5];
                        if (bfs(room, i, j) == 0) {
                            answer[index] = 0;
                        };
                    }
                }
            }

            index++;
        }
        
        return answer;
    }
    
    public static char[][] convert(String[] arr) {
        char[][] room = new char[5][5];
        
        for (int i = 0; i < 5; i++) {
            char[] temp = arr[i].toCharArray();
            
            for (int j = 0; j < 5; j++) {
                room[i][j] = temp[j];
            }
        }
        
        return room;
    }
    
    public static int bfs(char[][] room, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0}); // 좌표, 거리
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                
                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (room[nx][ny] == 'P') {
                    return 0;
                } else if (room[nx][ny] == 'X') {
                    continue;
                }
                
                if (c[2] < 1) { // 2가 아니라 1까지만!!!!
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, c[2] + 1}); // ++로 하면 안 되려나?
                }
                
            }
        }
        
        return 1;
    }
}

/*
똑같은 과정을 5번 반복하면 됨.

2차원 배열로 만든 후, 완탐하면 되겠는데?

bfs로 가능할 듯. visited 

2차원 배열 완탐
    P라면 bfs 시작
        X가 나오면 그만.
        거리가 2 초과라면 그만.

*/