import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
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

    @Override
    public int compareTo(Point other) {
        if (other.x == this.x) {
            return this.y - other.y;
        }
        return this.x - other.x;
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

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Point c : list) {
            sb.append(c.getX() + " " + c.getY()).append("\n");
        }

        System.out.println(sb);
    }
}