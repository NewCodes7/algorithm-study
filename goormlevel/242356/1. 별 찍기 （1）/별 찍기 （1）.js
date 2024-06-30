// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		Array.from({ length: line }, (_, i) => i).forEach((_, i) => console.log("*".repeat(i + 1)));
		rl.close();
	}
	
	process.exit();
})();
