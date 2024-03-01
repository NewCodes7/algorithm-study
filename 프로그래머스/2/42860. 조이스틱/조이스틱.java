class Solution {
    public int solution(String name) {
        int answer = 0;
        
        char[] arr = name.toCharArray();
        
        int maxA = 0;
        int temp = 1;
        int idx = -1;
        int size = 'Z' - 'A';
        for (int i = 0; i < arr.length; i++) {
            int d = arr[i] - 'A';
            if (d > size/2) {
                d = size - d + 1;
            }
            answer += d;
            
            if (i == arr.length -1) continue;
            if (arr[i] == 'A' && arr[i+1] == 'A') {
                temp++;
            } else {
                if (temp == 1) continue;
                if (maxA < temp) {
                    maxA = temp;
                    idx = i - temp + 1;
                    temp = 1;
                }
            }
        }
        
        if (answer == 0) return 0;

        int dis = arr.length-1;
        
        // 쭉 앞으로
        int str = arr.length-1;
        for (int i = arr.length-1; i >=0; i--) {
            if (arr[i] == 'A') {
                str--;
            } else {
                break;
            }
        }
        dis = Math.min(dis, str);
        
        // 쭉 뒤로
        str = arr.length-1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 'A') {
                str--;
            } else {
                break;
            }
        }
        dis = Math.min(dis, str);
        
        if (maxA > 1) {
            dis = Math.min(dis, 2 * (idx-1) + arr.length - (idx+(maxA)));
            dis = Math.min(dis, 2 * (arr.length - (idx+(maxA))) + idx-1);
        }

        answer += dis;
        return answer;
    }
}

/*
가장 먼저 현재 숫자 건들기
왼쪽으로 갈지 오른쪽으로 갈지 판단

오른쪽이 A라면 오른쪽 갈필요가 없음.
    우선 한바퀴 미만으로 도는 게 목표.
    
반면, JBCDAAAAANA라면 왼쪽으로 가야 함. 
A를 기준으로 섣불리 판단하기는 힘듦.

막 왔다갔다 하는 건 말이 안되고
결국 왼쪽으로 갔다가 오른쪽 갈건지 vs 오른쪽 갔다가 왼쪽 갈건지 정해야 함.
아니면 쭉 오른쪽 or 쭉 왼쪽

4가지 경우를 판단하면 될 듯. 

그리고 A만드는 건 정해져 있음. 

A가 한 개라면 왼쪽, 오른쪽 중 하나로 계산됨.
*/