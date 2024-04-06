import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        int left = 0;
        int right = values.length-1;

        int sum = values[left] + values[right];
        int minSum = Math.abs(sum);
        int[] answer = new int[] {values[left], values[right]};
        while (left < right) {
            if (sum == 0) {
                answer[0] = values[left];
                answer[1] = values[right];
                break;
            } else if (sum > 0) {
                if (minSum > sum) {
                    answer[0] = values[left];
                    answer[1] = values[right];
                    minSum = sum;
                }
                right--;
            } else {
                if (minSum > Math.abs(sum)) {
                    answer[0] = values[left];
                    answer[1] = values[right];
                    minSum = Math.abs(sum);
                }
                left++;
            }

            sum = values[left] + values[right];
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}

/*

정렬


 */