class Solution {
    public String solution(String my_string, int s, int e) {
        char[] arr = my_string.toCharArray();
        char[] answer = new char[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (i >= s && i <= e) {
                answer[e - (i - s)] = arr[i];
            } else {
                answer[i] = arr[i];
            }
        }
        
        return new String(answer);
    }
}