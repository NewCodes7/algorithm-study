import java.util.*;

class Solution {
    private static int[] number;
    private static boolean[] visited;
    private static Set<Integer> s = new HashSet<>();
    
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()]; // 메서드 숙지
        
        // 원소의 개수 선택해서 그 만큼에 해당하는 종이 추출.
        for (int i = 1; i <= numbers.length(); i++) {
            back(numbers, 0, i, new StringBuilder());
            Arrays.fill(visited, false); // 방문 배열 초기화.
        }
        int answer = s.size();
        // 조합 -> 검열
        return answer;
    }
    
    // 순열
    public static void back(String numbers, int idx, int l, StringBuilder sb) {
        if (idx == l) {
            int c = Integer.parseInt(sb.toString());
            if (check(c)) {
                s.add(c);
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                
                back(numbers, idx + 1, l, sb);
                
                sb.deleteCharAt(sb.length() - 1); // 메서드 숙지
                visited[i] = false; // 이것도 풀어줘야 해.
            }
        }
    }
    
    public static boolean check(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}
