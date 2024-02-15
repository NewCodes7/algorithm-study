import java.io.*;
import java.util.*;

public class Main { // 클래스로 해봐도 될 듯.
    private static List<List<Integer>> list = new ArrayList<>();
    private static List<Integer> d1 = new ArrayList<>();
    private static List<Integer> d2 = new ArrayList<>();
    private static List<Integer> d3 = new ArrayList<>();
    private static List<Integer> d4 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list.add(new ArrayList<>());
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);

        for (int j = 1; j <= 4; j++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), ""); // 이거 왜 안 되는 거야?
            String[] c = br.readLine().split("");
            for (int i = 0; i < 8; i++) {
                list.get(j).add(Integer.parseInt(c[i]));
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int shift = Integer.parseInt(st.nextToken());

            // 체킹
            int[] shifts = getShifts(idx, shift);
            for (int j = 1; j <= 4; j++) {
                move(j, shifts[j]);
            }
        }

        System.out.println(getScore());
    }

    public static int getScore() { // 너무 급하게 함. 실수가 있는지도 몰랐네.
        int score = 0;
        for (int i = 1; i <= 4; i++) {
            if (list.get(i).get(0) == 1) {
                score += Math.pow(2, i-1);
            }
        }

        return score;
    }

    public static int[] getShifts(int idx, int shift) {
        int[] shifts = new int[5];
        int originalShift = shift;
        int originalIndex = idx;
        shifts[idx] = shift;

        while (true) {
            int prevIdx = idx - 1;
            if (prevIdx < 1) break;
            if (list.get(idx).get(6) != list.get(prevIdx).get(2)) {
                if (shift == 1) {
                    shift = -1;
                } else {
                    shift = 1;
                }
                shifts[prevIdx] = shift;
                idx = prevIdx;
            } else {
                break;
            }
        }

        shift = originalShift;
        idx = originalIndex;

        while (true) {
            int nextIdx = idx + 1;
            if (nextIdx > 4) break;
            if (list.get(idx).get(2) != list.get(nextIdx).get(6)) {
                if (shift == -1) {
                    shift = 1;
                } else {
                    shift = -1;
                }
                shifts[nextIdx] = shift;
                idx = nextIdx;
            } else {
                break;
            }
        }

        return shifts;
    }

    public static void move(int idx, int shift) {
        if (shift == 0) return;

        if (shift == 1) {
            list.get(idx).add(0, list.get(idx).get(7));
            list.get(idx).remove(8);
        }

        if (shift == -1) {
            list.get(idx).add(list.get(idx).get(0));
            list.get(idx).remove(0);
        }
    }

    // move 메서드 - 시계 방향, 반시계 방향 deque이용해서 구현
    // 같은극인지 다른극인지 확인하는 메서드 while
    // 12, 1, 2, 3, ... , 11 -> 시계방향 11, 12, 1, 2 ...
    // 점수 계산 메서드
    // dk.. 6번째에도 접근해야 해서.. 덱 어울리지 않았네.. 지금보다 더 세밀한 설계가 필요함..

}