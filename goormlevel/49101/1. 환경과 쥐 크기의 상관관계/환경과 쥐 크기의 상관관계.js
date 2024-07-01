// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
  let n;
  let a;
  let b;
	for await (const line of rl) {
    if (!n) {
      n = parseInt(line);
    } else {
      if (!a) {
        a = line.split(" ").map(c => parseInt(c));
      } else if (!b) {
        b = line.split(" ").map(c => parseInt(c));
      } else {
        rl.close();
      }
    }
  }
  
  solution(a, b);
	
	process.exit();
})();

function solution(a, b) {
  a.sort((x, y) => x - y);
  b.sort((x, y) => x - y);
  
  const aMax = getX(a);
  const bMax = getX(b);
  console.log(aMax + " " + bMax);
  console.log(aMax > bMax ? "good" : "bad");
  
}

function getX(a) {
  const rank = new Map();
  a.forEach(num => {
    for (let i = -2; i < 3; i++) {
      if (rank.has(num + i)) {
        rank.set(num + i, rank.get(num + i) + 1);
      } else {
        rank.set(num + i, 1);
      }
    }

  });
  
  let maxValue = 0;
  let maxKey = 0;
  for (let [key, value] of rank) { // of와 in의 차이점? 
    if (value > maxValue) {
      maxValue = value;
      maxKey = key;
    }
  }
  
  return maxKey;
}

/*
100,000
10,000,000,000

시간 초과 문제 해결하려면...
getX()의 메서드 개선해야 함.
이중 반복문 -> 루프 하나로 해결. 
투 포인터? 

dp? ㄱㄱ
1. 원본 배열 돌면서 -2 +2인 곳 ++
2. ++한 배열 돌면서 가장 큰 곳 체크

*/