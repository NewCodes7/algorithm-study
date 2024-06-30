// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
    const [a, b] = line.split(" ");
    solution(a, b);
    
		rl.close();
	}
	
	process.exit();
})();

function solution(a, b) {
  a = eval(a);
  b = eval(b);
  console.log(a > b ? a : b);
}

