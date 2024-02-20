import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> term = new HashMap<>(); // naming, 검수완료
        for (int i = 0; i < terms.length; i++) {
            String[] c = terms[i].split(" ");
            term.put(c[0], Integer.parseInt(c[1]));
        }
        
        int t = Integer.parseInt(today.substring(0, 4)) * 10000 + Integer.parseInt(today.substring(5, 7)) * 100 + Integer.parseInt(today.substring(8, 10));
        
        for (int i = 0; i < privacies.length; i++) {
            String[] c = privacies[i].split(" ");
            // String[] date = c[0].split("."); // 왜 안 돼지? 정규표현식
            // System.out.println(Arrays.toString(c[0].toCharArray(".")));
            
            int year = Integer.parseInt(c[0].substring(0, 4));
            int month = Integer.parseInt(c[0].substring(5, 7)) + term.get(c[1]);
            int day = Integer.parseInt(c[0].substring(8, 10));
            if (day == 1) {
                month--;
                day = 28;
            } else {
                day--;
            }
            
            if (month > 12) {
                year += month/12; // 아. 50이라 생각해봐...!!!! 극단적인 값 해봤어야 해. 엄청 작은 것뿐만 아니라 엄청 큰 것도!!! 단수니 year++이라 하면 안 된다.
                if(month % 12 == 0) year--; // 이거까지 추가!
                
                month %= 12;
                if(month == 0) month = 12;
            } // 여기서 문제가 있었나 보다. 날짜 up할 때 
            

            int p = year * 10000 + month * 100 + day;
            
            System.out.println(p);
            if (t > p) answer.add(i+1);
        }
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}