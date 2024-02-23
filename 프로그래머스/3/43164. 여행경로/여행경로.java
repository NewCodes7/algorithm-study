import java.util.ArrayList;
import java.util.Collections;
class Solution {
    static boolean[] visit;
    static ArrayList<String> list=new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        DFS(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        String[] temp = list.get(0).split(" ");
        return temp;
    }

    private static void DFS(int cnt, String icn, String word, String[][] tickets) {
        if (cnt == tickets.length) {

            list.add(word);

        }else{
            for (int i = 0; i < tickets.length; i++) {
                if (!visit[i] && tickets[i][0].equals(icn)) {
                    visit[i]=true;
                    DFS(cnt+1,tickets[i][1],word+" "+tickets[i][1],tickets);
                    visit[i]=false;
                }
            }
        }
    }
}