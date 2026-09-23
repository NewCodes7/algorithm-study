import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> list = new ArrayList<>();
        String[] answer = new String[plans.length];
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));

        Stack<String[]> stack = new Stack<>();
        String name = plans[0][0];
        int curr = convert(plans[0][1]);
        int duration = Integer.parseInt(plans[0][2]);
        int i = 1;

        while (i < plans.length) {
            String[] arr = plans[i];
            int time = convert(arr[1]);

            // 새로운 과제가 중간에 있다면
            if (time < curr + duration) {
                stack.push(new String[] {name, Integer.toString(curr + duration - time)});
                name = arr[0];
                curr = time;
                duration = Integer.parseInt(arr[2]);
                i++;
                continue;
            }

            // 새로운 과제가 끝마침에 있다면
            if (time == curr + duration) {
                list.add(name);
                name = arr[0];
                curr = time;
                duration = Integer.parseInt(arr[2]);
                i++;
                continue;
            }

            // 새로운 과제가 중간에 없다면
            // 멈춘 과제가 있다면
            if (!stack.isEmpty()) {
                list.add(name);
                String[] suspended = stack.pop();
                name = suspended[0];
                curr = curr + duration;
                duration = Integer.parseInt(suspended[1]);
                continue;
            }

            // 멈춘 과제가 없다면
            list.add(name);
            name = arr[0];
            curr = convert(arr[1]);
            duration = Integer.parseInt(arr[2]);
            i++;
        }

        // 잔처리 (더 이상 새로운 과제가 없다면 현재 넣고 stack에 있는 거 다 넣기)
        list.add(name);
        while (!stack.isEmpty()) {
            list.add(stack.pop()[0]);
        }

        for (int j = 0; j < answer.length; j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }

    private int convert(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}

/*
11:29~12:14 1개 틀림


선점

과제가 끝났을 때
새로운 과제 우선
최근에 멈춘 과제 우선

멈춘 과제들은 stack에 넣어두기
현재 과제들 시간순으로 정렬하기
하나씩 꺼내면서 판단하기
    이전 과제가 끝났는가?
        예 -> 그냥 시작
        아니오 -> stack에 임시저장해두고 새로운 것 시작
    새로운 과제가 중간에 끼어들었는가? <- 이건 설계할 때 생각하지 않았음...

피드백
1. 문자열 사전 비교 str1.compareTo(str2)
2. 설계할 때 최대한 분기 처리 최대한 꼼꼼하게!!
3. 주석으로 잘 구분해둔 건 좋았다.
*/
