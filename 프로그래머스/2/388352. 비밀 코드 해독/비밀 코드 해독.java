import java.util.*;

class Solution {
    private int n;
    private int[][] q;
    private int[] ans;
    private Set<String> set = new HashSet<>();

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans; // this 붙이기!!

        Stack<Integer> stack = new Stack<>();
        combination(stack, 0, 1, 0);

        return set.size();
    }

    private void combination(Stack<Integer> curr, int idx, int depth, int cnt) {
        if (curr.size() == 5) {
            // System.out.println(curr);
            check(curr, idx);
            return;
        }

        for (int i = depth; i <= n; i++) {
            curr.push(i);
            combination(curr, idx, i + 1, cnt + 1); // depth + 1이 아니라 i + 1
            curr.pop();
        }
    }

    private void check(Stack<Integer> curr, int idx) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < q[i].length; j++) {
                if (curr.contains(q[i][j])) {
                    cnt++;
                }
            }
            if (cnt != ans[i]) {
                return;
            }
        }

        Integer[] temp = new Integer[5]; // int라 하면 Arrays.sort 안 됨
        for (int i = 0; i < 5; i++) {
            temp[i] = curr.get(i); // stack get도 되는군
        }
        Arrays.sort(temp, (a, b) -> a - b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(temp[i] + ",");
        }
        if (!set.contains(sb.toString())) {
            set.add(sb.toString());
        }
    }
}

/*
1844~1855 11m

1911~2000 49m

n 30
10 * 5 = 50

한 q에서 경우의 수 최대 10개
10의 10제곱
10,000,000,000
그런데 5개가 되는 순간 경우의 수가 끝나니
그렇게 많아지진 않을 듯
조합으로 가도 될 듯

q 순회
    if 5개라면
        다음 q들 순회하면서 맞는지 확인
        return;
    q 내에서 for
        ans 개수만큼 조합으로 고르기 || 5개 찰 때 스톱
        재귀호출

피드백
1. 너무 많이 예제 테스트케이스에 의존하는 경향이 있음 이거 틀린 걸로 많이 잡아냄...
2. 주어진 입출력 예, 만든 예외적인 예로 최대한 직접 시행해보면서 문제 정밀하게 이해해서 설계에 녹여내자.
3. this!!
4. Arrays.sort 하려면 Integer[]처럼 wrapper 클래스로!
5. stack.get(i)로 접근 가능.

아!!! 꼭 q에서 골라야되는 건 아니다! q에 없는 숫자가 나와도 된다...
그냥 15c5해도... 15 14 13 12 11 괜찮다.
와 이거 처음 잘못 생각한 게 ...
하면서 만드는 건 리스크가 크네

<문제 풀기 전 설계 단계>
역시 설계에 투자를 많이 해야 하는 건 맞다...
입출력 예도 최대한 꼼꼼하게 보고, 예외적인 입출력 예도 만들어서 직접 하나하나 시행해보고...
그래도 틀은 똑같아서 바꾸니 금방 됐다.

*/
