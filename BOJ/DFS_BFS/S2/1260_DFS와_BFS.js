const fs = require("fs");
let input =
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim().split("\n")
    : fs
        .readFileSync(__dirname + "/input.txt")
        .toString()
        .trim()
        .split("\n");

let firstLine = input.shift();
[N, M, V] = firstLine.split(" ").map(Number);
const linkedArr = Array.from({ length: N + 1 }, () => []);
for (let i = 0; i < input.length; i++) {
  let line = input[i].split(" ").map(Number);
  linkedArr[line[0]].push(line[1]);
  linkedArr[line[1]].push(line[0]);
}

const visitD = [];
const visitB = [];
for (let i = 0; i < linkedArr.length; i++) {
  linkedArr[i].sort((a, b) => a - b);
}

function dfs(num) {
  visitD.push(num);
  for (let i = 0; i < linkedArr[num].length; i++) {
    if (!visitD.includes(linkedArr[num][i])) {
      dfs(linkedArr[num][i]);
    }
  }
}
//dfs
dfs(V);
console.log(visitD.join(" "));

//bfs
const visited = [V];
while (visited.length !== 0) {
  let num = visited.shift();
  visitB.push(num);
  for (let i = 0; i < linkedArr[num].length; i++) {
    if (!visitB.includes(linkedArr[num][i]) && !visited.includes(linkedArr[num][i])) {
      visited.push(linkedArr[num][i]);
    }
  }
}
console.log(visitB.join(" "));
