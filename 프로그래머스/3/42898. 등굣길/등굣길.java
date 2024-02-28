class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] graph = new int[n+1][m+1];
        graph[1][1] = 1;
        for (int[] c : puddles) { // 아... puddles또한 뒤집어야지..!!! 예제가 2,2여서 방심했네.
            graph[c[1]][c[0]] = -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == -1) continue;
                if (j != m && graph[i][j+1] != -1) {
                    graph[i][j+1] += graph[i][j] % 1000000007;
                }
                if (i != n && graph[i+1][j] != -1) {
                    graph[i+1][j] += graph[i][j] % 1000000007;
                }
            }
        }
        
        return graph[n][m] % 1000000007;
    }
}

/*
11:21~

아래, 왼쪽으로만 가면 됨. 이것만 반복됨. (단순한, 정형화된 행동이)
시간이 타이트할 수 있음. 
 - > dp!!
설계 정말 중요해.. 경우에 따라서는 20분까지 설계하는 것도 염두에 두자.

런타임 에러..

*/