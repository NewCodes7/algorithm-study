function solution(l, r) {
    const answer = Array.from({ length: r - l + 1 }, ((_, i) => i + l))
                .filter(num => !/[^05]/.test(num));
    
    return answer.length ? answer : [-1];
}

/*
11:26 ~ 

l ~ r 배열 만들기 
reduce -> 5와 0으로만 이루어진 수 누적

중간 중간 콘솔 찍는 거 괜찮나? 

*/