import java.util.*;

class Solution {
    private static boolean[] isChecked;
    
    public int[] solution(String s) {
        
        // 집합 분할하기
        StringTokenizer st = new StringTokenizer(s, "{}");
        int n = (st.countTokens() + 1) / 2;
        String[][] arr = new String[n][n];
        
        for (int i = 0; st.hasMoreTokens(); i++) {
            String token = st.nextToken();
            if (token.equals(",")) {
                i--;
                continue;
            }
            
            String[] arr2 = token.split(",");
            arr[i] = arr2;
        }
        
        Arrays.sort(arr, (a, b) -> {
            return a.length - b.length;
        }); // 어떻게 정렬하지? 우선순위 큐?
        // System.out.println(Arrays.deepToString(arr));
        
        isChecked = new boolean[100001];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int c = Integer.parseInt(arr[i][j]);
                if (!isChecked[c]) {
                    isChecked[c] = true;
                    answer[i] = c;
                }
            }
        }
        
        
        return answer;
    }
}

/*
1. 길이 별로 정렬

2. 하나씩 비교하며 수 넣기

차집합

어떻게 하면 효율적으로?
중복이 없으니 우선 모든 원소 구해보기 <- 순서를 결정지으면 됨

불리언 <- 이미 쓴 건 true로 

함수 분할도 리팩토링 때...!
*/