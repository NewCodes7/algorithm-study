import java.util.*;

class Solution {
    private static int[] fee;
    
    private class Car implements Comparable<Car> {
        private int id;
        private int inTime;
        private int outTime = 23 * 60 + 59;
        private int time = 0;
        private int price = 0;
        
        public Car(int id, int inTime) {
            this.id = id;
            this.inTime = inTime;
        }
        
        public int getInTime() {
            return inTime;
        }
        
        public int getOutTime() {
            return outTime;
        }
        
        public int getTime() {
            return time;
        }
        
        public int getPrice() {
            return price;
        }
        
        public void setTime() {
            time += outTime - inTime;
        }
        
        public void setPrice() {
            price += fee[1];
            time -= fee[0];
            if (time > 0) {
                price += Math.ceil((double) time / fee[2]) * fee[3]; // 실수형!!
            }
        }
        
        public void setInTime(int time) {
            inTime = time;
            outTime = 23 * 60 + 59;
        }
        
        public void setOutTime(int time) {
            outTime = time;
        }
        
        @Override
        public int compareTo(Car other) {
            return this.id - other.id;
        }
    }
    
    
    public int[] solution(int[] fees, String[] records) {
        fee = fees;
        
        Map<String, Car> map = new LinkedHashMap<>(); // 숙지
        
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if (record[2].equals("IN")) {
                if (map.containsKey(record[1])) {
                    map.get(record[1]).setTime();
                    map.get(record[1]).setInTime(getMinutes(record[0]));
                } else {
                    map.put(record[1], new Car(Integer.parseInt(record[1]), getMinutes(record[0])));
                }
            } else {
                Car current = map.get(record[1]);
                current.setOutTime(getMinutes(record[0])); // 출차 시각 설정
            }
        }
        
        List<Car> list = new ArrayList<>();
        for (Car c : map.values()) {
            list.add(c);
        }
        
        Collections.sort(list);
        int[] arr = new int[list.size()];
        
        
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setTime();
            list.get(i).setPrice();
            arr[i] = list.get(i).getPrice();
        }
        
        return arr;
    }
    
    public int getMinutes(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}
/*
레코드 순회하면서 in out에 따라 입력 처리하기
Map 활용
아웃되지 않은 key 처리 

아니면 list + class(차량번호, 입차 시각, 출차 시각)
시간은 분단위로 저장


누적이었어!!!
첫 설계 잘못함 클래스로 가면 복잡함.

*/