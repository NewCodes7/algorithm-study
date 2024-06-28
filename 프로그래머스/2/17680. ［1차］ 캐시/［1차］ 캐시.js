function solution(cacheSize, cities) {
    var answer = 0;
    
    if (cacheSize === 0) {
        return cities.length * 5;
    }
    
    cities = cities.map(city => city.toLowerCase());
    
    const cache = [];
    cities.forEach(city => {
        if (cache.includes(city)) {
            cache.splice(cache.indexOf(city), 1);
            cache.push(city);
            answer += 1;
        } else {
            if (cache.length === cacheSize) {
                cache.shift();
            }
            cache.push(city);
            answer += 5;
        }
    });
    
    return answer;
}

/*
LRU를 어떻게 구현할 것인가? 

참조된 순서에 따라 정렬
자바라면 그 뭐지.. 삽입될 때마다 정렬되는 것. 다익스트라에서 쓰던 것. 최소힙!

배열에 넣기

큐처럼 하기 + 캐시 히트되면 해당 요소 삭제했다가 다시 집어넣기
*/