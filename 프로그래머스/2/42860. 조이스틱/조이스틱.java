import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length() - 1;
        
        char[] nameChar = name.toCharArray();
        
        for (int i = 0; i < nameChar.length; i++) {
            answer += getDiff(nameChar[i]);
            
            index = i + 1;
            while (index < name.length() && nameChar[index] == 'A') {
                index++;
            }
            
            move = Math.min(move, i * 2 + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        
        return answer + move;
    }
    
    public static int getDiff(char c) {
        int diff = Math.min(c - 'A', ('Z' - 'A' + 1) - (c - 'A'));
        return diff;
    }
}