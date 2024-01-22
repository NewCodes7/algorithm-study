import java.io.*;
import java.util.*;

class Student implements Comparable<Student> { // Comparator과의 차이점?
    private final String name;
    private final int korean;
    private final int english;
    private final int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }

    @Override
    public int compareTo(Student other) { // 양수 반환이면 매개변수 사전순으로 other가 먼저 표시됨.
        if (other.getKorean() == getKorean()) {
            if (other.getEnglish() == getEnglish()) {
                if (other.getMath() == getMath()) {
                    return getName().compareTo(other.getName()); // 이름순 정렬
                }
                return other.getMath() - getMath();
            }
            return getEnglish() - other.getEnglish();
        }
        return other.getKorean() - getKorean();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Student> score = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            Student student = new Student(name, korean, english, math);

            score.add(student);
        }

        Collections.sort(score);

        StringBuilder sb = new StringBuilder();
        for (Student s : score) {
            sb.append(s.getName()).append("\n");
        }

        System.out.println(sb);
    }
}