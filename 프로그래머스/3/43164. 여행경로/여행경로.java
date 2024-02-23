import java.util.*;

class Solution {
    private static Map<String, List<String>> map = new HashMap<>();
    private static int n;
    private static String[] answer;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        
        // 그래프 전처리
        for (int i = 0; i < tickets.length; i++) {
            List<String> list;
            
            if (map.containsKey(tickets[i][0])) {
                list = map.get(tickets[i][0]);
            } else {
                list = new ArrayList<>();
            }
            
            list.add(tickets[i][1]);
            map.put(tickets[i][0], list);
        }
        
        for (List<String> list : map.values()) { // 메서드! 키 밸류 헷갈리지마
            Collections.sort(list, Comparator.reverseOrder());
        }
        
        String[] arr = new String[n+1];
        arr[0] = "ICN";
        dfs(1, "ICN", arr);
        
        return answer;
    }
    
    public static void dfs(int depth, String s, String[] arr) {
        if (depth == n+1) { // 티켓수+1, 있는지 확인!! 눌
            // 여기서 answer 작업해줘야 함!! 나중에 불완전하게 끝날 수 있으니
            answer = arr.clone();
            return;
        }
        
        if (!map.containsKey(s)) {
            return;
        }

        for (int i = 0; i < map.get(s).size(); i++) {
            String next = map.get(s).get(i);
            arr[depth] = next;
            map.get(s).remove(i); // visited
                
            dfs(depth+1, next, arr);
            
            map.get(s).add(i, next); // 복원!
        }
    }
}

/*
11:12~

미리 정렬 (내림차순)
그래프 전처리 Map

dfs
    종료 조건: depth == tickets.length+1

왜 틀렸지?
*/