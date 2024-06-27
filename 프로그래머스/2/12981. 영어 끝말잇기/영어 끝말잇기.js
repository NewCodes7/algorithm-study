function solution(n, words) {
    const set = new Set();
    let beforeWord = words[0][0];
    
    let idx = -1;
    
    for (let i = 0; i < words.length; i++) {
        const word = words[i];
        
        if (word.length < 2) {
            idx = i;
            break;
        }
        
        if (set.has(word)) {
            idx = i;
            break;
        }
        
        if (beforeWord !== word[0]) {
            idx = i;
            break;
        }
        
        set.add(word);
        beforeWord = word[word.length - 1];
    }
    console.log(idx);
    if (idx === -1) {
        return [0, 0];
    } else {
        return [ idx % n + 1, Math.ceil((idx + 1) / n) ];
    }
}

/*
최초로 유효하지 않은 단어가 나왔을 때 탈락자 선정하면 됨. 

규칙
1. 문자가 이어지는가? 
2. 새로운 단어인가? 
3. 두 글자 이상인 단어인가? 

Set 자료구조 선정

words에서 몇 번째인지만 알면 정답 구할 수 있음. 



*/