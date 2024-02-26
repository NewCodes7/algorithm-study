import java.util.*;

class Solution {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = makeMap(rectangle);

        answer = bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    public static int[][] makeMap(int[][] rectangle) {
        int[][] map = new int[101][101]; // 102가 아니라 101 
        
        // 좌표 2배 처리
        for (int[] c : rectangle) {
            c[0] *= 2;
            c[1] *= 2;
            c[2] *= 2;
            c[3] *= 2;
        }
        
        // 선분 및 꼭짓점 1 처리
        for (int[] c : rectangle) {
            
            // 가로
            for (int i = c[0]; i <= c[2]; i++) {
                map[i][c[1]] = 1;
                map[i][c[3]] = 1;
            }
            
            // 세로
            for (int i = c[1]+1; i < c[3]; i++) {
                map[c[0]][i] = 1;
                map[c[2]][i] = 1;
            }
        }
        
        // 내부 0 처리
        for (int[] c : rectangle) {
            for (int i = c[0]+1; i < c[2]; i++) {
                for (int j = c[1]+1; j < c[3]; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        return map;
    }
    
    public static int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterX, characterY});
        
        while (!q.isEmpty()) {
            int[] c = q.poll(); // 아 반복문 밖에 있어야지!! 매너리즘
            
            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];

                if (nx < 2 || nx > 100 || ny < 2 || ny > 100) continue; // 101의 두배인 202라 해버림..  0이 아니라 1임.. 이거 조심하자. 실수하기 쉽겠다. 

                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[c[0]][c[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return (map[itemX][itemY]-1)/2;
    }
}

/*
9:41~ 10:08

경로 표시하기
int - 1 길 / 0 막힘
직사각형 꼭짓점. 
직사각형 내부는 0으로
직사각형 선분 및 꼭짓점은 1로

한 번이라도 0 할당되면 영원히 1

1 처리 싹 진행한다음, 내부 0처리는 마지막에. 따로.

지도 크기 51

전처리
    1 처리
    0 처리

bfs 최단 경로
    최단 거리는 지도에 저장하면 됨.
    1일 때만 진행
    


*/