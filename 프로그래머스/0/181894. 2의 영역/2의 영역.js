function solution(arr) {
    var answer = [];
    
    const startEndIdx = arr.reduce((acc, cur, idx) => {
        if (cur === 2 && acc.length === 0) {
            acc.push(idx);
        }
        if (cur === 2 && acc.length != 0) {
            acc[1] = idx;
        }
        return acc;
    }, []);
    
    if (startEndIdx.length != 2) {
        answer.push(-1);
    } else {
        answer = arr.slice(startEndIdx[0], startEndIdx[1] + 1);
    }
    
    return answer;
}

/*
3:13 ~ 

앞에서부터 순회하며 2인 것들 인덱스 저장


*/