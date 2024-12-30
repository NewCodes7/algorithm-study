function solution(my_string, indices) {
    // 문자열을 배열로 변환하고, indices 바탕으로 필터링
    const answer = my_string.split("").filter((char, idx) => {
        return !indices.includes(idx);
    }).join("");
    
    return answer;
}

/*
4:35 ~ 

1. split을 통해 배열로 만들기 
2. filter를 통해 indices에 해당하는 건 빼고 배열 리턴 
3. join을 통해 결괏값 반환 

*/