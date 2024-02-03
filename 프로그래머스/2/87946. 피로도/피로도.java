import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        back(dungeons.length, new ArrayList<>(), k, dungeons);
        return answer;
    }
    
    public static void back(int n, List<Integer> list, int k, int[][] dungeons) {
        if (list.size() == n) {
            int hp = k;
            int cnt = 0;
            for (int i : list) {
                if (hp >= dungeons[i][0]) {
                    hp -= dungeons[i][1];
                    cnt++;
                } else {
                    break;
                }
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;
                back(n, list, k, dungeons);
                list.remove(list.size() - 1);
                visited[i] = false;
            }

        }
        
    }
}

// 지금 당장 체력을 덜 깎는 것만이 정답이 아니다. 
// 개수도 적으니 완전탐색을 가는 게 좋겠다. 순열?
// 순열 어떻게 하더라? 백? 