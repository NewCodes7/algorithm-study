import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int minL = 21;
        
        for (int i = 0; i < phone_book.length; i++) {
            minL = Math.min(minL, phone_book[i].length());
        }
        
        Map<String, Boolean> map = new HashMap<>();
        loop:
        for (int i = 0; i < phone_book.length; i++) {
            int n = phone_book[i].length();
            for (int j = minL; j <= n; j++) {
                String c = phone_book[i].substring(0, j);
                if (map.containsKey(c) && (map.get(c) || j == n)) {
                    answer = false;
                    break loop;
                } else {
                    if (j == n) {
                        map.put(c, true);
                    } else {
                        map.put(c, false);
                    }
                }
            }
        }
        
        return answer;
    }
}

/*
길이가 제일 긴것부터 해시 저장
    최소 길이부터 최대길이까지 저장해두기 1, 11, 119
    그러고 저장하면서 중복검사
    
이러면 시간효율성 이천만

sort?
특정값 있는지 찾는 건 map이 시간 복잡도 더 낫다. 훨씬 

실패했다는 건 
    아닌데 false를 부여했거나. 
    맞는데 true를 부여했거나.
11, 14 -> 둘 다 true

한 번호가 다른 번호의 접두어...! 쪼개둔 것끼리 일치했을 수도 있음.
*/