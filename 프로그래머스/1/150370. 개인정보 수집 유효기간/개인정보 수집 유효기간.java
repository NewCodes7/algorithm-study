import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> term = new HashMap<>(); // naming, 검수완료
        for (int i = 0; i < terms.length; i++) {
            String[] c = terms[i].split(" ");
            term.put(c[0], Integer.parseInt(c[1]));
        }
        
        int t = Integer.parseInt(today.substring(0, 4)) * 12 * 28 + Integer.parseInt(today.substring(5, 7)) * 28 + Integer.parseInt(today.substring(8, 10));
        
        for (int i = 0; i < privacies.length; i++) {
            String[] c = privacies[i].split(" ");
            // String[] date = c[0].split("."); // 왜 안 돼지?
            // System.out.println(Arrays.toString(c[0].toCharArray(".")));
            
            int year = Integer.parseInt(c[0].substring(0, 4));
            int month = Integer.parseInt(c[0].substring(5, 7));
            int day = Integer.parseInt(c[0].substring(8, 10));
//             if (day == 1) {
//                 month--;
//                 day = 28;
//             } else {
//                 day--;
//             }
            
//             if (month > 12) {
//                 year++;
//                 month %= 12;
//             }
            

            int p = year * 12 * 28 + month * 28 + day  + term.get(c[1]) * 28 - 1;
            
            System.out.println(p);
            if (t > p) answer.add(i+1);
        }
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
    
//     public static int[] toInt(String[] c) {
//         int[] arr = new int[c.length];
//         for (int i = 0; i < c.length; i++) {
//             arr[i] = Integer.parseInt(c[i]);
//         }
//         System.out.println(Arrays.toString(arr));
        
//         return arr;
//     }
}

// privacies 순회 -> 각각 만기일 계산 후 판단 
// terms -> Map
// 날짜 문자열 처리 -> '.' split 날짜 계산 메서드 따로
// 날짜 비교 -> 다 더 해서 비교하거나 if문