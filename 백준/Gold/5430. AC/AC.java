import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        int t = Integer.parseInt(br.readLine()); // 테스트의 개수
        for (int i = 0; i < t; i++) {
            String p = br.readLine(); // 함수
            int n = Integer.parseInt(br.readLine()); // 배열 원소 개수
//            String temp = br.readLine();
//
//            Deque<Integer> q = new ArrayDeque<>();
//            if (n != 0) {
//                String[] arr = temp.substring(1, temp.length() - 1).split(",");
//                for (int j = 0; j < arr.length; j++) {
//                    q.offer(Integer.parseInt(arr[j]));
//                }

            String temp = br.readLine();
            String[] arr = temp.substring(1, temp.length() - 1).split(",");

            Deque<Integer> q = new ArrayDeque<>();
            if (!arr[0].isEmpty()) {
                for (int j = 0; j < arr.length; j++) {
                    q.offer(Integer.parseInt(arr[j]));
                }
            }

            sb.append(AC(p, q)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static String AC(String p, Deque<Integer> q) {
        boolean isReversed = false;

        for (char operand : p.toCharArray()) {
            if (operand == 'R') {
                if (isReversed) {
                    isReversed = false;
                } else {
                    isReversed = true;
                }
            } else if (operand == 'D') {
                if (q.isEmpty()) {
                    return "error";
                }

                if (isReversed) {
                    q.pollLast();
                } else {
                    q.pollFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            if (isReversed) {
                sb.append(q.pollLast());
            } else {
                sb.append(q.pollFirst());
            }
            sb.append(",");
        }
        if (sb.length() > 1) { // 이거 감싸줘야 해!!
            sb.deleteCharAt(sb.length() - 1);
        }

        return "[" + sb.toString() + "]";
    }
}

/*
R - 뒤집기
D - 첫 번째 수 버리기 (배열 비어있다면 에러)

검색
문자열 자르기, 배열 뒤집기, sb 마지막 문자 삭제, sb 뒤집기

큐를 활용해도 됐었겠네..

1. 시간 초과..
n * p -> 1억 초

아 배열을 바꾸는 게 아니라
포인터를 따로 두면 됨. 삭제 포인터 !
그리고 마지막에 포인터가 뒤에 가 있으면 그때 뒤집어 주면 됨.

2. 스트링 인덱스 에러..
-> R []일 때 감싸주지 않아서

3. 틀렸습니다?
-> 엣지케이스가 있나보다. 내 방식에 대한 문제점?
-> 52분째 안 풀리니.. 블로그 검색해봄
블로그 봐도 안 보이네. 실수가..
*/