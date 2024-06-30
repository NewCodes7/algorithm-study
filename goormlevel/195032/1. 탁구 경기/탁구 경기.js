// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
  let n = 0;
  let [d, p] = [0, 0];
	for await (const line of rl) {
    if (!n) {
      n = parseInt(line);
    } else {
      if (line === "D") {
        d++;
      } else {
        p++;
      }
      
      if (Math.abs(d - p) >= 2) {
        break;
      }
    }
	}
  
  console.log(d + ":" + p);
	process.exit();
})();
