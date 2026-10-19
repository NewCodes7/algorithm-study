# 지게차와 크레인 — 최초 풀이 (2026-10-19)

- 문제: https://school.programmers.co.kr/learn/courses/30/lessons/388353
- **첫 풀이 원본**: 20:47~21:14 (27분), 10점 / 런타임 에러
- 재귀 기반 check()를 사용한 첫 시도. 아래 코드는 사용자가 제공한 최초 코드와 주석을 그대로 보존함(표시용 공백·줄바꿈만 정리).
- 추후 BFS로 변경한 코드는 [지게차와 크레인.java](./지게차와 크레인.java) 참고.

~~~java
import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        char[][] map = new char[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            char[] arr = storage[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j];
            }
        }

        for (int i = 0; i < requests.length; i++) {
            String request = requests[i];
            if (request.length() == 1) {
                findWithCar(map, request);
                // System.out.println(Arrays.deepToString(map));
            } else if (request.length() == 2) {
                findWithCrain(map, request);
                // System.out.println(Arrays.deepToString(map));
            }
        }

        // 개수 세기
        int answer = map.length * map[0].length;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'x') {
                    answer--;
                }
            }
        }

        return answer;
    }

    public void findWithCar(char[][] map, String request) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != request.charAt(0)) { // str to char -> charAt하면되네 한 글자니까
                    continue;
                }

                if (check(map, i, j)) {
                    map[i][j] = 't';
                    continue;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 't') {
                    map[i][j] = 'x';
                }
            }
        }
    }

    public void findWithCrain(char[][] map, String request) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == request.charAt(0)) {
                    map[i][j] = 'x';
                }
            }
        }
    }

    public boolean check(char[][] map, int i, int j) {
        if (i == 0 || j == 0 || i == map.length - 1 || j == map[0].length - 1) {
            return true;
        }

        if (map[i + 1][j] == 'x') {
            return check(map, i + 1, j);
        }
        if (map[i - 1][j] == 'x') {
            return check(map, i - 1, j);
        }
        if (map[i][j + 1] == 'x') {
            return check(map, i, j + 1);
        }
        if (map[i][j - 1] == 'x') {
            return check(map, i, j - 1);
        }

        return false;
    }
}

/*
20:47~

requests 순회
   하나면 지게차 -> 겉만 탐색
       완전탐색하면서 각 컨테이너 주변에 뚫린 게 있는지 확인 (아 이것도 주의해야 할 게 통하는 길이 있어야 함)
       뚫려 있는 건 소문자 x로 구분
   두개면 크레인 -> 완전탐색
순회하면서 x 개수 세기

50*50*100 -> 다 완전탐색한다 해도 시간복잡도 널널함

아 이거 주의해야 할 게 지게차 끌 때 처음ㅇ 끌 때 당시에만 접근이 가능한 것만 건드려야 해.
*/
~~~
