import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            int count = players[i] / m - server[i];
            if (count <= 0) {
                continue;
            }
            
            answer += count;
            for (int j = i; j < i + k; j++) {
                if (j > server.length - 1) {
                    break;
                }
                server[j] += count;
            }
        }
        
        return answer;
    }
}

/*
6:48~7:08

<문제 이해> 
m명 수용할 수 있는 서버 - 5
n대 - 1
m x n 이상 m x (n + 1) 미만 - 5 6 7 8 9
max까지는 못 가는 거네. 기본 1대 있는 거고. 

k를 잘 고려해야 할 듯 
일단 급한 불 끌만큼은 서버를 투입해야 함
k를 고려해서 더 오버해서 투입할 필요는 있는가? 
    굳이 그럴 필요는 없음. 당장 필요없는 서버를 증설하는 건 지속 시간이 줄어드니 손해임
    그리고 증설 횟수 자체를 카운팅하는 싸움이니

그러면 지금 당장 급한 불을 끄면서 k의 지속시간을 챙겨주면서 나아가면 될 듯 (그리디)

players 배열처럼 서버 증설 k 지속시간 체크할 수 있는 배열 만들기 (0으로 초기화)
for (player players)
    (player / m - 기존에 있는 서버 수)만큼 서버 증설 (음수라면 pass)
    서버 증설했다면 k만큼 지속되게 배열에 ++

*/
