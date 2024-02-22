import java.util.*;

class Solution {
    private static int m, n, start, end;
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        m = key.length;
        n = lock.length;
        start = m-1;
        end = m-1+n;
        
        int[][] map = new int[n+2*(m-1)][n+2*(m-1)];
        for (int i = m-1; i < m-1+n; i++) {
            for (int j = m-1; j < m-1+n; j++) {
                map[i][j] = lock[i-m+1][j-m+1];
            }
        }
        
        int k = map.length;
        // int[][] clone = map.clone(); 2차원 배열 복사 주의!
        
        for (int a = 0; a < n+m-1; a++) {
            for (int b = 0; b < n+m-1; b++) {
                
                for (int q = 0; q < 4; q++) {
                    int[][] clone = cloneArr(map, k);
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            clone[i+a][j+b] += key[i][j]; // 여기에 조작하면 될 듯.
                        }
                    }
                    
                    if (isOpened(clone)) {
                        return true;
                    }

                    key = spinArr(key);
                }    
                
            }
        }
        
        return false;
    }
    
    public static int[][] cloneArr(int[][] map, int k) {
        int[][] clone = new int[k][k];
        for (int i = 0; i < k; i++) {
            clone[i] = map[i].clone();            
        }
        
        return clone;
    }
    
    public static boolean isOpened(int[][] clone) {
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if (clone[i][j] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static int[][] spinArr(int[][] arr) {
        int[][] arr2 = new int[arr.length][arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr2[j][arr.length-1 - i] = arr[i][j];
            }
        }
        
        return arr2;
        
    }
}


/*
4:00~
정확히 들어맞아야 함. 

완전탐색?
다 더해보면서 온전히 1일 때만 조건 성립

0, 90, 180, 270 회전
벗어나기 전까지 이중반복문


수면, 흐리멍텅, 집중력

*/