class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int currentday = startday;
        for (int i = 0; i < schedules.length; i++) {
            boolean isSatisfied = true;
            
            for (int j = 0; j < timelogs[i].length; j++) {
                // 주말이면 넘어가주기 
                if (currentday % 7 == 6 || currentday % 7 == 0) {
                    currentday++;
                    continue;
                }
                
                // 시간 넘었는지 체크 
                int deadline = schedules[i] + 10;
                if ((deadline / 10) % 10 >= 6) {
                    deadline -= 60;
                    deadline += 100;
                }
                if (deadline < timelogs[i][j]) {
                    isSatisfied = false;
                    break;
                }
                currentday++;
            }
            
            if (isSatisfied) {
                answer++;
            }
            currentday = startday;
        }
        
        return answer;
    }
}

/*
8:37~
startday % 7

schedule 순회
    timelogs 순회
        주말이라면 패스
        넘었는지 체크
            넘었다면 끝
            안 넘었다면 keep going 
        
아 50분대일 떄를 고려 안했다!! 
시간 올림 해주기 !

*/
