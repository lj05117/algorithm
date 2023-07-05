const fs = require("fs");
let input =
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim().split("\n")
    : fs
        .readFileSync(__dirname + "/input.txt")
        .toString()
        .trim()
        .split("\n");
let answer = -1;
const N = Number(input.shift());
const M = Number(input.shift());

const linkedArr = Array.from({ length: N + 1 }, () => []);
const visited = Array.from({ length: N + 1 }, () => false);
for (let i = 0; i < input.length; i++) {
  let nowLinked = input[i].split(" ").map(Number);
  linkedArr[nowLinked[0]].push(nowLinked[1]);
  linkedArr[nowLinked[1]].push(nowLinked[0]);
}

//dfs 버전
function dfs(num) {
  answer++;
  visited[num] = true;
  for (let i = 0; i < linkedArr[num].length; i++) {
    if (!visited[linkedArr[num][i]]) {
      dfs(linkedArr[num][i]);
    }
  }
}

dfs(1);
//bfs 버전

console.log(answer);
