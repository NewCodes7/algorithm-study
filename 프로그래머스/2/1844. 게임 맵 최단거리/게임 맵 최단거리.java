import java.util.*;

public class Solution {
    private static class Node {
        public final int x;
        public final int y;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {1, 0, -1, 0}; //이런 건 final로 상수 선언하기
    private static final int[] dy = {0, 1, 0, -1};
    
    public static int bfs(int[][] maps, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        maps[x][y] = 2;
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length -1) {
                    continue;
                }
                
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[current.x][current.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            return -1;
        }
        return maps[maps.length - 1][maps[0].length - 1] - 1;
    }
    
    public int solution(int[][] maps) {
        return bfs(maps, 0, 0);
    }
}