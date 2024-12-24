import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            int sum = elements[i];
            set.add(sum);
            for (int j = i + 1; j < i + n; j++) {
                sum += elements[j % n];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}

/*
7:05~
조합 

*/