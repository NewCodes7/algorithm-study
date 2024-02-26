import java.util.*;

class Solution {
    private static boolean[] visited;
    private static Set<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        back(user_id, banned_id, 0, new String[banned_id.length]);
        int answer = set.size();
        
        return answer;
    }
    
    public static void back(String[] user_id, String[] banned_id, int depth, String[] arr) {
        if (depth == banned_id.length) { // 변경 필요
            // System.out.println(Arrays.toString(arr));
            // sort 하면 영향 미침..!
            String[] arr2 = arr.clone();
            Arrays.sort(arr2);
            set.add(String.join("", arr2));
            
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            // banned인지 점검 if문
            if (isBanned(user_id[i], banned_id[depth])) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[depth] = user_id[i];
                    back(user_id, banned_id, depth+1, arr);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static boolean isBanned(String user, String banned) {
        if (user.length() != banned.length()) return false;
        
        char[] arr = user.toCharArray();
        char[] arr2 = banned.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr2[i] == '*') continue;
            if (arr[i] != arr2[i]) return false;
        }
        
        return true;
    }
}

/*
9:27~

순열? 이면 될 것 같다. 
하나라면 상관x
두개라면 반영가능
세개라면 이또한 가능

순서 정렬에 따라 가능한 모든 경우의 수가 나옴.

fps, sss
**s, ***라면?

중복처리해야함. 이건 쉬움. -> 어떻게? 배열, 정렬, toString, Set

순열 visited, 선택된 것
*/