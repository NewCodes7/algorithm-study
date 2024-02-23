import java.util.*;

class Solution {
    private static long total = 0;
    private static long a = 0;
    private static long b = 0;
    private static int cnt = 0;
    
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            total += queue1[i] + queue2[i];
            a += queue1[i];
            b += queue2[i];
        }
        
        if (total % 2 == 1) return -1;
        
        // System.out.println(total);
        process(q1, q2, queue1, queue2);
        
        return cnt;
    }
    
    public static void process(Queue<Integer> q1, Queue<Integer> q2, int[] queue1, int[] queue2) {
        while (a != b) {
            cnt++;
            
            if (a > b) {
                int c = q1.poll();
                q2.offer(c);
                a -= c;
                b += c;
            } else if (a < b) {
                int c = q2.poll();
                q1.offer(c);
                a += c;
                b -= c;
            }
            
            if (q1.isEmpty() || q2.isEmpty()) { // 이것말고도 안 되는 경우?
                cnt = -1;
                System.out.println(12);
                break;
            }
            
            if (cnt > queue1.length*3) { // q1이 아니라 q2랑 같아질때 하면 더 먼저 점검 가능!!
                cnt = -1;
                break;
            }
            
            // if (isSame(queue2, q1)) { // q1이 아니라 q2랑 같아질때 하면 더 먼저 점검 가능!!
            //     cnt = -1;
            //     break;
            // }
        }
    
    }
    
    public static boolean isSame(int[] arr, Queue<Integer> q) {
        if (arr.length != q.size()) return false;
   
        List<Integer> list = new ArrayList<>(q); // good
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != list.get(i)) return false;
        }
        
        return true;
    }
}

/*
2:48~3:13 25분
3:36 검토완료 18분 검토
-1인 경우
    총합이 홀수일 때
    하나의 큐가 비었을 때
    무한루프 <- 어떻게 검거?
        원래 배열로 돌아왔을 때, 근데 중복 허용이라 오류있을수도..?
            중복이어서 다시 돌아왔는데 다시 했더니 됐을 경우? ! 다시 돌 수밖에 !! 똑같은 규칙으로 가니!
            아.. 근데 개수 같게 주어진다 했잖아. (그래도 상관없긴 함. 그래도 문제 조건 더 민감하게)

1,000,000,000 10억
long 쓰기. (합 할 때만)

모든합 / 2
완탐? 

1 -> 2
2 -> 1

안 되면 -1 리턴

더 큰 쪽에서 넘겨주기. 이거 계속 반복하다보면?
그런데 한번 자기자신한테 하고 그 다음거를 2에게 넘겨줄 수도 있는 것임.
아. 문제에서 정해짐. 다른 큐에 집어넣어야 해. 

그리디? 
1 2 3
4 5 6

시간 초과 어떻게? 
*/