const fs = require("fs");
let input =
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim().split("\n")
    : fs
        .readFileSync(__dirname + "/input.txt")
        .toString()
        .trim()
        .split("\n");

const [N, M, R] = input[0].split(" ").map(Number);
let arr = input.slice(1).map((str) => str.split(" ").map(Number));

function sol() {
  let answer = "";
  let ret = [...arr];
  for (let i = 0; i < R; i++) {
    ret = rotate(arr);
    arr = [...ret];
  }
  ret.forEach((e) => {
    answer += e.join(" ") + "\n";
  });
  return console.log(answer.trim());
}

function rotate(arr) {
  let min = Math.min(N, M);
  let temp = new Array(N).fill(null).map((_) => new Array(M).fill(0));

  for (let limit = 0; limit < Math.floor(min / 2); limit++) {
    //위
    for (let j = M - 2 - limit; j >= 0 + limit; j--) {
      temp[limit][j] = arr[limit][j + 1];
    }
    //왼
    for (let j = 1 + limit; j < N - limit; j++) {
      temp[j][limit] = arr[j - 1][limit];
    }
    //아래
    for (let j = 1 + limit; j < M - limit; j++) {
      temp[N - 1 - limit][j] = arr[N - 1 - limit][j - 1];
    }
    //오
    for (let j = N - 2 - limit; j >= limit; j--) {
      temp[j][M - 1 - limit] = arr[j + 1][M - 1 - limit];
    }
  }
  return temp;
}

sol();
