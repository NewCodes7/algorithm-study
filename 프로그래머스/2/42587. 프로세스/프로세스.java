import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(priorities[i]);
            list.add(priorities[i]);
        }
        
        Collections.sort(list);
        
        while (!q.isEmpty()) {
            int c = q.poll();
            if (c == list.get(list.size() - 1)) { // 나간 원소
                answer++;
                list.remove(list.size() - 1);
                if (location == 0) return answer;
                location--;
            } else { // 다시 들어온 원소
                q.offer(c);
                if (location == 0) location = q.size();
                location--;
            }
        }
        
        return answer;
    }
}


/*
꺼내기
max인지 확인
    맞다면 실행횟수 count++
    아니면 뒤로 삽입

max인지 확인하는 방법이 관건
시간효율은 문제 없을 듯 n제곱 10000

큐를 돌 수 있는 방법?? 있나?(큐 장점?)

큐 만들고 따로 순회하기?
list sort해두기 그리고 갱신될 때마다 이친구도 하나씩 삭제

큐, 리스트 담기
리스트 정렬

큐 뽑고 리스트max인지 확인 
    
*/