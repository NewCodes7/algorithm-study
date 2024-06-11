import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] maxNums = new int[N];
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			maxNums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			pushButton(nums.length - 1, maxNums, nums);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int c : nums) {
			sb.append(c);
		}
		
		System.out.println(sb);
	}
	
	private static void pushButton(int index, int[] maxNums, int[] nums) {
		if (nums[index] == maxNums[index]) {
			nums[index] = 0;
			
			if (index != 0) {
				pushButton(index - 1, maxNums, nums);
			}
		} else {
			nums[index]++;
		}
	}
}


/*
이해한 것 + 가장 왼쪽 자리 최대일 때 예외처리

값을 올릴 때는 항상 최댓값인지 확인하고 올려야 함. 이걸 재귀적으로 수행할 때도 있을 수 있음.

배열 2개 선언

자주 쓰이는 메서드 미리 적어두기!!!! 복붙 ㄱㄱ 복붙 안 되려나?
*/