class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (String c : myString.split("")) {
            sb.append(c.toLowerCase());
        }
        
        return sb.toString();
    }
}