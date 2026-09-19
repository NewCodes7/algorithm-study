class Solution {

    public int solution(String s) {
        int answer = 0;

        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= s.length(); i++) {
            //System.out.println(i+"길이 단계");
            // 첫 번째 토큰 구하기
            for (int j = 0; j < i; j++) {
                sb.append(arr[j]);
            }
            String before = sb.toString();
            sb.setLength(0);
            int count = 1;
            //System.out.println("before: "+before);

            // 한 길이에 대해 시행
            for (int j = i; j < s.length(); j++) {
                sb.append(arr[j]);

                // 한 토큰이 완성됐을 때
                if (sb.length() == i) {
                    if (before.equals(sb.toString())) {
                        // 토큰 같은 경우
                        count++;
                    } else {
                        // 토큰 다른 경우
                        if (count == 1) {
                            str.append(before);
                        } else {
                            str.append(count).append(before);
                        }
                        //System.out.println("str 변화: "+str);

                        before = sb.toString();
                        count = 1;
                    }
                    // 초기화
                    sb.setLength(0);
                }
            }

            // 마지막 남은 거 처리
            //System.out.println("마지막 남은 거 처리");
            if (count == 1) {
                str.append(before).append(sb); // sb까지!!
            } else {
                str.append(count).append(before).append(sb); // sb까지!!
            }

            //System.out.println(str);

            // 최댓값
            if (str.length() < answer || answer == 0) {
                answer = str.length();
            }
            // 초기화
            str.setLength(0);
            sb.setLength(0); // 이거 빠뜨림
        }

        return answer;
    }
}

/*
2:52~3:03 초안 작성
3:06~3:19 왜 뒤끝이 안 들어오지?
3:29
총 풀이시간 약 30분

x개 단위로 잘라 압축했을 때 가장 짧은 문자열 길이
앞에서부터 정해진 길이만큼 잘라야 함

sb.delete(0, sb.length() - 1);
이걸로 삭제 안 되는 이유 정리하기

디버깅 했던 점
1. sb 초기화 메서드
2. 정해진 길이보다 짧은 마지막 잔처리 sb 안 붙여줬던 점
3. 다음 단계로 넘어갈 때 sb 초기화 안 해줬던 점

이를 방지할 수 있었던 방법은...
1. 변수명 더 명확히? sb -> tokenBox str -> resultStr
2. 실제 예시를 토대로 실제 실행 예시 흐름 메모하고 풀이 시작하기
*/
