class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();
        
        for (int[] query : queries) {
            int s = query[0];
            int j = query[1];
            
            char[] temp = new char[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (i < s) {
                    temp[i] = arr[i];
                } else if (i >= s && i <= j) {
                    temp[i] = arr[j - (i - s)];
                } else if (i > j) {
                    temp[i] = arr[i];
                }
            }
            
            arr = temp;
        }
        
        StringBuilder sb = new StringBuilder(new String(arr));
        
        return sb.toString();
    }
}