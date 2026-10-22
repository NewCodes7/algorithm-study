import java.util.*;

// 학습용 개선안: 큐 삽입 전에 발견한 최소 시간을 기록.
// 사용자 원본은 DIJKSTRA_2026-10-22.java에 보존.
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = 0;
        int targetCop = 0;
        for (int[] problem : problems) {
            targetAlp = Math.max(targetAlp, problem[0]);
            targetCop = Math.max(targetCop, problem[1]);
        }

        int startAlp = Math.min(alp, targetAlp);
        int startCop = Math.min(cop, targetCop);
        int[][] dist = new int[targetAlp + 1][targetCop + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(state -> state[2]));
        dist[startAlp][startCop] = 0;
        pq.offer(new int[]{startAlp, startCop, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int a = current[0];
            int c = current[1];
            int time = current[2];
            if (time > dist[a][c]) {
                continue;
            }
            if (a == targetAlp && c == targetCop) {
                return time;
            }

            if (a < targetAlp && time + 1 < dist[a + 1][c]) {
                dist[a + 1][c] = time + 1;
                pq.offer(new int[]{a + 1, c, time + 1});
            }
            if (c < targetCop && time + 1 < dist[a][c + 1]) {
                dist[a][c + 1] = time + 1;
                pq.offer(new int[]{a, c + 1, time + 1});
            }
            for (int[] problem : problems) {
                if (a < problem[0] || c < problem[1]) {
                    continue;
                }
                int nextAlp = Math.min(targetAlp, a + problem[2]);
                int nextCop = Math.min(targetCop, c + problem[3]);
                int nextTime = time + problem[4];
                if (nextTime < dist[nextAlp][nextCop]) {
                    dist[nextAlp][nextCop] = nextTime;
                    pq.offer(new int[]{nextAlp, nextCop, nextTime});
                }
            }
        }
        return -1; // 문제 조건상 공부만으로도 도달하므로 실행되지 않음.
    }
}
