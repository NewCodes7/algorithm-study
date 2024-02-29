import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {        
        // 배열 초기화
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        for (int c : lost) arr[c]--;
        for (int c : reserve) arr[c]++;
        
        // 그리디
        for (int i = 1; i <= n; i++) {
            if (i == n) continue;
            
            if (arr[i] == 0 && arr[i+1] == 2) { // 없는 학생, 여분 학생
                arr[i]++;
                arr[i+1]--;
            } else if (arr[i] == 2 && arr[i+1] == 0) { // 여분 학생, 없는 학생
                arr[i]--;
                arr[i+1]++;
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(arr[i] != 0) answer++;
        }
        
        return answer;
    }
}


/*
10:06~
불리언으로 표현 가능

lost -> false

순회하다가
    리버스가 나오면, 오른쪽 학생이 로스트라면 넘겨주기
    로스트가 나오면, 오른쪽 학생이 리버스라면 넘겨받기
    그냥이 나오면, 넘기기

로스트 0
일반 1
리버스 2
*/