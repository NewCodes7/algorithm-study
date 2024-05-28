class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        long nonUsed = 0;
        
        // w와 h의 최대 공약수로 서로 나누어주면 성능 향상 가능!
    
        double m = (double) h / w; // double 빠뜨리면 안 됨!!!
        double before = 0;
        double after = m;
        
        for (int i = 0; i < w; i++) {
            if (before % 1 == 0.0 && after % 1 == 0.0) {
                nonUsed += (long) (after - before);
            } else if (before % 1 == 0.0 || after % 1 == 0.0) {
                nonUsed += (long) Math.ceil(after - before);
            } else {
                nonUsed += (long) Math.ceil(after) - (long) Math.floor(before);
                
                // long d = (long) Math.ceil(after) - (long) Math.floor(before);
                // if (d != 1) { // 아 예외처리하면 안 됨!!! 100, 1하고나서 깨달음. 1개여도 빼야지.
                //     nonUsed += d;
                // }
            }            
            
            before = after;
            // after = m * (i + 2); // -> +=m으로 하면 조금씩 오차 나서 100, 1했을 때 -1 나오는 듯..
            after = (double) h * (i + 2) / w;
        }
        
        answer -= nonUsed;
        
        return answer;
    }
}

/*
끝과 끝이 있기에 똑같은 패턴 반복됨
가장 최소 단위를 알면 게임 끝남

1. 직선의 기울기 3/2 <- 더 이상 나눌 수 없는

2. 최소 단위에서 관통하는 것 몇개인지 파악

직선 위의 좌표를 찍어보면 될 듯. 
x 한 칸 당 y 좌표차가 
    0 ~ 1 -> 1
    1 ~ 2 -> 2 Math.ceil

1.5 -> 3.0 

케이스는 크게 세가지
앞이 정수 -> Math.ceil(d)
뒤가 정수 -> Math.ceil(d)
둘 다 정수 -> d
둘 다 정수가 아닌 경우 -> Math.ceil(after) - Math.floor(before)

1차 제출 -> 실패

케이스 분류 
예외 처리

50분..

다들 일반화해서 풀었네.. 이렇게는 못 푸는 건가? 부동 소수점의 한계?

반복되는 것까진 파악했는데, 가로 세로 길이에 따라 제외되는 사각형의 개수에도 규칙성이 있다는 걸 짐작하지 못했네..


 -> long 빼먹어서 틀렸었음!!!
 -> 테케 6번
        만약 (double)h / w * i로 하셨다면, 먼저 나눈 후 나타난 소숫점에 i를 곱하는 형태가 됩니다.

        (double)h * i / w로 순서를 바꿔서, 먼저 곱해준 후 나눠주게 되면 통과할 수 있습니다.
*/