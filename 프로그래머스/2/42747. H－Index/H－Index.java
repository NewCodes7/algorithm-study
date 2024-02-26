import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // int는 쓸수가없음.comparator 
        for (int i = citations.length-1; i >= 0; i--) {
            if (citations[i] < citations.length - i) {
                return citations.length - i -1;
            }
        }
        return citations.length;
    }
}

// 배열길이가 최대의 최댓값
// 배열길이 -> 1 반복
// 다른 배열에 저장해둔다면. 

// 0, 1, 3, 5, 6
// 5, 4, 3, 2, 1

// 0, 0, 1, 2, 3, 3, 5
// 7, 7, 5, 4, 3, 3, 1

// 6, 7, 8, 9
// 4, 3, 2, 1

// 3, 5, 8, 9
// 4, 3, 2, 1