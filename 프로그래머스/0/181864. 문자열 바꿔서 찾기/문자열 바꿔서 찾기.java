class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : myString.toCharArray()) {
            if (c == 'A') {
                sb.append('B');
            } else if (c == 'B') {
                sb.append('A');
            }
        }
        
        if (sb.toString().contains(pat)) {
            answer = 1;
        }
        
        return answer;
    }
}