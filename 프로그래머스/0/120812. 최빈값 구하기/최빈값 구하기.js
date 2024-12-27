function solution(array) {
    const arr = new Array(1001).fill(0);
    
    array.forEach(el => {
        if (arr[el] === undefined) {
            arr[el] = 0;
        }
        arr[el]++;
    });
    
    const maxCount = Math.max(...arr); // 이렇게 하면 되는 이유? 
    // const maxNumbers = [];
    // arr.forEach((el, idx) => {
    //     if (el === maxCount) {
    //         maxNumbers.push(idx);
    //     }
    // })
    
    const maxNumbers = arr.reduce((acc, cur, idx) => {
        if (cur === maxCount) {
            acc.push(idx);
        }
        return acc;
    }, []);
    
    let answer = -1;
    if (maxNumbers.length === 1) {
        answer = maxNumbers[0];
    }
    
    return answer;
}

/*
3:50

*/