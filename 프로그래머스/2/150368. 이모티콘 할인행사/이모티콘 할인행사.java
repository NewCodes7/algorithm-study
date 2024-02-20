import java.util.*;

class Solution {
    private static int[] emoSale;
    private static int[] sale = {10, 20, 30, 40};
    private static int[] result = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        emoSale = new int[emoticons.length];
        back(users, emoticons, 0);
        return result;
    }
    
    public static void back(int[][] users, int[] emoticons, int depth) {
        if (depth == emoSale.length) {
            calculate(users, emoticons);
            // System.out.println(Arrays.toString(emoSale));
            // 계산 수행
            return;
        }
        
        for (int i = 0; i < sale.length; i++) {
            emoSale[depth] = sale[i];
            back(users, emoticons, depth+1);
            // 복구할 필요 없음 알아서 바뀜.
        }
    }
    
    public static void calculate(int[][] users, int[] emoticons) {
        int[] rst = new int[2];
        for (int i = 0; i < users.length; i++) {
            int price = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if (users[i][0] <= emoSale[j]) {
                    price += emoticons[j] * (100 - emoSale[j]) / 100;
                }
            }
            if (price >= users[i][1]) { // 이모티콘 플러스 구입
                rst[0]++;
            } else {
                rst[1] += price;
            }
        }
        
        if (rst[0] > result[0]) {
            result[0] = rst[0];
            result[1] = rst[1];
        }
        if (rst[0] == result[0] && rst[1] > result[1]) {
            result[0] = rst[0];
            result[1] = rst[1];
        }

    }
}

/*
할인율은 4가지 중의 하나로 결정 그러면 완탐?  
ㄴㄴ 이모티콘마다 다를 수 있음. 이모티콘은 최대 7개 (2의14제곱 = 16000) 완탐 가능도 할 듯.
10, 20, 30, 40 
index로 관리.
0, 0, 0, 0 -> 1, 0, 0, 0 -> 2000 -> 3000 -> 4000 -> 3100

메서드
    1. back -> 설계할 때 종료 조건, 반복문, depth, 복구 설계하고 들어가자.
        종료 조건: 임티 하나라도 4가 된다면. 종료 조건 잡기가 어렵네..
        왜 depth가 안에 있으면 제대로 작동하지 않지?
        반복문에서 emoticon을 기준으로 도는 게 아니라 
        할인율을 기준으로 하면, depth를 index로 잡을 수 있음. 그리고 종료조건을 index 넘어가기 전
        depth를 배열의 Index로 잡을 수도 있네..
    2. 결과 산출
        이모티콘 가격 할인
        각 사용자 순회
            사용자가 사는 이모티콘 선택 -> 합산 -> 판단 -> 저장 if Math.max로 ㄱㄱ
*/