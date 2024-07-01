const shifts = ["D", "R", "U", "L"];
const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];

function solution(n, input) {
  const gameMap = Array.from({ length: n }, () => Array(n).fill(""));
  
  let [groomX, groomY] = input[0].split(" ").map(c => parseInt(c) - 1);
  let [playerX, playerY] = input[1].split(" ").map(c => parseInt(c) - 1);
  
  for (let i = 2; i < n + 2; i++) {
    gameMap[i - 2] = [...input[i].split(" ")];
  }
  
  const groomScore = getScore(gameMap, groomX, groomY);
  const playerScore = getScore(gameMap, playerX, playerY);
  
  // const groomMap = gameMap.map(c => c.slice()); // 2차원 배열 복사!!
  
  console.log(groomScore > playerScore ? "goorm " + groomScore : "player " + playerScore);
}

function getScore(gameMap, x, y) {
  let groomScore = 1;
  const playerMap = Array.from({ length: n }, () => Array(n).fill(true));
  while (playerMap[x][y]) {
    playerMap[x][y] = false;
    const countCommand = gameMap[x][y];
    let count = parseInt(countCommand);
    let command = countCommand[countCommand.length - 1];
    
    const shift = shifts.indexOf(command);
    
    for (let i = 0; i < count; i++) {
      x = (x + dx[shift]) % n;
      y = (y + dy[shift]) % n;
      if (x === -1) x = n - 1;
      if (y === -1) y = n - 1;
      
      if (playerMap[x][y]) {
        groomScore++;
        if (i !== count - 1) {
          playerMap[x][y] = false;
        }
      } else {
        break;
      }
    }
  }
  
  return groomScore;
}

const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input = [];
let n;
let cnt = 0;
rl.on('line', (line) => {
  if (!n) {
    n = parseInt(line);
  } else {
    input.push(line);
    cnt++;
    if (cnt === n + 2) {
      rl.close();
    }
  }
});

rl.on('close', () => {
	solution(n, input);
})
