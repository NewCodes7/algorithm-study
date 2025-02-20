class Solution {
    public String solution(String code) {
        String answer = "";
        
        char mode = '0';
        char[] arr = code.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (mode == '0') {
                if (arr[i] != '1' && i % 2 == 0) {
                    answer += arr[i];
                }
                if (arr[i] == '1') {
                    mode = '1';
                }
            } else {
                if (arr[i] != '1' && i % 2 == 1) {
                    answer += arr[i];
                } 
                if (arr[i] == '1') {
                    mode = '0';
                }
            }
        }
        
        if (answer.equals("")) {
            answer = "EMPTY";
        }
        
        return answer;
    }
}