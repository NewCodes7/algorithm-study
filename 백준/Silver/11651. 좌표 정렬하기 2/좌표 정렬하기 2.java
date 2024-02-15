import java.io.*;
import java.util.*;

class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(point);
        }

        Collections.sort(list, (e1, e2) -> {
            if (e1.getY() == e2.getY()) {
                return e1.getX() - e2.getX();
            }
            return e1.getY() - e2.getY();
        });

        StringBuilder sb = new StringBuilder();
        for (Point c : list) {
            sb.append(c.getX() + " " + c.getY()).append("\n");
        }

        System.out.println(sb);
    }
}