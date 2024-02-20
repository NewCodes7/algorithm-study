class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (graph[a][k] == 1 && graph[k][b] == 1) {
                        graph[a][b] = 1;
                        graph[b][a] = -1;
                    }
                    if (graph[a][k] == -1 && graph[k][b] == -1) {
                        graph[a][b] = -1;
                        graph[b][a] = 1;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) cnt++;
            }
            
            if (cnt == n-1) answer++;
        }
        
        return answer;
    }
}

/*
n-1번의 승패결과를 안다면 순위 확정 (여기까진 잘 왔었는데 그 다음을 못이음.)
    확정한 녀석이 이긴 놈들(x명)의 집합에서, 다시 x-1번의 승패결과를 안다면 순위 확정
    확정한 녀석이 진 놈들(x명)의 집합에서, 다시 

재귀네..

한 명이 확정되었다면 이에 의존할 수 있음.

dfs통해서 이긴 횟수, 진 횟수 카운팅
-> 합이 n-1인 녀석 고르고 순위 확정(큐?)
    큐 꺼내기
    dfs통해서 카운팅

그런데 왜 플로이드워셜이지?
    a -> k -> b하면서 승패의 기록을 통해 알 수 있는 걸 최대한 알아야 함. 
    모든 노드간의 업데이트가 필요. 
    승패 기록을 인접 행렬에 기록.

두 가지 방식으로 풀이할 수 있을 듯. 
1. dfs & 재귀
2. 플로이드 워셜 <- 우선 이걸로 ㄱㄱ.

플로이드
    인접 행렬 준비
    반복문

이겼다면 1
졌다면 -1
*/