class Solution {
    private int[] arr;
    
    public long solution(int n) {
        arr = new int[n + 1];
        arr[1] = 1;
        if (n < 2) {
            return arr[n];
        }
        arr[2] = 2;
        
        dp(n, 3);
        
        return arr[n];
    }
    
    private void dp(int n, int curr) {
        if (curr > n) {
            return;
        }
        
        arr[curr] = (arr[curr - 1] + arr[curr - 2]) % 1234567;
        dp(n, curr + 1);
    }
}

/*
8:48~

백트랙킹 완전탐색
if (depth == 4) {

}

i = 1 i <= 2

DP를 써야 하나.. 
1 1
2 2
3 3 2
4 5 4
5 8 7
6 13 12

n = n-1 + n-2

*/