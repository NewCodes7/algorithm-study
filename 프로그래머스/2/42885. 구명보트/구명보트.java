import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);

        int i = 0;
        for (int j = people.length - 1; j >= i; j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }  
            answer++;
        }
        
        return answer;
    }
}

/*
제일 작은거랑 제일 큰거(제일 작은거랑 더해서 limit이하여야 함.)
종료 i == j

시간 초과 해결하려면..?
반복문 줄여야 함. 


*/