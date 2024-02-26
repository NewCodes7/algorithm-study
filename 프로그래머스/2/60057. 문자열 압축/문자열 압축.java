class Solution {
    public int solution(String s) {
        int answer = 1000;
        
        for (int i = 1; i <= s.length() / 2; i++) { // 소수점 버려도 무방
            StringBuilder sb = new StringBuilder();
            // String before = s.substring(0, i);
            int j = 0;
            // if (!before.equals(s.substring(j, j+i))) {
            //     sb.append(before);
            // }
            
            // before가 아니라 after와 비교
            int cnt = 1;
            
            while(true) {
                String c = s.substring(j, j+i);
                if (j+i+i > s.length()) { // -1이 아님!!
                    if (cnt != 1) {
                        sb.append(cnt);
                        cnt = 1;
                    }
                    sb.append(c);
                    sb.append(s.substring(j+i, s.length()));
                    break;
                }
                
                String after = s.substring(j+i, j+i+i);
                
                if (c.equals(after)) {
                    cnt++;
                } else {
                    if (cnt != 1) {
                        sb.append(cnt);
                        cnt = 1;
                    }
                    sb.append(c);
                }
                
                j += i;
            }
            answer = Math.min(answer, sb.length());
        }
        
        if (s.length() == 1) {
            return 1;
        }
        
        return answer;
    }
}

/*
앞에서부터 정해진 개수만큼 자르기 - 완전탐색 ?

반복문 1 ~ s.length/2, substring
    반복문 - 정해진 개수만큼 자르면서 중복되는지 확인 (그 다음 거랑!!)
        중복되면 몇개인지 세고 저장하기 StringBuilder
        중복 아니라면 저장하고 넘기기
    max 확인 후 저장
*/