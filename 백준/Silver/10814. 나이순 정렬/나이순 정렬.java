import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static class User {
        public String name;
        public Integer age;
        public Integer id;

        public User(String name, Integer age, Integer id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<User> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new User(name, age, i));
        }

        Collections.sort(list, (a, b) -> {
            if (a.age != b.age) {
                return a.age - b.age;
            }

            return a.id - b.id;
        });

        StringBuilder sb = new StringBuilder();
        sb.append(
            list.stream()
            .map(user -> user.age.toString() + " " + user.name)
            .collect(Collectors.joining("\n"))
        );
        System.out.println(sb);
    }
}