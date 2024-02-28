import java.util.*;

class Solution {
    private static Map<String, String> people = new HashMap<>(); // 신입, 추천인
    private static Map<String, Integer> result = new LinkedHashMap<>(); // 신입, 추천인
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        // people 삽입
        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], referral[i]);
            result.put(enroll[i], 0);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int price = 100 * amount[i];
            String person = seller[i];
            calculate(person, price);
        }
        
        int[] answer = new int[enroll.length];
        List<Integer> list = new ArrayList<>(result.values());
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = list.get(i); // 성능 개선 가능 큐?
        }
        
        return answer;
    }
    
    public static void calculate(String person, int price) {
        // int curr = price * 9 / 10;
        int next = price * 1 / 10; // 계산방식..?   
        int curr = price - next;
        
        if (person.equals("-")) return; // 문자열 비겨!!!
        if (next < 1) { // 모두 현재 사람에게 귀속
            result.put(person, result.get(person)+price);
            return;
        }
        
        result.put(person, result.get(person)+curr);
        calculate(people.get(person), next);
    }
}

/*
3:06~

map<추천인, 추천해서 들어온 사람>
center, mary
mary, edward
edward, young

반대로. 
추천해서 들어온 사람, 추천인

seller 반복문
    본인 90프로 가지기
    추천인 10프로 건네주기 (1원 이하라면 종료)
        본인 10프로 중의 90프로 가지기
        추천인 10프로 중의 10프로 건네주기
            ...

가지고, 건네주는 걸 메서드. 그리고 재귀화 (center에 도다랗거나 1원이하가 될 때까지)
*/