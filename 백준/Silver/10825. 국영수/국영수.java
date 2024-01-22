import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int korean;
    private int english;
    private int math;

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
    public int compareTo(Student other) {
        if (other.getKorean() > getKorean()) {
            return 1;
        }
        if (other.getKorean() == getKorean()) {
            if (other.getEnglish() > getEnglish()) {
                return -1;
            }
            if (other.getEnglish() == getEnglish()) {
                if (other.getMath() > getMath()) {
                    return 1;
                }
                if (other.getMath() == getMath()) {
                    return getName().compareTo(other.getName()); // 이름순 정렬만 체크하자
                }
                return -1; // 이거 빼먹어서 거꾸로됨 수학
            }
            return 1;
        }
        return -1;
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

        for (Student s : score) {
            System.out.println(s.getName());
        }

    }
}