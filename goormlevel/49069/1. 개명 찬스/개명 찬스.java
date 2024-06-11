import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] - arr[i + 1] > 0) {
				for (int j = i + 1; j < arr.length; j++) {
					sb.append(arr[j]);
				}
				break;
			} else {
				sb.append(arr[i]);
			}
		}
		
		System.out.println(sb);
	}
}

/*
abcdefghijklmn

1, 2, 3, ... 라 치면
뚝 떨어지는 순간, 이전 거를 삭제하면 됨
떨어지는 순간이 한 번이라도 없다면, 제일 마지막 거 삭제.
왼쪽에서부터 순회하면 되고, 떨어지는 순간 있다면 바로 삭제하고 리턴. 그게 제일 유리하기에 (사전 순이니 앞일 수록 유리)

char 순회
	앞 - 뒤 빼면서 양수인지 확인. 
		양수라면 앞 삭제
		음수라면 넘어가기
		0이라면 넘어가기 (결과적으로 그러함.. 얻는 이점이 없어서.)

*/