// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
  let n;
  let cnt;
  let input = [];
	for await (const line of rl) {
    if (!n) {
      n = parseInt(line);
    } else {
      input.push(line.split(" ").map(c => parseInt(c)));
      if (++cnt === n) rl.close();
    }
	}
	solution(input);
	process.exit();
})();

const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];

function solution(parkMap) {
  let isGoing = !areAllTreesDone(parkMap);
  let day = 0;
  while (isGoing) {
    parkMap = executeOneDay(parkMap);
    isGoing = !areAllTreesDone(parkMap);
    day++;
  }
  
  console.log(day);
}

function executeOneDay(parkMap) {
  const morningParkMap = parkMap.map(c => [...c]);
  
  parkMap = morningParkMap.map((row, x) => {
    return row.map((tree, y) => {
      for (let i = 0; i < 4; i++) {
        let nx = x + dx[i];
        let ny = y + dy[i];
        
        if (nx < 0 || nx > parkMap.length - 1 || ny < 0 || ny > parkMap.length - 1 || tree === 0) {
          continue;
        }
        
        if (parkMap[nx][ny] === 0) {
          tree--;
        }
      }
      
      return tree;
    })
  })
  
  return parkMap;
}

function areAllTreesDone(parkMap) {
  const temp = parkMap.map(row => row.filter(tree => tree !== 0).length === 0 ? true : false);
  return temp.filter(c => !c).length === 0;
}

/*
map에서는 리턴값을 항상 명시해야 하나? 
js에서는 다른 메서드에서 배열 변경하면 자동으로 안 바뀌나? 파라미터 전달될 때 복사되나> ?
*/