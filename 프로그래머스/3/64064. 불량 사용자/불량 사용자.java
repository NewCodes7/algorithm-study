import java.util.*;

class Solution {
    private static HashSet<HashSet<String>> banned_list = new HashSet<>(); // Hashset이 아니다!!
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, 0, new HashSet<>());
        
        return banned_list.size();
    }
    
    public static void dfs(String[] user_id, String[] banned_id, int idx, HashSet<String> set) {
        if (idx == banned_id.length) {
            banned_list.add(set);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i])) {
                continue;
            }
            if (checkSame(user_id[i], banned_id[idx])) {
                set.add(user_id[i]);
                dfs(user_id, banned_id, idx + 1, new HashSet<>(set));
                set.remove(user_id[i]); // 객체로 삭제.
            }
        }
    }
    
    public static boolean checkSame(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        
        return true;
    }
}

// 결과적으로 봤을 때 그게 중복됐잖아. 그러면 그걸 후처리하는 게 아니라 하면서 중복 피하는 방법 고려해야지. 시간 고려하자면. 그렇게 할 수 있는 게 userid set을 따로 파두는 것. 

// banned 반복문 없어도 됨. user_id에서 반복하기에.. 굳이 이중반복문 필요없음. 하나씩 처리해나가면 되는거라. 어차피 무조건 나오기 마련. 


// 시간 초과 나오면 거시적으로 봤어야 해.. 이중반복문. 