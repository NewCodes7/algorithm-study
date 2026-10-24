import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int totalTime = convertTimeToInt(play_time);
        int advTime = convertTimeToInt(adv_time);
        
        int[] stats = new int[totalTime + 1]; // 최대 길이 360,000
        for (int i = 0; i < logs.length; i++) { // 최대 순회 300,000
            String[] log = logs[i].split("-");
            int start = convertTimeToInt(log[0]);
            int end = convertTimeToInt(log[1]);
            // 들어오고 나간 것만 기록하면 되니까 
            stats[start]++;
            stats[end]--;
            // for (int j = start; j < end; j++) { // 최대 순회 360,000
            //     stats[j] += 1;
            // }
        }
        
        int startTime = 0;
        long maxSum = 0;
        long beforeSum = 0;
        long inTimeStart = 0;
        long inTimeEnd = 0;
        for (int j = 0; j < advTime; j++) {
            inTimeEnd += stats[j];
            maxSum += inTimeEnd;
        }
        beforeSum = maxSum;
        
        for (int i = 1; i + advTime <= totalTime; i++) { 
            long sum = 0;

            inTimeStart += stats[i - 1];
            inTimeEnd += stats[i + advTime - 1]; // -1이 들어가야 함. 열린 구간이니.. 
            sum = beforeSum - inTimeStart + inTimeEnd;
            
            if (sum > maxSum) {
                startTime = i; 
                maxSum = sum;
            }
            beforeSum = sum;
        }

        return convertIntToTime(startTime);
    }
    
    private int convertTimeToInt(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 * 60 
            + Integer.parseInt(arr[1]) * 60 
            + Integer.parseInt(arr[2]);
    }
    
    private String convertIntToTime(int t) {
        int second = t % 60;
        int minute = (t - second) / 60 % 60;
        int hour = (t - minute * 60 - second) / 60 / 60;
        
        StringBuilder sb = new StringBuilder();
        if (hour == 0) {
            sb.append("00");
        } else if (hour / 10 == 0) {
            sb.append("0").append(hour);
        } else {
            sb.append(hour);
        }
        sb.append(":");
        if (minute == 0) {
            sb.append("00");
        } else if (minute / 10 == 0) {
            sb.append("0").append(minute);
        } else {
            sb.append(minute);
        } 
        sb.append(":");
        if (second == 0) {
            sb.append("00");
        } else if (second / 10 == 0) {
            sb.append("0").append(second);
        } else {
            sb.append(second);
        } 
        
        return sb.toString();
    }
}

/*
1408~1440 77.4 실패랑 시간초과 좀 있음 

거의 100시간까지 되네 
6,000분
360,000초 

logs는 최대 300,000개 

완전탐색으로 풀 순 없음 

누적 배열 만들기 
logs 순회하면서 해당 시간대에 각 시청자 몇 명 있는지 누적시켜두기 
adv_time 구간만큼 0부터 시작해서 오른쪽으로 이동하며 가장 많은 구간 찾기 

6580 = 60 * 109 + 40 

1441~1445
이미 계산된 걸 활용하자! 
advTime이 어정쩡할 때 중간에 있을 때 시간복잡도 커질 수도 있겠다 
점수는 그대로이고 시간초과는 1개로 줄여짐

1445~1459
처음에 누적합 구하는 게 문제네.. 
// hour를 기준으로 일단 필터링하기 
// 0시간 초과 ~ 1시간 미만 -> 두 이웃 hour 합친 것 기준으로 판단 
// 1시간 이상 ~ 2시간 미만 -> 세 이웃 hour 합친 것 기준으로 판단 
// 만약에 이렇게 필터링을 했다면 그 다음은? 
// 걸러낸 logs 바탕으로 minute 기준으로 필터링하기 
// second
일단 아이디어만 

그런데 다 시간이 많이 흩어져있는 경우라면... 


1514~1524
잘 모르겠다 

AI 힌트 ~1602
아 int 오버플로우!!!! 
logs 300000개이고 다 더하면 360000 * 300000

피드백
1. 문제 예시 계산식을 잘 봤다면 좋았을 듯
2. 차등 배열 덕분에 배워간다. 구간에서의 누적 등장횟수 필요할 때 다 메모하는 게 아니라 등장과 퇴장만을 메모하는 아이디어
풀이 태도 2가지 
3. 처음에 누적 구간 구하는 거 시간 복잡도 괜찮을 거라 당연히 생각했는데 아니었음. 시간 복잡도 처음에만 생각하지 말고 풀이 아이디어 떠올린 다음에 점검하자!!! 
4. 무언가를 더할 때 int로 적합할지 항상 생각하자!!! long도 !! 
5. 닫힌 구간인지 열린 구간인지 정확하게 파악하자!! 지레짐작x
*/
