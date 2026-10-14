# 부대복귀 최초 풀이 원본 — 2026-10-14

- 풀이: 09:13~09:31 (18분)
- 각 `sources`에서 `destination`까지 BFS를 따로 실행하는 최초 제출/검토 코드와 당시 주석을 보존함.
- 뒤에 작성한 역방향 BFS 코드는 [부대복귀.java](./부대복귀.java).
- 피드백과 개선안은 [FEEDBACK_2026-10-14.md](./FEEDBACK_2026-10-14.md).

```java
import java.util.*;

class Solution {
    private int[] answer;
    private int n;
    private List<List<Integer>> map = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        
        answer = new int[sources.length];
        this.n = n;
        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(sources[i], destination);
        }
        
        return answer;
    }
    
    private int bfs(int from, int to) {
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.offer(new Integer[]{from, 0});
        visited[from] = true;
        
        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            if (curr[0] == to) {
                return curr[1];
            }
            
            for (int i = 0; i < map.get(curr[0]).size(); i++) {
                int next = map.get(curr[0]).get(i);
                if (!visited[next]) {
                    queue.offer(new Integer[]{next, curr[1] + 1});
                    visited[next] = true;
                }
            }
        }
        
        return -1;
    }
}

/*
09:13~09:31 18분

피드백
1. 더 개선할 여지가 있는가? 
2. 시간 복잡도는 어떻게 되지? O(V + E)?

설계
1. 인접리스트
2. bfs
    sources 하나씩 bfs 
    
3. result

*/
```

