class Solution {
    public long solution(int w, int h) {
        int gcd = getGCD(w, h);
        long nonUsed = (w / gcd + h / gcd - 1) * gcd;
        long answer = (long) w * h - nonUsed;
        
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