import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // Map 저장
        HashMap<String, String> userList = new HashMap<>();
        List<String[]> userLog = new ArrayList<>();
        for (String rec : record) {
            StringTokenizer st = new StringTokenizer(rec);
            String command = st.nextToken();
            String userId = st.nextToken();
            
            if (!command.equals("Leave")) {
                String nickname = st.nextToken();
                userList.put(userId, nickname);
            }
            
            if (!command.equals("Change")) {
                userLog.add(new String[]{command, userId});
            }
        }
        
        // 출력 준비
        String[] answer = new String[userLog.size()];
        for (int i = 0; i < userLog.size(); i++) {
            String infor = "님이 나갔습니다.";
            
            if (userLog.get(i)[0].equals("Enter")) {
                infor = "님이 들어왔습니다.";
            }
            
            answer[i] = userList.get(userLog.get(i)[1]) + infor;
        }
        
        return answer;
    }
}

/*
맵 자료구조 활용

LinkedHashMap<id, nickname>


*/