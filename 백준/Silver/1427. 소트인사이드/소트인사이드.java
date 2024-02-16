import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String strN = Integer.toString(n);

        String[] arr = strN.split("");

        Arrays.sort(arr, Collections.reverseOrder()); // 기본 자료형 안 되나보다. 우선 Int 스플릿하는 방법 알아보기

        StringBuilder sb = new StringBuilder();
        for (String c : arr) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}