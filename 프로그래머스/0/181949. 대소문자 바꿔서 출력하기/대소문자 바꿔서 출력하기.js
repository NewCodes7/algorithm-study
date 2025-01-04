const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    const str = input[0];
    solution(str);
});

function solution(line) {
    const answer = line.split("").map(char => {
        if (isUpperCase(char)) {
            return char.toLowerCase();
        } else {
            return char.toUpperCase();
        }
    }).join("");
    
    console.log(answer);
}

function isUpperCase(char) {
    return char.toUpperCase() === char;
}

/*
11:46 ~ 

toUpperCase toLowerCase
split -> 조건에 따라 바꾸기 -> join
*/