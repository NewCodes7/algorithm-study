import java.util.stream.Stream;

class Solution {
    public int[] solution(long n) {
        String m = new StringBuffer(n+"").reverse().toString();
        return  Stream.of(m.split("")).mapToInt(Integer::parseInt).toArray();
    }
}