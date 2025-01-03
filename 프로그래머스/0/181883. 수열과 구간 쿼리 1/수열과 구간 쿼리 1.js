function solution(arr, queries) {
    queries.forEach(query => {
        for (let i = query[0]; i <= query[1]; i++) {
            arr[i]++;
        }
    });
    
    return arr;
}

/*
7:27 ~ 

queries 순회 
    query[0] ~ query[1] 순회 

*/