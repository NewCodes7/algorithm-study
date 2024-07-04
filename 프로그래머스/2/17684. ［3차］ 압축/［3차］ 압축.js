const dict = new Map();
const alphabet = 'abcdefghijklmnopqrstuvwxyz';
alphabet.toUpperCase().split('').forEach((c, idx) => dict.set(c, idx + 1));

function solution(msg) {
    var answer = [];
    
    let dictFinalIdx = 26;
    let cnt = 0;
    const len = msg.length; 
    while (cnt < len) {
        let w = getW(msg, 1);
        answer.push(dict.get(w));

        if (w.length + 1 <= msg.length) {
            dictFinalIdx++;
            dict.set(msg.substring(0, w.length + 1), dictFinalIdx);
        }
        
        msg = msg.substring(w.length);
        cnt += w.length;
    }
    
    return answer;
}

function getW(str, idx) {
    if (idx < str.length && dict.has(str.substring(0, idx + 1))) {
        return getW(str, idx + 1); // 여기 리턴을 붙이니 됨..!! 리턴이 없으니 전달이 안 된거였어!
    } else {
        return str.substring(0, idx);
    }
}

/*
맵 혹은 배열로 접근 가능

w 가져오는 메서드 

종료 조건을 어떻게 잡아야 하나? 

설계 했어야 했는데.. 문자열로 다룰지. 배열로 다룰지.
*/