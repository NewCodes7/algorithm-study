import java.util.*;

class Solution {
    private static int m;
    private static int n;

    
    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        
        // board를 2차원 배열로 변환
        char[][] gameBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] temp = board[i].toCharArray();
            
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = temp[j];
            }
        }
        
        boolean isGameActive = true;
        int totalRemovedBlocks = 0;
        while (isGameActive) {
            // 같은 모양의 블록인지 check
            boolean[][] blocksToDelete = checkToDeleteBlocks(gameBoard);
            
            // 블록 지우기 & 떨어뜨리기
            int beforeRemovedBlocks = totalRemovedBlocks;
            totalRemovedBlocks += removeBlocks(blocksToDelete, gameBoard);
            
            // 삭제된 블록이 없다면 게임 종료하기 위함
            isGameActive = (beforeRemovedBlocks != totalRemovedBlocks);
        }
        
        return totalRemovedBlocks;
    }
    
    public static boolean[][] checkToDeleteBlocks(char[][] gameBoard) {
        boolean[][] blocksToDelete = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (isSameBlock(gameBoard, i, j)) {
                    blocksToDelete[i][j] = true;
                    blocksToDelete[i + 1][j] = true;
                    blocksToDelete[i][j + 1] = true;
                    blocksToDelete[i + 1][j + 1] = true;
                }
            }
        }
        
        return blocksToDelete;
    }
    
    public static boolean isSameBlock(char[][] gameBoard, int x, int y) {
        if (gameBoard[x][y] == 'X') { // 빈 블록인지 확인
            return false;
        }
        
        if ((gameBoard[x][y] == gameBoard[x + 1][y]) 
            && (gameBoard[x][y + 1] == gameBoard[x + 1][y + 1])
            && gameBoard[x][y] == gameBoard[x + 1][y + 1]) {
            return true;
        }
        
        return false;
    }
    
    public static int removeBlocks(boolean[][] blocksToDelete, char[][] gameBoard) {
        int removedBlocks = 0;
        
        for (int i = 0; i < n; i++) { // 열
            Deque<Character> dq = new ArrayDeque<>(); // 한 열에서 삭제되지 않을 블록 저장

            for (int j = 0; j < m; j++) { // 행
                if (!blocksToDelete[j][i]) { 
                    dq.offer(gameBoard[j][i]);
                }
            }

            // 한 열에서 블록들 순차적으로 떨어뜨리기
            int index = m - 1;
            while (!dq.isEmpty()) {
                gameBoard[index][i] = dq.pollLast();
                index--;
            }

            // 한 열에서 위에 빈 블록 X로 표현
            for (int k = index; k >= 0; k--) {
                gameBoard[k][i] = 'X'; // 빈 블록을 X로 표현
                removedBlocks++;
            }
        }
        
        return removedBlocks;
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

45분, 1번 제출, 다시 X

피드백
1. 초반에 설계 잘했다. 12분 정도.
2. 중간에 설계 잘못 한 부분 (블록 떨어뜨리기) 침착하게 잘 수정했다!
3. 주석으로 잘 구분했다!


*/