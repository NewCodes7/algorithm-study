import java.util.*;

class Solution {
    private static List<String> list = new ArrayList<>();
    private static Map<String, Integer> map = new HashMap<>();
    private static int max = 0;
    private static List<String> temp = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                if (orders[j].length() < course[i]) {
                    continue;
                }
                
                comb(orders[j].split(""), course[i], 0, 0, new String[course[i]]);
            }
            
            // 바깥에 있어야 함
            if (!temp.isEmpty()) {
                for (String s : temp) {
                    list.add(s);
                }
            }
            temp.clear();
            max = 0;
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void comb(String[] order, int count, int depth, int idx, String[] arr) {
        if (depth == count) {
            String[] arr2 = arr.clone();
            Arrays.sort(arr2); // 아.. 여기때문에!!! 순서가 바뀜...!
            String s = toString(arr2);
            
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                int cnt = map.get(s);

                if (cnt > max) {
                    max = cnt;
                    temp.clear();
                    temp.add(s);
                }
                
                if (cnt == max) {
                    if (!temp.contains(s)) { // 효율 향상 가능
                        temp.add(s);
                    }
                }
                
                map.put(s, cnt+1);
            }

            return;
        }
        
        for (int i = idx; i < order.length; i++) {
            arr[depth] = order[i];
            comb(order, count, depth+1, i+1, arr);
        }
    }
    
    public static String toString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
    
}


/*
2:50~3:13 / 6분동안 sql 검토 3:19 ~ 4:00
조건: 최소 2명이상 손님, 가장 함께 많이 주문된

course를 기준으로 탐색해야 할 듯.
    2개 찾는다면, orders 돌면서 2개 조합 저장하기 map?

courses 반복문
    orders 반복문
        조합 - order
            애초에 길이가 안된다면 리턴
            개수 채워질 때마다 map에 저장
                map 없다면 put
                map 있다면 get후 ++
    map 순회하면서 가장 많이 뽑힌 것 추출 - 사전순 정렬 
    map clear
사전순 정렬 후 리턴
    
시간 줄이려면, 한번에 map에 저장?
    
    
정밀하게 검증했다면 의심하지 않았음
*/