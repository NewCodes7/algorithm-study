import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees)
            .map(s -> s.replaceAll("[^" + skill + "]", ""))
            .filter(skill::startsWith)
            .count();
    }
}