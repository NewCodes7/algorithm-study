import java.util.*;

class Solution {
    private static List<Integer> answer = new ArrayList<>(); // 선언!!
    
    public int solution(String begin, String target, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(begin);
        dfs(begin, target, words, list, 0);
        if (answer.isEmpty()) {
            return 0;
        }
        return Collections.min(answer);
    }
    
    public static void dfs(String begin, String target, String[] words, List<String> list, int idx) {
        if (list.get(list.size() - 1).equals(target)) {
            answer.add(idx);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) continue;
            if (checkWord(list.get(list.size() - 1), words[i])) {
                list.add(words[i]);
                dfs(begin, target, words, list, idx+1);
                list.remove(words[i]); // 스트링 객체
            }
        }
    }
    
//     public static int bfs(String begin, String target, String[] words) {
//         Queue<String> q = new LinkedList<>();
//         q.offer(begin);
//         int idx = 0;
//         boolean isFounded = false;
        
//         while(!q.isEmpty()) {
//             String c = q.poll();
            
//             if (c.equals(target)) {
//                 isFounded = true;
//                 break;
//             }
            
//             for (int i = 0; i < words.length; i++) {
//                 if (visited[i]) continue;
//                 if (checkWord(c, words[i])) {
//                     System.out.println(words[i]);
//                     q.offer(words[i]);
//                     visited[i] = true;
//                     idx++;
//                 }
//             }
//         }
        
//         if (!isFounded) idx = 0;
        
//         return idx;
//     }
    
    public static boolean checkWord(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        
        if (cnt == 1) {
            return true;
        }
        return false;
    }
}