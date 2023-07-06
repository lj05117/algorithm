const fs = require("fs");
let input =
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim().split("\n").map(Number)
    : fs
        .readFileSync(__dirname + "/input.txt")
        .toString()
        .trim()
        .split("\n")
        .map(Number);
let N = input.shift();
let max = 0;
input.sort((a, b) => a - b); //sort 설정 잘해주자
let start = input[0];
let end = input[N - 1];
let ind = 0;

for (; start <= end; start++) {
  while (input[ind] < start) {
    ind++;
  }
  max = Math.max(input[ind] * (N - ind), max);
}

console.log(max);
