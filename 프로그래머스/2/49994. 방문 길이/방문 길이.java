class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][] map = new boolean[21][21];
        int nx = 10;
        int ny = 10;
        
        for (char c : dirs.toCharArray()) {
            int dx = nx;
            int dy = ny;
            if (c == 'U' && ny < 20) {
                dy += 2;
            } else if (c == 'D' && ny > 0) {
                dy -= 2;
            } else if (c == 'L' && nx > 0) {
                dx -= 2;
            } else if (c == 'R' && nx < 20) {
                dx += 2;
            }
            
            int midx = (nx + dx) / 2;
            int midy = (ny + dy) / 2;
            
            if (nx == dx && ny == dy) {
                continue;
            }
            
            if (!map[midx][midy]) {
                map[midx][midy] = true;
                answer++;
                //System.out.println("midx: " + midx + " midy: " + midy);
            }
            
            nx = dx;
            ny = dy;
            
            //System.out.println("x: " + nx + " y: " + ny);
        }
        
        return answer;
    }
}

/*
11:54~

처음 걸어본 길이 
길목에 대해 체크를 해야 함
11x11 -> 21x21

0 ~ 20 

첫 좌표는 10, 10 



*/