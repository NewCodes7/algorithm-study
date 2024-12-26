class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        answer[0] = (int) Math.max(left % n, left / n) + 1;

        for (long i = left + 1; i <= right; i++) {
            answer[(int) (i - left)] = (int) Math.max(i % n, i / n) + 1;
        }
        
        return answer;
    }
}

/*
10:14 ~ 10:30 
10:44 ~ 

0 1 2 3 4

1 2 3 4 5
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8 
5 6 7 8 9

1 2 3 4 
2 2 3 4
3 3 3 4 
4 4 4 4 

left = 7

left % n

Math.max(left % n, left / n) + 1


아 문제를 잘못 이해함... ;; 

left에 있는 숫자 구하는 공식 
1 + left / n + left % n

left = 7, n = 4

1 + 7 / 4 + 7%4
1 + 1 + 3

if ((현재 숫자 + 1) % n == 0) {
    마이너스 해야 되는 순간 
}

2 - n

*/