// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
  let n, m;
  let cnt;
  let input = [];
	for await (const line of rl) {
		if (!n) {
      [n, m] = line.split(" ");
      cnt = m;
    } else {
      input.push(line.split(" ").map(c => parseInt(c)));
      cnt--;
      if (cnt === -1) {
        rl.close();
        solution(n, m, input);
      }
    }
	}
	
	process.exit();
})();

function solution(n, m, input) {
  const house = input[0];
  const rains = input.splice(1);
  
  let arr = new Array(n).fill(false);
  rains.forEach((rain, day) => {
    for (let i = rain[0]; i <= rain[1]; i++) {
      house[i - 1]++;
      arr[i - 1] = true;
    }
    
    if ((day + 1) % 3 === 0) {
      arr.forEach((c, i) => c === true ? house[i]-- : '');
      arr = new Array(n).fill(false);
    }
  })
  
  console.log(house.join(' '));
}

/*
해당하는 거 +1씩 하고, <- 배열 
3일마다 한 번씩 -1해주면 됨. (비 내린 위치에서) <- 큐 사용하면 될 듯. 


*/
  