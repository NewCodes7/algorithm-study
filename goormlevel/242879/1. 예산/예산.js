// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
  let n, m;
	for await (const line of rl) {
    if (!n) {
      if (n == 0) rl.close();
      [n, m] = line.split(" ");
    } else {
      let [c, v] = line.split(" ");
      m -= c * v;
      n--;
    }
	}
  
  console.log(m >= 0 ? m : "No");
  
	
	process.exit();
})();
