// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
  let n;
  
	for await (const line of rl) {
    if (!n) {
      n = parseInt(line);
    } else {
      const [ a, b ] = line.split(" ").map(el => parseInt(el));
      if (a === b) {
        console.log("Tulip");
      } else if (a > b) {
        console.log("Rose");
      } else {
        console.log("Sunflower");
      }
    }
    
    if(!line) rl.close();
	}
  
	process.exit();
})();
