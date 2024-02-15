import java.util.*;

class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[51*2][51*2];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for (int[] r : rectangle) {
            r[0] *= 2;
            r[1] *= 2;
            r[2] *= 2;
            r[3] *= 2;
            for (int i = r[0]; i <= r[2]; i++) { // 가로 처리
                map[i][r[1]] += 1;
                map[i][r[3]] += 1;
            }
            for (int j = r[1] + 1; j < r[3]; j++) { // 세로 처리
                map[r[0]][j] += 1;
                map[r[2]][j] += 1;
            }
            for (int k = r[0]+1; k < r[2]; k++) { // 내부 처리
                for (int l = r[1]+1; l < r[3]; l++) {
                    map[k][l] += 3;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {characterX, characterY, 0}); // 비용까지! 배열말고도 클래스 별도 선언 가능.
        map[characterX][characterY] = 0; // 방문처리

        while(!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0] == itemX && c[1] == itemY) {
                answer = c[2] / 2; 
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                
                if (map[nx][ny] == 1 || map[nx][ny] == 2) {
                    q.offer(new int[] {nx, ny, c[2] + 1});
                    map[nx][ny] = 0;
                }
            }
        }
        
        // 0 : 기본 (지날 수 없는 길) & 방문처리
        // 1 : 지날 수 있는 길
        // 2 : 코너
        // 3이상 : 직사각형 내부
        return answer;
    }
}