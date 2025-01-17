import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        List<Integer> q = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.length() == 1) { // length()
                int result = 0;
                if (input.equals("2")) {
                    result = process2(q);
                } else if (input.equals("3")) {
                    result = process3(q);
                } else if (input.equals("4")) {
                    result = process4(q);
                } else if (input.equals("5")) {
                    result = process5(q);
                }
                sb.append(result).append("\n");
            } else {
                String[] arr = input.split(" "); // 더 나은 방법? 
                process1(q, Integer.parseInt(arr[1]));
            }
        }

        System.out.println(sb);
    }

    private static void process1(List<Integer> q, int X) {
        q.add(X); // 이렇게 해도 되겠지 메모리 참조하니? 
    }

    private static int process2(List<Integer> q) {
        int size = q.size();
        if (size == 0) {
            return -1;
        } 

        int result = q.get(size - 1);
        q.remove(size - 1); // remove

        return result;
    }

    private static int process3(List<Integer> q) {
        return q.size();
    }

    private static int process4(List<Integer> q) {
        return q.isEmpty() ? 1 : 0;
    }

    private static int process5(List<Integer> q) {
        if (q.isEmpty()) {
            return -1;
        } 
        return q.get(q.size() - 1);
    }
}

/*
10:50 ~ 11:06 16분! 

1. parser
2. stack 
3. output

개선하기 그 테이블 둬서! 

4초 ㄷㄷ 개선이 필요하다!
 */