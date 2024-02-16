import java.util.*;

class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        List<List<List<Integer>>> game_board_blocks = getEntireBlocks(game_board, 0);
        List<List<List<Integer>>> table_blocks = getEntireBlocks(table, 1);
        
        for (int i = 0; i < table_blocks.size(); i++) {
            List<List<Integer>> block = table_blocks.get(i);
            
            loopOut: 
            for (int j = 0; j < game_board_blocks.size(); j++) {
                for (int h = 0; h < 4; h++) {
                    int cnt = checkSame(block, game_board_blocks.get(j));
                    if (cnt > 0) {
                        answer += cnt;
                        game_board_blocks.remove(j);
                        break loopOut;
                        // 삭제
                    } else {
                        block = getSpinBlock(block);
                    }
                }
            }
        }
        
        return answer;
    }
    
    public static int checkSame(List<List<Integer>> a, List<List<Integer>> b) {
        int cnt = 0;
        
        if (a.size() != b.size() || a.get(0).size() != b.get(0).size()) {
            return 0;
        }
        
        for (int i = 0 ; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if(a.get(i).get(j) != b.get(i).get(j)) {
                    return 0;
                } else {
                    if (a.get(i).get(j) == 1) {
                        cnt++;
                    }
                }
            }
        }
        
        return cnt;
    }
    
    public static List<List<Integer>> getSpinBlock(List<List<Integer>> block) {
        List<List<Integer>> spinBlock = new ArrayList<>();
        for (int i = 0; i < block.get(0).size(); i++) {
            spinBlock.add(new ArrayList<>());
        }
        
        for (int i = 0; i < block.size(); i++) { 
            for (int j = 0; j < block.get(0).size(); j++) {
                int c = block.get(block.size()-1-i).get(j);
                spinBlock.get(j).add(c);
            }
        }
        
        return spinBlock;
    }

    public static List<List<List<Integer>>> getEntireBlocks(int[][] graph, int target) {
        List<List<List<Integer>>> store = new ArrayList<>();
        visited = new boolean[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (!visited[i][j] && graph[i][j] == target) {
                    int[] start = new int[] {i, j};
                    int[][] s = bfs(graph, start, target);
                    if (!isEmpty(s)) {
                        List<List<Integer>> c = getUnitBlock(s);
                        store.add(c);
                    }
                }
            }
        }
        
        return store;
    }
    
    public static int[][] bfs(int[][] graph, int[] start, int target) {
        int[][] block = new int[graph.length][graph.length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        block[start[0]][start[1]] = 1;
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                
                if (nx < 0 || nx > graph.length - 1 || ny < 0 || ny > graph.length - 1) {
                    continue;
                }
                
                if (!visited[nx][ny] && graph[nx][ny] == target) { // 0 커스터마이징
                    block[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
                visited[nx][ny] = true;
            }
        }
        return block;
    }
    
    public static List<List<Integer>> getUnitBlock(int[][] block) {
        List<List<Integer>> unitBlock = new ArrayList<>();
        for (int i = 0; i < block.length; i++) {
            unitBlock.add(new ArrayList<>());
        }
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block.length; j++) {
                unitBlock.get(i).add(block[i][j]);
            }
        }
        
        return removeZero(unitBlock);
    }
    
    public static List<List<Integer>> removeZero(List<List<Integer>> unitBlock) {
        for (int i = 0; i < unitBlock.size(); i++) {
            boolean isAllZero = true;
            for (int j = 0; j < unitBlock.get(0).size(); j++) { // 왜 get(0)을 빠뜨리면 안되지?
                if (unitBlock.get(i).get(j) == 1) {
                    isAllZero = false;
                }
            }
            if (isAllZero) {
                unitBlock.remove(i);
                i--;
            }
        }
        
        for (int i = 0; i < unitBlock.get(0).size(); i++) {
            boolean isAllZero = true;
            for (int j = 0; j < unitBlock.size(); j++) {
                if (unitBlock.get(j).get(i) == 1) {
                    isAllZero = false;
                }
            }
            if (isAllZero) {
                for (int h = 0; h < unitBlock.size(); h++) {
                    unitBlock.get(h).remove(i);
                }
                i--;
            }
        }
        
        return unitBlock;
        
    }
    
    public static boolean isEmpty(int[][] block) {
        for (int[] c : block) {
            for (int d : c) {
                if (d == 1) return false;
            }
        }
        return true;
    }
    
            // 블록 맵 단위화 (연속 0인 줄을 지우기)
    
}
/*
1. 우선 하나의 단위 블록을 인식해야 함. 
2. 그리고 맞는 칸을 찾고, 있으면 넣고 없으면 탈락.
3. 모든 블록 반복.

flow는 간단함. 다시 넣을 수 있는 경우가 없기에.
table bfs -> 블록 배출. -> game board bfs 0인 곳.
회전도 고려. -> 대칭이동으로 구현

딱 맞는지 확인하기 위해서는 
하나의 블록 단위를 더 넓혀야 함.\

가장 최소를 기준으로 평행이동


*/