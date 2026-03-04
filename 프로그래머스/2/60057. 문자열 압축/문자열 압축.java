import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1000;
        
        for (int i = 1; i <= s.length(); i++) {
            char[] st = s.toCharArray();
            StringBuilder str = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            String before = "";
            int count = 1;
            //System.out.println(i);
            
            for (int j = 0; j < st.length; j++) {
                char t = st[j];
                //System.out.println(t);
                if (sb.length() < i) {
                    sb.append(t);
                }
                
                if (sb.length() == i) {
                    if (before.equals("")) {
                        before = sb.toString();
                        sb.setLength(0);
                        continue;
                    }
                    
                    if (before.equals(sb.toString())) { // more
                        count++;
                    } else { // flush
                        if (count == 1) {
                            str.append(before);
                            before = sb.toString();
                        } else {
                            str.append(count + before);
                            before = sb.toString();
                        }
                        count = 1;
                    }
                    sb.setLength(0);
                } 
            }
            
            if (count == 1) {
                str.append(before);
            } else {
                str.append(count + before);
            }
            
            str.append(sb.toString());
            
            //System.out.println(str.toString());
            
            answer = Math.min(str.length(), answer);
        }
        
        return answer;
    }
}

/*
11:52~

앞에서부터 정해진 길이만큼 잘라야 하나보네
중간부터 못 자르고

그리고 잘라둔 것끼리 같은지 확인 양옆
    그 전꺼랑 같은지 확인 
        이전에 같았을 때 지금은 다르다면 flush
        그냥 다르다면 이전 거 save

그리고 s의 길이만큼 반복하면서 최소 단위 구하기 



*/