import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] count = new int[id_list.length];
        int[] answer = new int[id_list.length];
        
        List<Set<String>> list = new ArrayList<>(); // 중복 신고 방지 위해 set
        for (int i = 0; i < id_list.length; i++) {
            list.add(new HashSet<>());
        }
        for (int i = 0; i < report.length; i++) {
            String[] c = report[i].split(" ");
            list.get(indexOf(id_list, c[0])).add(c[1]);
        }
        
        for (int i = 0; i < list.size(); i++) {
            List<String> list2 = new ArrayList<>(list.get(i));
            for (String c : list2) {
                count[indexOf(id_list, c)]++;
            }
            
            // Iterator iterSet = list.get(i).iterator();
            // while(iterSet.hasNext()) {
            //     count[indexOf(id_list, iterSet.next())]++;
            // }
        }
        
        List<String> badUsers = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k) {
                badUsers.add(id_list[i]);
            }
        }
        
        for (int j = 0; j < list.size(); j++) {
            List<String> list2 = new ArrayList<>(list.get(j));
            for (String c : list2) {
                if (badUsers.contains(c)) {
                    answer[j]++;
                }
            }
        }
        
        
        // 1차원 배열에서는 각 아이디의 신고 횟수 집계
        // 결괏값 리턴을 위해 2차원 배열 선언 -> 포함되면 answer ++;
        
        return answer;
    }
    
    public static int indexOf(String[] id_list, String id) {
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(id)) {
                return i;
            }
        }
        
        return -1;
    }
}