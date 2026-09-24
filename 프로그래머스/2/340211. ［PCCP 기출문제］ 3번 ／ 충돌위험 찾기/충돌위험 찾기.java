import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // 로봇 현재 위치 및 다음 위치 파악 
        int[][] robotsFrom = new int[routes.length][2]; // [2] 빼먹었었음 2 빼먹고 []라 해도 됨 
        int[][] robotsTo = new int[routes.length][2];
        int[] robotsToIndex = new int[routes.length];
        int end = 0;
        for (int i = 0; i < routes.length; i++) {
            int pointFrom = routes[i][0];
            robotsFrom[i] = Arrays.copyOf(points[pointFrom - 1], 2);
            int pointTo = routes[i][1];
            robotsTo[i] = Arrays.copyOf(points[pointTo - 1], 2);
            robotsToIndex[i] = 1;
        }
        // System.out.println(Arrays.deepToString(robotsFrom));
        // System.out.println(Arrays.deepToString(robotsTo));
        
        while (true) {
            // 로봇 위치 겹치는 거 파악 
            Set<String> set = new HashSet<>();
            Set<String> setAlready = new HashSet<>();
            for (int i = 0; i < robotsFrom.length; i++) {
                if (robotsToIndex[i] == -1) continue;
                
                String location = "X" + robotsFrom[i][0] + "Y" + robotsFrom[i][1];
                if (set.contains(location) && !setAlready.contains(location)) {
                    setAlready.add(location);
                    answer++;
                    continue;
                }
                if (!set.contains(location)) {
                    set.add(location);
                }
            }
            
            if (end == routes.length) break; // routes.length - 1로 비교하는 실수가 있었음. 인덱스 비교가 아니라 개수 비교임!!
            
            // 목적지 왔는지 확인 후 이동 
            for (int i = 0; i < robotsFrom.length; i++) {
                if (robotsToIndex[i] == -1) continue;
                
                int[] from = robotsFrom[i];
                int[] to = robotsTo[i];
                // 목적지에 왔다면 
                if (from[0] == to[0] && from[1] == to[1]) {
                    // 다음 목적지가 있다면
                    if (robotsToIndex[i] < routes[i].length - 1) {
                        robotsToIndex[i]++;
                        robotsTo[i] = Arrays.copyOf(points[routes[i][robotsToIndex[i]] - 1], 2);
                    } else if (robotsToIndex[i] == routes[i].length - 1) {
                        // 다음 목적지가 없다면 
                        robotsToIndex[i] = -1;
                        end++;
                    }
                }
                
                // 칸 이동 
                if (robotsFrom[i][0] > robotsTo[i][0]) {
                    robotsFrom[i][0]--;
                } else if (robotsFrom[i][0] < robotsTo[i][0]) {
                    robotsFrom[i][0]++;
                } else if (robotsFrom[i][1] > robotsTo[i][1]) {
                    robotsFrom[i][1]--;
                } else if (robotsFrom[i][1] < robotsTo[i][1]) {
                    robotsFrom[i][1]++;
                }
            }
        }
        
        return answer;
    }
}

/*
12:37~13:16 39m 초안 풀이 + 살짝 디버깅 
어디에서 시간이 오래 걸렸지? 딱히 크게 걸린 부분도 없었는데 
14:18~14:39 21m 힌트 받아서 품 

좌표 + 1
행을 먼저 맞춤 

로봇 위치 담을 배열 만들기 robotsFrom 
robotsTo 

while (모든 로봇이 제 자리로 갈 때까지)
    각 로봇 위치 순회하면서 충돌했는지 확인하기 
    robotsTo 확인해서 목적지 왔는지 확인 
        목적지 다 왔다면 다음 위치 설정, 다음 위치 없다면 종료
        목적지 다 안 왔다면 행부터 우선적으로 이동하기 

피드백
1. 2차원 배열에서 한 원소 다른 배열에 삽입할 때 -> Arrays.copyOf(arr, 몇개)
    할당할 때 주소값을 공유해도 되는 케이스인지 확인해라 
2. end 무지성으로 -1해버림. 개수만큼 했어야 했는데 집중도가 떨어져서 인덱스 계산하듯이 해버림
3. 전반적으로 풀이 계획 자체는 좋았는데 2차원 배열 값 복사 디테일과 종료조건 디테일이 아쉬웠음 
4. 2차원 배열 생성 이렇게도 가능 int[][] robotsTo = new int[routes.length][];
*/
