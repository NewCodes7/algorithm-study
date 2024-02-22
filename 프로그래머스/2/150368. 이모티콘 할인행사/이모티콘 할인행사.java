import java.util.*;

class Solution {
    private static int[] result = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] sales = new int[emoticons.length];
        for (int i = 0; i < emoticons.length; i++) {
            sales[i] = 40;
        }
        
        back(users, emoticons, sales, 0);
        
        return result;
    }
    
    public static void back(int[][] users, int[] emoticons, int[] sales, int idx) {
        calculate(users, emoticons, sales);
        // System.out.println(Arrays.toString(sales));
        
        for (int i = idx; i < sales.length; i++) {
            if (sales[i] == 10) continue;
            
            sales[i] -= 10;
            
            back(users, emoticons, sales, i);
            
            sales[i] += 10;
        }
    }
    
    public static void calculate(int[][] users, int[] emoticons, int[] sales) {
        // users 반복문 - 이모티콘 반복
        // 이모티콘 할인된 가격 
        int[] temp = new int[2];
        
        for (int i = 0; i < users.length; i++) {
            int total = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if (sales[j] >= users[i][0]) { // 살게
                    total += emoticons[j] * (100 - sales[j]) / 100;
                }
            }
            
            if (total >= users[i][1]) {
                temp[0]++;
            } else {
                temp[1] += total;
            }
        }
        
        if (temp[0] == result[0]) {
            result[1] = Math.max(result[1], temp[1]);
        }
            
        if (temp[0] > result[0]) {
            result[0] = temp[0];
            result[1] = temp[1];
        }
        
        // System.out.println(Arrays.toString(temp));
    }
}

/*
9:03~

백트랙킹 - 이모티콘스
    순서는 필요 없음. 

4의 7제곱 = 2의 14제곱 16000 * 100 1600000 160만
*/