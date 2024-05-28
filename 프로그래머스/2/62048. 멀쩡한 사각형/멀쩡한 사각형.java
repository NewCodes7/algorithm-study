class Solution {
    public long solution(int w, int h) {
        int gcd = getGCD(w, h);
        // System.out.println(gcd);
        
        long answer = (long) w * h;
        long nonUsed = (w / gcd + h / gcd - 1) * gcd;
        answer -= nonUsed;
        
        return answer;
    }
    
    public static int getGCD(int w, int h) {
        int min = Math.min(w, h);
        int gcd = 1;
        
        for (int i = 1; i <= min; i++) {
            if (w % i == 0 && h % i == 0) {
                gcd = i;
            }
        }
        
        return gcd;
    }
}

/*
To do list
1. 최대 공약수 직접 구현
2. 유클리드 호제법 사용
3. 처음 풀이 안 된 이유 분석
4. 피드백
5. 서술형 - 왜 gcd가 관건인지 서술
*/