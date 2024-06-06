import java.util.*;

class Solution {
    private int maxScoreGap = 1;
    private int[] maxLionInfo = {-1};
    private int n;
    private int[] info;
    
    public int[] solution(int n, int[] info) {
        this.n = n; 
        this.info = info;
        
        int scoreGap = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] != 0) {
                scoreGap -= 10 - i;
            }
        }
        
        back(0, scoreGap, 10, new int[11]);
        
        return maxLionInfo;
    }
    
    private void back(int usedArrows, int scoreGap, int k, int[] lion) { // 어피치, 라이언 점수 구분 필요
        if (usedArrows > n) {
            return;
        }
        
        if (scoreGap >= maxScoreGap) {
            // System.out.println(scoreGap);
            int[] temp = lion.clone(); // 배열 복사!
            temp[10] += n - usedArrows; // 아 할당이 아니라 +=로 했어야 함!! 방심 실수 ㅠㅠ 코드 하나하나!! 근데 그래도 2개 실패...
            // 이 부분이 가장 위험 확률이 높을 듯. 
            // 나중에 또 나올 수도 있을 듯. 9(10),0,0,1(0) -> 0,4(5),5(3),1(1),0(0) 이런 케이스 대략?
            // 복잡해질 때쯤 실전에서는 다른 문제로 넘어가야 할 듯. 환기하는 걸 CS 문제로 대체해도 될 듯. 
            
            // 더 큰 점수차로 이길 수도 있는데 몰빵하는 게 맞아? -> ㅇㅇ. 더 큰 점수차는 백트랙킹에 의해 나오게 되니, 여유분이 있다면 몰빵하는 게 맞음.
            if (scoreGap != maxScoreGap || maxLionInfo.length == 1) {
                maxScoreGap = scoreGap;
                maxLionInfo = temp;
            }
            
            for (int i = 10; i >= 0; i--) {
                if (temp[i] > maxLionInfo[i]) {
                    maxLionInfo = temp;
                    break;
                } else if (temp[i] < maxLionInfo[i]) {
                    break;
                }
            }
        }
        
        for (int i = k; i >= 0; i--) {
            usedArrows += info[10 - i] + 1;
            lion[10 - i] += info[10 - i] + 1;
            // scoreGap += k * 2; 이대로 하면 안 됨..! 어피치가 0개일 때는 k 하나만 더해야 해!
            if (info[10 - i] == 0) {
                scoreGap += i; // 아 여기도 k가 아니라 i!!!
            } else {
                scoreGap += i * 2;
            }
            
            back(usedArrows, scoreGap, i - 1, lion); // k - 1이 아니라 i - 1!!!
            
            usedArrows -= info[10 - i] + 1;
            lion[10 - i] -= info[10 - i] + 1;
            if (info[10 - i] == 0) {
                scoreGap -= i;
            } else {
                scoreGap -= i * 2;
            }
        }
    }
}

/*
<요구사항 정리>
1. 특정 점수에 더 많은 화살을 맞춘 사람이 그 특정 점수를 가져감.
    단, 특정 점수에 대해 화살 개수가 같으면 어피치가 가져감.
2. 최종 점수로 승패 판결, 점수 같다면 어피치 승
3. 가장 큰 점수차로 이길 수 있는 것 리턴
    라이언 우승 방법 여러 개라면, 가장 낮은 점수를 더 많이 맞힌 경우 리턴
        가장 낮은 점수에서 개수 같다면 그 다음걸로.
4. n 최대 10개 -> 10H10 -> 19C10

<설계> 21분
10,000,000,000 대충 완탐해도 시간 제한은 안 걸릴 듯. 

백트랙킹? 
만약 어피치가 1개라도 쏜 영역에서 라이언이 쏜다면 '해당 개수 + 1'만큼 쏴야 함.
조합? 
    0개 이거나 (어피치 + 1)이여야 함.
    단, 가장 큰 점수차이면서 화살 남았다면 제일 낮은 것에 할당
그러면 가장 큰 점수차인 배열 어떻게 얻을거야? 
    점수차 max인 것들로만 배열 따로 저장해서, 마지막에 상호간에 비교? 
    
    가장 마지막에 나오는 게 정답 아닐까? 우선 구현 ㄱㄱ
    
55분 제출 2개 실패

2개 실패 테케 생각해보자!!
*/