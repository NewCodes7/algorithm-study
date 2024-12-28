function solution(l, r) {
    const arr = new Array(r - l + 1).fill(l).map((c, i) => c + i);
    
    const answer = arr.reduce((acc, cur) => {
        if (cur.toString().split("").filter(c => c !== "5" && c !== "0").length === 0) {
            acc.push(cur);
        }
        return acc;
    }, []);
    
    if (answer.length === 0) {
        answer.push(-1);
    }
    
    return answer;
}

/*
11:26 ~ 

l ~ r 배열 만들기 
reduce -> 5와 0으로만 이루어진 수 누적

중간 중간 콘솔 찍는 거 괜찮나? 

*/