import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minpq = new PriorityQueue<>();
        Queue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int n = Integer.parseInt(operation.substring(2));
                minpq.offer(n);
                maxpq.offer(n);
            } else if (!minpq.isEmpty() && operation.equals("D -1")) {
                maxpq.remove(minpq.poll());
            } else if (!maxpq.isEmpty() && operation.equals("D 1")) {
                minpq.remove(maxpq.poll());
            }
        }

        if (minpq.isEmpty() && maxpq.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxpq.poll(), minpq.poll()};
    }
}