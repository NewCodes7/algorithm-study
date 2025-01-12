import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 병합 정렬
        int[] result = mergeSort(arr);

        // 답 포맷
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        
        int middle = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int idx = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        while (leftIdx != left.length && rightIdx != right.length) {
            if (left[leftIdx] < right[rightIdx]) {
                result[idx++] = left[leftIdx++];
            } else {
                result[idx++] = right[rightIdx++];
            }
        }

        while (leftIdx != left.length) {
            result[idx++] = left[leftIdx++];
        }

        while (rightIdx != right.length) {
            result[idx++] = right[rightIdx++];
        }

        return result;
    }
}

/*
 * 다른 방법
 * 1. 버블 정렬 O
 * 2. 퀵 정렬 (같은 거 대응 + 더 효율적인 알고리즘 + 피봇 기준 + 학습 정리 )
 * 3. 머지 소트 정렬
 * 4. 삽입 정렬 
 */