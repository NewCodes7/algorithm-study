import java.util.*;

class Solution {
    static class Music {
        private int order;
        private int[] startTime; // hour, minutes
        private int[] endTime;// hour, minutes
        private String title;
        private String contents;
        
        public Music(int order, int[] startTime, int[] endTime, String title, String contents) {
            this.order = order;
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.contents = contents;
        }
        
        public String getTitle() {
            return title;
        }
        
        public int getOrder() {
            return order;
        }
        
        public int getPlayedTime() {
            int playedTime = (endTime[0] * 60 + endTime[1]) - (startTime[0] * 60 + startTime[1]);
            return playedTime;
        }
        
        public String getPlayedContents() {
            StringBuilder sb = new StringBuilder();
            int playedTime = getPlayedTime();
            
            for (int i = 0; i < playedTime; i++) {
                sb.append(contents.charAt(i % contents.length()));
            }
            
            return sb.toString();
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        m = convert(m);
        List<Music> musicList = new ArrayList<>();
        
        // musicinfos -> Music 객체로 리스트에 저장
        for (int i = 0; i < musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            int[] startTime = new int[2];
            startTime[0] = Integer.parseInt(arr[0].substring(0, 2));
            startTime[1] = Integer.parseInt(arr[0].substring(3, 5));
            int[] endTime = new int[2];
            endTime[0] = Integer.parseInt(arr[1].substring(0, 2));
            endTime[1] = Integer.parseInt(arr[1].substring(3, 5));
            
            // #붙은 것들 대체하기
            arr[3] = convert(arr[3]);
            
            musicList.add(new Music(i, startTime, endTime, arr[2], arr[3]));
        }
        
        // 조건에 만족되는 music 저장
        List<Music> answerOptions = new ArrayList<>();
        for (int i = 0; i < musicList.size(); i++) {
            String playedContents = musicList.get(i).getPlayedContents();
            if (playedContents.contains(m)) {
                // System.out.println(playedContents.indexOf(m)); // indexOf!!
                // int nextFinalIdx = playedContents.indexOf(m) + m.length();
                // 아.. 처음 찾은 인덱스잖아..! 모든 일치하는 걸 고려하지 못하잖아!!
                // 그러면 확실히 미리 바꾸는 게 편할 듯
                
                answerOptions.add(musicList.get(i));
            }
        }
        
        // music 선정
        String answer = "(None)";
        if (answerOptions.size() == 1) {
            answer = answerOptions.get(0).getTitle();
        } else if (answerOptions.size() >= 2) {
            Collections.sort(answerOptions, (a, b) -> {
                if (b.getPlayedTime() == a.getPlayedTime()) {
                    return a.order - b.order;
                }
                return b.getPlayedTime() - a.getPlayedTime();
            });
            
            answer = answerOptions.get(0).getTitle();
        } 
        
        return answer;
    }
    
    public static String convert(String s) {
        s = s.replaceAll("A#", "H"); // 할당해줘야해!! 원본을 변경하지 않아!
        s = s.replaceAll("B#", "M"); // 할당해줘야해!! 원본을 변경하지 않아!
        s = s.replaceAll("C#", "I");
        s = s.replaceAll("D#", "G");
        s = s.replaceAll("F#", "K");
        s = s.replaceAll("G#", "L");
    
        return s; 
    }
}

/*
C, C#, D, D#, E, F, F#, G, G#, A, A#, B 

music 펼치기
펼친 music 안에 m이 있는지 확인
    확인할 때 뒤에 music 뒤에 #이 붙었는지 확인해야 함.

여러 개라면 재생된 시간 제일 긴 음악, 먼저 입력된 음악

*/