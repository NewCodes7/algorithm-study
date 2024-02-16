import java.util.*;

class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[] result = new int[5];
    private static boolean[][] visited = new boolean[5][5];
    
    public int[] solution(String[][] places) {
        Arrays.fill(result, 1);
        
        for (int idx = 0; idx < 5; idx++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[idx][i].charAt(j) == 'P') {
                        dfs(places[idx], idx, 0, i, j);
                        visited = new boolean[5][5];
                    }
                }
            }
        }

        return result;
    }
    
    public static void dfs(String[] place, int idx, int depth, int x, int y) {
        // visited[x][y] = true; // 위치? 아 depth 3일 때 오작동 오류
        
        if (depth > 2 || place[x].charAt(y) == 'X') {
            // System.out.println(0);
            return;
        }
        
        visited[x][y] = true;
        
        if (place[x].charAt(y) == 'P' && depth != 0) {
            // System.out.println(idx+1 + " " + x + " "+ y);
            result[idx] = 0;
            return;
        }
        
        depth++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!(nx < 0 || nx > 4 || ny < 0 || ny > 4) && !visited[nx][ny]) {
                dfs(place, idx, depth, nx, ny);
            }
        }
    }
}

/*
가는 경로중에 파티션이 없고 맨해튼 2라면, 검거
바로 상하좌우 붙어있으면, 검거
  *
 ***
*****
 ***
  *
각 플레이어마다 이렇게 범위 생김. (13개)
 *
***
 *
이 단위가 반복됨. 재귀.

반복문 places
    반복문 place - 변수: 현재 depth(거리)
        종료조건: depth > 2, 현재위치 파티션이라면, 
        P가 맞다면 ㄴㄴㄴㄴ 이건 그 전에 확인했음!!!!
            depth 0 아닌 게 확인됐다면, place종료, result 0 추가(boolean)
            (depth++;)
            반복문
                좌표확인
                dfs(상)
                dfs(하)
                dfs(좌)
                dfs(우)
        boolean == true 1추가
        
리팩토링
    0을 더 검출했거나
    덜 검출했거나..
    
    다시 제자리로 돌아올 수 있음.
    방문처리? ㄴㄴ 힘듦.
    
    charAt은 리턴만?
    문자열 특정 위치 바꾸기?
*/