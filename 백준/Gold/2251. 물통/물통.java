import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[][][] visited;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] bucket = new int[3];
        for (int i = 0; i < 3; i++) {
            bucket[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[bucket[0]+1][bucket[1]+1][bucket[2]+1];

        bfs(bucket, new int[]{0, 0, bucket[2]});

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int c : answer) {
            sb.append(c).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int[] bucket, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        visited[start[0]][start[1]][start[2]] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int[] c = q.poll();

            if (c[0] == 0) {
                answer.add(c[2]);
            }

            // i -> j
            for (int i = 0; i < 3; i++) {
                for (int j = i+1; j < 3; j++) {
                    int[] next = c.clone();

                    if (bucket[j] >= c[i]+c[j]) {
                        next[j] += next[i];
                        next[i] = 0;
                    } else {
                        next[i] -= bucket[j] - next[j];
                        next[j] = bucket[j];
                    }
                    if (!visited[next[0]][next[1]][next[2]]) {
                        q.offer(next);
                        visited[next[0]][next[1]][next[2]] = true;
                    }

                }
            }

            // j -> i
            for (int i = 0; i < 3; i++) {
                for (int j = i+1; j < 3; j++) {
                    int[] next = c.clone();

                    if (bucket[i] >= c[i]+c[j]) {
                        next[i] += next[j];
                        next[j] = 0;
                    } else {
                        next[j] -= bucket[i] - next[i];
                        next[i] = bucket[i];
                    }
                    if (!visited[next[0]][next[1]][next[2]]) {
                        q.offer(next);
                        visited[next[0]][next[1]][next[2]] = true;
                    }

                }
            }
        }
    }
}