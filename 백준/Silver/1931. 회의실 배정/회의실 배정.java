import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Meeting implements Comparable<Meeting> {
        private int startHour;
        private int endHour;

        public Meeting (int startHour, int endHour) {
            this.startHour = startHour;
            this.endHour = endHour;
        }

        public int getStartHour() {
            return startHour;
        }

        public int getEndHour() {
            return endHour;
        }

        @Override
        public int compareTo(Meeting other) {
            if (this.endHour == other.endHour) {
                return this.startHour - other.startHour;
            }

            return this.endHour - other.endHour;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int time = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            Meeting c = pq.poll();

            if (c.getStartHour() >= time) {
                answer++;
                time = c.getEndHour();
            }
        }

        System.out.println(answer);
    }
}

/*
기준시간을 +1초씩 하면서
    기준시간보다 끝나는 시간이 작거나 같은 회의들 고르기
    사용할 수 있는지 확인 (시작시간)

예외는 없을까? 없을 것 같아. 매번 확인하니.
부분 최적합

어떻게 저장?
우선순위 큐 + 객체

아 예외
7 7
6 7
이렇게 있으면 !
 */