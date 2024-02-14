class Solution {
    private static int answer = 0; 
    private static boolean[] visited; 
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        back(k, dungeons, 0);
        return answer;
    }
    
    public static void back(int k, int[][] dungeons, int depth) {
        if (!checkGoing(k, dungeons)) {
            answer = Math.max(answer, depth);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) { // 여기 잘못함. 비지티드 낫
                visited[i] = true;
                back(k-dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
            
            // if (i == dungeons.length - 1 && k < dungeons[i][0]) {
            //     answer = Math.max(answer, depth);
            //     return;
            // }
        }
        
    }
    
    public static boolean checkGoing(int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) return true;
        }
        
        return false;
    }
}

// 체력 짱짱할 때 높은 곳 가면 좋지만, 많이 깎이면 안 가는 게 더 낫다. (우열을 당장 가리기 어려움)
// 던전 개수가 8개이니 완탐해도 될 듯. 
// 백트랙킹 섞기 (체력 마이너스면 후퇴)

// 백트랙킹
    // 종료조건: 체력이 음수이거나, 다 갔을 때
        // depth 저장 Math.max 체려
    // 반복문 
        // 들어갈 수 있는지 확인
        // 체력깎고 백트랙킹 시도
        // 복구: 체력

// 방문 배열이 필요해! 순열처럼!

// 왜 실패?
// 정상적으로 돌기는 할 듯. 그러면 종료 조건이 문제인가?
// 더 이상 방문할 게 없을 때 , k가 음수가 될 수 없음!!
