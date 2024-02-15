import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        List<Integer> answer = new ArrayList<>();
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) score[0]++;
            if (answers[i] == student2[i % student2.length]) score[1]++;
            if (answers[i] == student3[i % student3.length]) score[2]++;
        }
        
        int max = Arrays.stream(score).max().getAsInt();
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}