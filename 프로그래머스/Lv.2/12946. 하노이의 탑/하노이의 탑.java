import java.util.*;

class Solution {
    private void hanoi(int n, int from, int to, List<int[]> process) { // private
        if (n == 1) {
            process.add(new int[] {from, to});
            return; // 리턴의 쓰임새
        }
        
        int empty = 6 - from - to;
        
        hanoi(n-1, from, empty, process); // 점화식의 중요성
        hanoi(1, from, to, process);
        hanoi(n-1, empty, to, process); // 모든 함수가 리턴으로 향함.
    }
    
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]); // ? 타입 명시
    }
}