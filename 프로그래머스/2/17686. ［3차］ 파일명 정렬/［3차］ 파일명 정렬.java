import java.util.*;

class Solution {
    static class File {
        private int order;
        private String name;
        private String head;
        private int number;
        
        public File(int order, String name, String head, int number) {
            this.order = order;
            this.name = name;
            this.head = head;
            this.number = number;
        }
        
        public int getOrder() {
            return order;            
        }
        
        public String getName() {
            return name;            
        }
        
        public String getHead() {
            return head;            
        }
        
        public int getNumber() {
            return number;            
        }
    }
    
    public String[] solution(String[] files) {
        
        List<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            char[] arr = files[i].toCharArray();
            
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (Character.isDigit(arr[j])) {
                    number.append(arr[j]);
                    if (j != arr.length - 1 && !Character.isDigit(arr[j+1])) {
                        break;
                    }  
                } else {
                    head.append(arr[j]);
                }
            }
            
            list.add(new File(i, files[i], head.toString(), Integer.parseInt(number.toString())));
            // System.out.println(head.toString() + " " + number.toString());
        }

        Collections.sort(list, (a, b) -> {
            if (a.getHead().toLowerCase().compareTo(b.getHead().toLowerCase()) == 0) {
                if (a.getNumber() == b.getNumber()) {
                    return a.getOrder() - b.getOrder();
                }
                return a.getNumber() - b.getNumber();
            }
            
            return a.getHead().toLowerCase().compareTo(b.getHead().toLowerCase());
        });
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getName();
        }
        
        return answer;
    }
}


/*
예외: 테일에서 바로 숫자가 나오는 경우는..?
애초에 넘버에서 연속된 숫자라고 정의함. 음... 

일단 쪼개야 함. 
클래스 만들어도 될 듯. 

문자인지 숫자인지 어떻게 구분? Character.isDigit()

쪼개기 -> 

*/