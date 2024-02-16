import java.util.*;

class Solution {
    private static int[] answer = null;
    private static int[] rion = new int[11];
    private static int rionS = 0;
    private static int infoS = 0;
    
    public int[] solution(int n, int[] info) {
        back(n, info, 9); // 큰 점수"차!!!"로 이기려면 처음부터 시작해야함. 아니야.. 그 순서를 고려하려면 뒤에서부터 해야 해.,  // 0점은 더 맞출 필요가 없음 10은 버려도돼
        
        if (answer == null) {
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
        public static void back(int n, int[] info, int depth) {
        if (depth == -1 || n <= 0) {
            checkWinner(n, info);
            return;
        }
        
        if (info[depth] == 0) {
            rion[depth]++;
            back(n-1, info, depth-1);
            rion[depth]--;
        } else {
            if (n >= info[depth] + 1) { // 남은 화살 체크
                rion[depth] += info[depth] + 1;
                back(n-rion[depth], info, depth-1);
                rion[depth] -= info[depth] + 1;
            } else {
                back(n, info, depth-1);
            }
        }
        back(n, info, depth-1); // 반복문이 없어서.. back제대로 작동하지 않음. 풀없이 죽업버림.
        
    }
    
//     public static void back(int n, int[] info, int depth) {
//         if (depth == n) { // depth가 0일 때 뿐만 아니라 끝에 도달했을 때도 계산해야함.
//             checkWinner(n, info);
//             return;
//         }
        
//         for (int i = rion.length - 1; i >= 0; i--) { 
//             // 우선 점수를 가장 많이 따는 데 집중!
//             if (info[i] == 0) {
//                 rion[i]++;
//                 back(n, info, depth+1);
//                 rion[i]--;
//             } else {
//                 if (n - depth >= info[i] + 1) { // 남은 화살 체크
//                     rion[i] += info[i] + 1;
//                     back(n, info, depth+info[i]+1);
//                     rion[i] -= info[i] + 1;
//                 }
//             }
//         }
//     }
    
    public static void checkWinner(int n, int[] info) {
        int rionScore = 0;
        int infoScore = 0;
        
        // 점수 계산
        for (int i = 0; i < 11; i++) {
            if (rion[i] == 0 && info[i] == 0) continue;
            if (rion[i] <= info[i]) {
                infoScore += 10-i;
            } else {
                rionScore += 10-i;
            }
        }
        
        // 갱신
        if (rionScore > infoScore && rionS-infoS < rionScore-infoScore) {
            if (answer == null) {
                answer = new int[11];
                // answer = rion; 깊은 복사
            }
            
            if (n > 0) { // 남은 화살이 있다면
                rion[10] += n;
            }
            
            for (int i = 0; i < 11; i++) {
                answer[i] = rion[i];
            }
            rionS = rionScore;
            infoS = infoScore;
        }
    }
}

/*
n = 10
길이 11
11의 10제곱 / 10! 1,000,000,000 간당함. 우선 go

그 이모티콘 문제처럼.

1. 백트랙킹
    1. depth: 화살 개수
    2. 종료조건: depth == n
    3. 반복문: ++, back, 복구
2. 계산
    1. 이겼는지 판단 (반복문)
    2. 기존의 것과 비교 후 저장
3. 리턴 -> 값 없다면 -1반환

거꾸로 가면, 실행횟수 줄일 수 있음. 가장 큰 점수차인걸 놓쳤다!!

실패와 효율성 문제
    1. 우선 back은 온전히 모든 경우의 수를 탐색함.
    2. back의 성능을 높여야 할 듯. (굿판단)
        1. 0일 때 하나만 추가해도 됨.
        2. 점수가 부족하면서 1일 때 2만 추가해도 됨. 
        3. 점수가 넉넉하면서 1일 때 0.
        4. 그리고 10점에서 남는 화살을 제일 마지막에 부여하면 됨. -> calculate
    3. 좀 더 성능 개선이 필요함.
    
이제 실패 문제를 들여다보자.
    왜 실패했을까?
*/