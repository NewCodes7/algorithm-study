class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > queries[i][2] && temp > arr[j]) {
                    temp = arr[j];
                }
            }
            if (temp == Integer.MAX_VALUE) {
                temp = -1;
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}

/*
8:55 ~ 

이진탐색? 아니다. index 자르는 것 때문에 정렬 힘듦. 

아 arr 원소가 1백만이구나. 길이가 아니라 ㅋㅋ



*/