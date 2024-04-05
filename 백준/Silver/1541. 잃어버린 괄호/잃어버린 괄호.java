import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String expression = br.readLine();
        StringTokenizer st = new StringTokenizer(expression, "+-", true);

        String[] tokens = new String[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++) {
            tokens[i] = st.nextToken();
        }

        List<Integer> list = new ArrayList<>();
        int temp = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            if (tokens[i].equals("+")) {
                temp += Integer.parseInt(tokens[i + 1]);
            } else {
                list.add(temp);
                temp = Integer.parseInt(tokens[i + 1]);
            }
        }
        list.add(temp);

        int sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sum -= list.get(i);
        }

        System.out.println(sum);
//        System.out.println(list);
    }
}

/*
지나가다가 -가 있으면 이걸 최대한 활용해야 함.

+라면
    boolean +라면
        총합 더하기
    boolean -라면
        임시값 더하기
-라면
    boolean +라면
        임시값 더하기 시작하기
        boolean -로 바꾸기
    boolean -라면
        임시값 더한거 총합에서 모두 빼주기
        임시값 더하기 시작하기

결과적으로 보면 +끼리 모두 더해주면 될 듯.
 */