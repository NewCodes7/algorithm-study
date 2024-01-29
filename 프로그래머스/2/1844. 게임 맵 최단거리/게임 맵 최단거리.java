import java.util.*;

class Node { // 클래스 여기에 선언해도 되나? 어떤 게 바람직?
    private int x;
    private int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}

class Solution {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public static int bfs(int[][] maps, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        maps[x][y] = 2;
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.getX() + dx[i];
                int ny = current.getY() + dy[i];
                
                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length -1) {
                    continue;
                }
                
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[current.getX()][current.getY()] + 1;
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