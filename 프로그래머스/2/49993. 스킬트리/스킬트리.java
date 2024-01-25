import java.util.*;



class Solution {
    public static boolean contains(String[] arr, String target) {
        for (String c : arr) {
            if (target.equals(c)) { // 문자열 비교!!
                return true;
            }
        }
        return false;
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String[] arr = skill.split("");
        
        for (String s : skill_trees) {
            int idx = 0;
            boolean checked = true;
            String[] c = s.split("");
            for (int i = 0; i < c.length; i++) {
                if (c[i].equals(arr[0])) {
                    idx++;
                    continue;
                }
                if (contains(arr, c[i])) {
                    if (c[i].equals(arr[idx])) {
                        idx++;
                    } else {
                        checked = false;
                        break;
                    }
                }
            }
            if (checked == true) {
                answer ++;
            }
        }
        
        return answer;
        // 순회하면서 불리언 값으로 체크해도 될 듯. 
        // skill에서 i번째 스킬을 체크할 때 1부터 i-1번째까지의 스킬이 나왔는지 체크해야 함. i-1번만 체크해도 무방
        
        // skill 이외의 노이즈를 제거하고 판단하는 방법도 있음. 어차피 순회해야 함.
    }
}