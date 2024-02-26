class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int d = 0;
        int p = 0;
        for(int i=n-1; i>=0; i--){
            d -= deliveries[i];
            p -= pickups[i];
            
            while(d < 0 || p < 0){ // 남은 cap으로 버틸때까지 버팀.
                d += cap;
                p += cap;
                answer += (i+1)*2; // 어디까지 가느냐가 중요하기에 이건 빨리 결정이 남.
            }
        }
        return answer;
    }
}