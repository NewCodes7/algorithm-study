import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int[] vst = new int[words.length];
        Queue<Integer> queue = new LinkedList<>();

        for ( int i = 0; i < words.length; i++ ) {
            if ( vst[i] == 0 && diff(begin, words[i]) ) {
                queue.offer(i);
                vst[i] = 1;
            }
        }

        while ( !queue.isEmpty() ) {
            int curIdx = queue.poll();
            String curStr = words[curIdx];

            if ( curStr.equals(target) )
                return vst[curIdx];

            for ( int j = 0; j < words.length; j++ ) {
                if ( vst[j] == 0 && diff( curStr, words[j] ) ) {
                    queue.offer(j);
                    vst[j] = vst[curIdx] + 1;
                }
            }
        }

        return 0;
    }

    private boolean diff(String str1, String str2) {
        int diff = 0;

        for ( int i = 0; i < str1.length(); i++ ) {
            if ( str1.charAt(i) != str2.charAt(i) )
                diff++;
            if ( diff > 1 )
                return false;
        }

        return diff==1;
    }
}
