import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
            .map(str -> Integer.parseInt(str.substring(s, s + l)))
            .filter(str -> str > k)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
