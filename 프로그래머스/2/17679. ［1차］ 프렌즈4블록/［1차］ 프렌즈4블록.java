import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // board를 2차원 배열로 변환
        char[][] boardArr = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] temp = board[i].toCharArray();
            
            for (int j = 0; j < n; j++) {
                boardArr[i][j] = temp[j];
            }
        }
        
        // 게임 시작
        boolean isGameActive = true;
        int removedBlocks = 0;
        while (isGameActive) {
            int beforeRemovedBlocks = removedBlocks;
            boolean[][] fourBlocks = new boolean[m][n];
                
            // 4블록인지 check
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isFourBlock(boardArr, i, j)) {
                        fourBlocks[i][j] = true;
                        fourBlocks[i + 1][j] = true;
                        fourBlocks[i][j + 1] = true;
                        fourBlocks[i + 1][j + 1] = true;
                    }
                }
            }
            
            // 블록 지우기 & 떨어뜨리기
            for (int i = 0; i < n; i++) { // 열
                Deque<Character> dq = new ArrayDeque<>();
                
                for (int j = 0; j < m; j++) { // 행
                    if (!fourBlocks[j][i]) {
                        dq.offer(boardArr[j][i]);
                    }
                }
                
                // 순차적으로 떨어뜨리기
                int index = m - 1;
                while (!dq.isEmpty()) {
                    boardArr[index][i] = dq.pollLast();
                    index--;
                }
                
                // 위에 빈 블록 X로 표현
                for (int k = index; k >= 0; k--) {
                    boardArr[k][i] = 'X';
                    removedBlocks++;
                }
            }
            
            // System.out.println(Arrays.deepToString(boardArr));
            // break; // 임시!!!
            
            isGameActive = (beforeRemovedBlocks != removedBlocks);
        }
        
        return removedBlocks;
    }
    
    public static boolean isFourBlock(char[][] boardArr, int x, int y) {
        if (boardArr[x][y] == 'X') {
            return false;
        }
        
        if ((boardArr[x][y] == boardArr[x + 1][y]) 
            && (boardArr[x][y + 1] == boardArr[x + 1][y + 1])) {
            if (boardArr[x][y] == boardArr[x + 1][y + 1]) {
                return true;
            }
        }
        
        return false;
    }
}

/*
board 방향이 주어지진 않았는데, 상관 없음. 위이든 아래이든 블록 지워지는 건 같은 메커니즘

한 번의 시행 (12분)
    2 x 2 형태로 붙어있는 블록 완탐 
        2 x 2 단위로 check
        boolean[][]에 지울 블록 각 좌표를 true로
    boolean[][]에서 true인 블록 지우기 & 떨어뜨리기 -> 열이 같은 것 기준으로 아래 행부터 위 행까지 순회
        true가 나타난다면 스택 몇 개 쌓였는지 체크
            false 나타나면 
                해당 개수만큼 다시 할당
                빈 자리 true로 처리 
                스택 디폴트 값 변경
                // 이렇게 하면 복잡 -> 그냥 읽으면서 큐에 넣기

블록 떨어뜨리는 부분을 잘 신경 써야 함. 

블록을 지웠다면 어떻게 떨어뜨리지?
열이 같은 것 기준으로 순회하면서 떨어뜨리면 됨. 
*/