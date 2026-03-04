import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<String> targets = List.of("C#", "D#", "F#", "G#", "A#");
        
        int maxLength = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            int start = Integer.parseInt(arr[0].split(":")[0]) * 60 + Integer.parseInt(arr[0].split(":")[1]);
            int end = Integer.parseInt(arr[1].split(":")[0]) * 60 + Integer.parseInt(arr[1].split(":")[1]);
            int duration = end - start;
            String title = arr[2];
            String[] info = arr[3].split("");
            
            // 악보 펼치기 
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (sb.length() != duration) {
                j++;
                String before = info[(j - 1) % info.length];
                String target = info[j % info.length];
                String add = before + target;
                if (targets.contains(add)) {
                    sb.append(targets.indexOf(add));
                } else if (before.equals("#")) {
                    continue;
                } else {
                    sb.append(before);
                }
            }
            
            // m 악보 펼치기 
            StringBuilder user = new StringBuilder();
            String[] temp = m.split("");
            for (j = 1; j <= temp.length; j++) {
                String before = temp[(j - 1) % temp.length];
                String target = temp[j % temp.length];
                String add = before + target;
                if (targets.contains(add)) {
                    user.append(targets.indexOf(add));
                    j++;
                } else if (before.equals("#")) {
                    continue;
                } else {
                    user.append(before);
                }
            }
            
            // 매칭 
            String server = sb.toString();
            String client = user.toString();
            //System.out.println(server.length());
            //System.out.println(client);
            if (server.contains(client) && duration > maxLength) {
                maxLength = duration;
                answer = title;
            }
        }
        
        return answer;
    }
}

/*
08:30~09:08 첫 시도 

음은 12개. C#, C 조심

더 많이 겹치는 긴 시간x 재생시간 제일 긴 -> 먼저 입력된 

시간만큼 일단 음을 펼쳐야 함 

none으로 시작하기 
musicinfos 하나씩 순회하면서 
    시간만큼 음을 펼치기 - 음을 펼치면서 치환 (C# D# F# G# A#)
    m과 매칭해보기 - #까지 맞는지 확인해야 함 (# 붙어있는 걸 다른 걸로 치환)
        맞다면, 최장길이인지 확인
            최장길이라면 저장
            최장길이와 같다면 넘기기
        틀리다면, 넘기기

매칭이 까다롭지만
m을 2번 반복한다면, 끊기는 것도 고려 가능 


*/