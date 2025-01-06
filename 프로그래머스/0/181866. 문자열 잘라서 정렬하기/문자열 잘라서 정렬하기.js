function solution(myString) {
    const answer = myString.split("x")
    .filter(c => c !== "")
    .sort();
    
    return answer;
}

/*
8:37 ~ 

split("x") -> sort

*/