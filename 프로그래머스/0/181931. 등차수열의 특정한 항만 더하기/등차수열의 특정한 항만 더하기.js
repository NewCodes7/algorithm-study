function solution(a, d, included) {
    const answer = included.reduce((acc, cur, idx) => {
        if (cur) {
            acc += a + idx * d;
        }
        return acc;
    }, 0);
    
    return answer;
}

/*
11:26 ~ 

an = a1 + (n - 1)d

included 순회하면서 
    true라면 idx * d + a 더하기 
    
reduce를 사용해서 조건에 따라 더하며 전체값 누적하기 
*/