// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
  let x;
	for await (const line of rl) {
    x = BigInt(line);
		rl.close();
	}
  // console.log(factorial(x));
  console.log(convert(factorial(BigInt(x))));
	
	process.exit();
})();

// function factorial(n) { // 여기서 런타임 에러가 나오는 경우? 
//   // if (Number(n) === 1) return BigInt(1); // <- Number() 때문에 그런가?
//   // if (n === BigInt(1) || n === BigInt(0)) return BigInt(1); // 0이 들어올 경우!!
//   if (n === BigInt(1) || n === BigInt(0)) return BigInt(1); // 0이 들어올 경우!!
//   return n * factorial(n - BigInt(1));
// }

function factorial(n) { // 아.. 스택오버 플로우 때문이었나. 재귀 호출...
  if (n === 0n || n === 1n) return 1n;
  let result = 1n;
  for (let i = 2n; i <= n; i++) {
    result *= i;
  }
  return result;
}

function convert(n) {
  if (Number(n).toString().length === 1) return Number(n);
  return convert(n.toString().split("").reduce((a, c) => a + BigInt(c), BigInt(0)));
}
