import java.util.*;
// 11:30 ~
// 3개일 때 [1,3], [1,2], [3,2], [1,3], + 2개일 때(3) ([2,1], [2,3], [1,3])
// 4개일 때 [1,2], [1,3], [2,3], [1,2], [3,1], [3,2], [1,2], [1,3] + 3개일 때(7)
// 4개일 때 해보니까 재귀인거 알겠네!!
// 재귀이면 상태, 종료조건, 점화식
// 상태: [[1, 2], [], []] 
// 종료조건: [[], [], [1, 2]]
// 점화식:
// 가장 작은 것 선택 -> 하노이(n) = 전처리과정(하노이(n-1)+1) + 하노이(n-1) 
// 전처리 과정은 이전 하노이에서 3과 2의 역할을 바꾼 것임. + [1, 3]
// 마지막 하노이(n-1)은 1과 2의 역할을 바꾼 것임.
class Solution {
    private static List<List<Integer>> result = new ArrayList<>();
    
    public static List<List<Integer>> hanoi() {
                // List<List<Integer>> copyResult = new ArrayList<>(result);
        List<List<Integer>> copyResult = new ArrayList<>();
        
        for (List<Integer> list : result) {
            List<Integer> copy = new ArrayList<>();
            for (int c : list) {
                copy.add(c);
            } // 안 리스트까지 카피해야ㅐㅎ.
            copyResult.add(copy);
        }
        
        for (List<Integer> list : result) {
            int from = list.get(0);
            int to = list.get(1);
            if (from == 3) {
                list.set(0, 2);
            }
            if (from == 2) {
                list.set(0, 3);
            }
            if (to == 3) {
                list.set(1, 2);
            }
            if (to == 2) {
                list.set(1, 3);
            }
        }
        
        result.add(Arrays.asList(1, 3));
        
        for (List<Integer> list : copyResult) {
            int from = list.get(0);
            int to = list.get(1);
            if (from == 1) {
                list.set(0, 2);
            }
            if (from == 2) {
                list.set(0, 1);
            }
            if (to == 1) {
                list.set(1, 2);
            }
            if (to == 2) {
                list.set(1, 1);
            }
        
            result.add(list);  
        }
        
        return result;
    }
    
    public int[][] solution(int n) {
        result.add(Arrays.asList(1, 2));
        result.add(Arrays.asList(1, 3));
        result.add(Arrays.asList(2, 3));
        
        for (int i = 2; i < n; i++) {
            hanoi();
        }
        
        int[][] answer = new int[result.size()][result.get(0).size()];
        
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                answer[i][j] = result.get(i).get(j);
            } 
        }
        
        return answer;
    } //출력 크기 초과 조심
}


// import java.util.*;
// // 11:30 ~
// // 3개일 때 [1,3], [1,2], [3,2], [1,3], + 2개일 때(3) ([2,1], [2,3], [1,3])
// // 4개일 때 [1,2], [1,3], [2,3], [1,2], [3,1], [3,2], [1,2], [1,3] + 3개일 때(7)
// // 4개일 때 해보니까 재귀인거 알겠네!!
// // 재귀이면 상태, 종료조건, 점화식
// // 상태: [[1, 2], [], []] 
// // 종료조건: [[], [], [1, 2]]
// // 점화식:
// // 가장 작은 것 선택 -> 하노이(n) = 전처리과정(하노이(n-1)+1) + 하노이(n-1) 
// // 전처리 과정은 이전 하노이에서 3과 2의 역할을 바꾼 것임. + [1, 3]
// // 마지막 하노이(n-1)은 1과 2의 역할을 바꾼 것임.
// class Solution {
//     private static List<List<Integer>> result = new ArrayList<>();
    
//     public static List<List<Integer>> hanoi(List<List<Integer>> result) {
//         for (List<Integer> list : result) {
//             int from = list.get(0);
//             int to = list.get(1);
//             if (from == 3) {
//                 list.set(0, 2);
//             }
//             if (from == 2) {
//                 list.set(0, 3);
//             }
//             if (to == 3) {
//                 list.set(1, 2);
//             }
//             if (to == 2) {
//                 list.set(1, 3);
//             }
//         }
        
        
//         // List<List<Integer>> copyResult = new ArrayList<>(result);
//         List<List<Integer>> copyResult = List.copyOf(result);
        
//         result.add(Arrays.asList(1, 3));
//             System.out.println(result);
        
//         for (List<Integer> list : copyResult) {
//             int from = list.get(0);
//             int to = list.get(1);
//             if (from == 1) {
//                 list.set(0, 2);
//             }
//             if (from == 2) {
//                 list.set(0, 1);
//             }
//             if (to == 1) {
//                 list.set(1, 2);
//             }
//             if (to == 2) {
//                 list.set(1, 1);
//             }
//             System.out.println(result);
            
//             result.add(list);
//             System.out.println(result);
            
//         }
        
//         return result;
//     }
    
//     public int[][] solution(int n) {
//         int[][] answer = {};
//         List<List<Integer>> result = new ArrayList<>();
//         result.add(Arrays.asList(1, 2));
//         result.add(Arrays.asList(1, 3));
//         result.add(Arrays.asList(2, 3));
        
//         for (int i = 2; i < 3; i++) {
//             result = hanoi(result);
//         }
        
//         System.out.println(result);
        
//         return answer;
//     }
// }