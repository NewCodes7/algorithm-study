// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.on("line", function(line) {
	const s = line.trim();
	if (s === "") {
		console.log(0);
	} else {
		console.log(s.split(/\s+/g).length);
	}
	rl.close();
}).on("close", function() {
	process.exit();
});