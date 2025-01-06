class Solution {
    public String solution(int age) {
        String ageStr = Integer.toString(age);
        char[] answer = new char[ageStr.length()];
    
        
        for (int i = 0; i < ageStr.length(); i++) {
            answer[i] = (char) ('a' + (ageStr.charAt(i) - '0'));
        }
        
        return new String(answer);
    }
}

/*
12:43 ~ 

1. a ~ j 숫자랑 매핑해두고, age 하나씩 순회하면서 변환
2. 매핑할 필요없이 아스키 값 이용해서, age 하나씩 순회하면서 반환 

age 하나씩 순회 
    


*/