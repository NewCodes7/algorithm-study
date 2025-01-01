function solution(arr, query) {
    // query 순회하며 짝/홀 판단하여 배열 자르기 
    query.forEach((cur, idx) => {
        if (idx % 2 === 0) {
            arr = arr.slice(0, cur + 1);
        } else {
            arr = arr.slice(cur);
        }
    })
    
    return arr;
}

/*
9:15 ~

query 순회 
    짝수라면
        arr = arr.slice(0, 짝수 + 1);
    홀수라면
        arr = arr.slice(홀수);

*/