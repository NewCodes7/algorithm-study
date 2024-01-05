import java.util.*;

class Solution {
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > source.length()) endIndex = source.length(); // 인덱스 넘어가는 것 if문 통해 방지
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }
    
    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();
        
        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) sb.append(count); //마지막까지 같을 때 
        sb.append(last);

        return sb.length();
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE; // 최댓갑 설정
        for (int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }
}
// for로 무식하게 돌기보다는 우선 split하는 게 좋음. 왜냐하면, for 깔끔하게 떨어지지 않으니. 
// 아 코테 진짜 많이 풀어봐야겠다..

// 메서드 분리의 필요성.. 리팩토링. 중간중간 가독성
// 문자열 비교 == 아니다! equals
// subString x