import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Balloon {
        int num;
        int paper;

        public Balloon (int num, int paper) {
            this.num = num;
            this.paper = paper;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Balloon> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (list.size() == 1) {
                sb.append(list.get(0).num);
                break;
            }

            Balloon c = list.get(idx);
            sb.append(c.num + " ");
            list.remove(idx); // 3 2 2
            idx += c.paper; // 4 5 10
            if (c.paper > 0) idx -= 1; // 3 4 9

            if (idx > list.size()-1) {
                idx %= list.size(); // 0 1 0
            }

            if (idx < 0) { // -2
                idx %= list.size(); // -2
                // -1 -> list.size()-1
                // -2 -> list.size()-2
                if (idx < 0) {
                    idx += list.size(); // +2
                }
            }
        }

        System.out.println(sb);
    }

}

/*
2:13~

1번 풍선부터 시작 -> 1+적힌수

풍선의 번호를 기억해야 함.

터진 풍선은 삭제하지 않고 1001로 표현하는 게 나을 듯.

???배열과 리스트의 차이???

벌룬 객체를 만들어서 풍선 번호와 종이를 저장한다면??
 */
