import java.util.*;

class Solution {
    private static int zero = 0;
    private static int one = 0;
    
    public static void quad(int[][] array) {
        int c = array[0][0];
        boolean isFounded = true;
        
        for (int[] a : array) {
            for (int b : a) {
                if (b != c) {
                    isFounded = false;
                    break;
                }
            }
        }
        
        if (isFounded) { // 종료 조건
            if (c == 0) {
                zero++;
            } else {
                one++;
            }
        } else { // 압축 더 해야 하는 경우
            quad(make(array, 0, 0)); // 점화식
            quad(make(array, 0, 1));
            quad(make(array, 1, 0));
            quad(make(array, 1, 1));
        }
    }
    
    public static int[][] make(int[][] array, int ic, int jc) { // 상태 만들기
        int l = array.length / 2;
        int[][] a = new int[l][l];
        for (int i = 0 ; i < l; i++) {
            for (int j = 0; j < l; j++) {
                a[i][j] = array[i + l*ic][j + l*jc];
            }
        }
        return a;
    }
    
    public int[] solution(int[][] arr) {
        quad(arr);
        return new int[] {zero, one};
    }
}