import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;

        // gems 현황 파악하기
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(gems[i])) {
                map.put(gems[i], map.get(gems[i]) + 1);
            } else {
                map.put(gems[i], 1);
            }
        }

        // start 1일 때 조건 만족하는 end 찾기
        int start = 0;
        int end = 0;
        Map<String, Integer> curr = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (curr.containsKey(gems[i])) {
                curr.put(gems[i], curr.get(gems[i]) + 1);
            } else {
                curr.put(gems[i], 1);
            }
            if (curr.size() == map.size()) {
                end = i;
                break;
            }
        }

        // 투 포인터 시작
        int answerStart = start;
        int answerEnd = end;
        while (true) {
            while (curr.get(gems[start]) > 1 && start < end) {
                curr.put(gems[start], curr.get(gems[start]) - 1);
                start++;
            }

            // 정산
            if (end - start < answerEnd - answerStart) {
                answerStart = start;
                answerEnd = end;
            }

            // 다음을 위해 -> 다음을 위해 end 갱신 및 map 갱신
            end++;
            if (end == n) break;
            curr.put(gems[end], curr.get(gems[end]) + 1); // 이거 빼먹었음
        }

        return new int[] {answerStart + 1, answerEnd + 1}; // +1해서 내기
    }
}

/*
1933~2000
2037~2046
처음 아이디어대로 풀었더니 28점
~2049 마지막에 end에 해당하는 보석 맵에 넣는 거 빼먹어서 그랬음
총 39분 풀이

hash
몇 종류 있는지 파악
set
10만 -> 50,000,000,000
이중 반복문으로 풀 순 없음

소거해나가면서 풀기?
각 유형이 나오는 위치 기억하고 있기?

포인터 하나씩 이동하다가 하나밖에 없는 게 나오면 그 자리에서 멈춰야 함

일단 1부터 시작해서 최소한으로 완성하는 end 찾기
그 end에서 하나씩 늘리고 start 줄일 수 있는지 체크
    start 줄일 수 있으면 최대한 줄이기
    start 줄일 수 없으면 그대로 두기

이대로 하면 시간복잡도 괜찮을 듯. 최대한 줄이니까.
시간복잡도 계산해보긴 해야 할 듯
이런거 계산 요령?

구간 길이 == 종류 개수면 무조건임

피드백
1. 실전에서는 사소한 코드 한 줄 빼먹은 걸로 점수차가 70점도 날 수 있겠구나...
    연습할 때 돌리기 전에 항상 빼먹은 거 없는지 확인하자.
    주석으로 최대한 해당 코드 부분 무슨 역할인지 구체적으로 적자.
2. 처음에는 아이디어 되게 막막해보였는데, 직접 시행하면서 보다보니 보였음
    -> 풀이 아이디어 바로 안 떠올라도 직접 시행해보면서 아이디어 찾기
3. Map에 getOrDefault(key, defaultValue)라는 메서드가 있음.
    키가 있으면 저장된 값을, 키가 없으면 지정한 기본값을 반환함.
    curr.put(gems[i], curr.getOrDefault(gems[i], 0) + 1);
    -> containsKey로 분기하지 않고, 처음 나온 보석은 1로 넣고 기존 보석은 1 증가시킬 수 있음.
    getOrDefault는 조회만 하므로, 실제 저장 및 갱신은 put으로 해야 함.

*/
