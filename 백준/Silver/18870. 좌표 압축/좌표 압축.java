import java.io.*;
import java.util.*;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            copy[i] = arr[i];
        }

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                idx++;
            }
            map.put(arr[i], idx);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(copy[i])).append(" ");
        }

        System.out.println(sb);
    }
}

/*
4:58~

sort

반복문
    이전것보다 더 크면 idx++
    현재 원소, 현재 idx map에 저장

반복문
    순서대로 맵에서 값 가져오기
 */