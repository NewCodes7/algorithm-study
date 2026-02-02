import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b)
        );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (heap.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(heap.poll()).append("\n");
            } else {
                heap.offer(num);
            }
        }

        System.out.println(sb);
    }
}

/*
PriorityQueue에서 Comparator만 바꾸면 될 것 같은데 

1. comparator 지정
2. 0이면 꺼내기 
3. 0이 아니면 삽입 (삽입시 1에서 지정한 거에 따라 저장)

*/