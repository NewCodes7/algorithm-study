function solution(ineq, eq, n, m) {
    let answer = 0;
    
    // 1. ineq < or >에 부합하는지 확인 
    if (ineq === ">") {
        answer = n > m ? 1 : 0;
    } else if (ineq === "<") {
        answer = n < m ? 1 : 0;
    }
    
    // 2. eq =에 부합하는지 확인 - ineq에서 부합하지 않더라도 같으면 1 반환
    if (eq === "=" && n === m) {
        answer = 1;
    }
    
    return answer;
}

/*
10:17 ~ 

분기처리 



*/