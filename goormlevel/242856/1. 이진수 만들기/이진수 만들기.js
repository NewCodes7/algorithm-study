// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		console.log(Number(line).toString(2));
		rl.close();
	}
	
	process.exit();
})();
