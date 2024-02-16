class Solution {
    private static String[][] keypad = { 
        {"1", "2", "3"},
        {"4", "5", "6"}, 
        {"7", "8", "9"}, 
        {"10", "0", "11"}
    };
    
    public static boolean isLeft(String s, String left, String right, String hand) {
        int[] sPoint = getPoint(s);
        int[] leftPoint = getPoint(left);
        int[] rightPoint = getPoint(right);
        int leftD = Math.abs(sPoint[0] - leftPoint[0]) + Math.abs(sPoint[1] - leftPoint[1]);
        int rightD = Math.abs(sPoint[0] - rightPoint[0]) + Math.abs(sPoint[1] - rightPoint[1]);
        if (leftD < rightD) {
            return true;
        } else if (leftD == rightD) {
            if (hand.equals("left")) return true;
        }
        return false;
    }
    
    public static int[] getPoint(String s) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j].equals(s)) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        String left = "10";
        String right = "11";
        
        for (int c : numbers) {
            String s = Integer.toString(c);
            if ("147".contains(s)) { // 정규표현식으로 처리하는 방법?
                sb.append("L");
                left = s;
            }
            if ("369".contains(s)) { // 정규표현식으로 처리하는 방법?
                sb.append("R");
                right = s;
            }
            if ("2580".contains(s)) {
                if (isLeft(s, left, right, hand)) {
                    sb.append("L");
                    left = s;
                } else {
                    sb.append("R");
                    right = s;
                }
            }
        }
        
        return sb.toString();

        /*
        왼손과 오른손의 위치를 저장해두어야 함. int
        [2580] -> if문 판단 
            거리계산 해야 함. <- 이 메서드는 따로 빼기
        */
    }
}