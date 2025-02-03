import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> grade = Map.of(
            "A+",	4.5,
            "A0",	4.0,
            "B+",	3.5,
            "B0",	3.0,
            "C+",	2.5,
            "C0",	2.0,
            "D+",	1.5,
            "D0",	1.0,
            "F",	0.0
        );

        double totalScore = 0;
        int totalGrade = 0;
        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" "); // 구조분해할당있나? 

            if (input[2].equals("P")) continue;

            totalScore += Double.parseDouble(input[1]) * grade.get(input[2]);
            totalGrade += Double.parseDouble(input[1]);
        }

        System.out.println(Math.round(totalScore / totalGrade * 1000000.0) / 1000000.0);

    }
}
