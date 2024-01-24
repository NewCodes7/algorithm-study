import java.io.*;
import java.util.*;

class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[n]; // 배열 복사도 마찬가지로 깊은 복사 얕은 복사 있음.
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2);

        Map<Integer, Integer> map = new HashMap();
        int before = arr2[0];
        map.put(before, 0);
        for (int i = 1; i < n; i++) {
            int c = arr2[i];
            int cnt = map.get(before);

            if (c > before) {
                cnt++;
            }

            map.put(c, cnt);
            before = c;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.println(sb);
        // 배열 두개로 풀면 될듯. + result
        // 하나는 원본. 하나는 정렬. 정렬한 배열을 기준으로 for문 돌면서 +1씩 채워주기 (이것보다 커?)

        // 이중 반복문 때문에 시간초과한듯.
        // 각 숫자에 대한 정보를 저장해두고, 따로 result 반환해야 하나?
    }
}