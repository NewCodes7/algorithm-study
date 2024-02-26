import java.util.*;

class Solution {
    private static boolean[] visited;
        
    private static class Node {
        String word;
        int cost;
        
        Node(String word, int cost) {
            this.word = word;
            this.cost = cost;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        return bfs(begin, target, words);
    }
    
    public static int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.word.equals(target)) return c.cost;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (check(c.word, words[i])) {
                    q.offer(new Node(words[i], c.cost + 1));
                    visited[i] = true;
                } 
            }
        }
        
        return 0;
    }
    
    public static boolean check(String s, String c) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = c.toCharArray();
        
        if (arr1.length != arr2.length) {
            return false;
        }
        
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                cnt++;
                if (cnt > 1) return false;
            }
        }
        
        if (cnt == 1) {
            return true;
        } else {
            return false;
        }
    }
}

// bfs로 고고 (이전에는 dfs로 품.)

/*
check 함수 두 단어 제공 

*/