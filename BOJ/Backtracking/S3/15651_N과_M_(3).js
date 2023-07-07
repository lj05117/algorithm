const fs = require("fs");
let input =
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim().split("\n")
    : fs
        .readFileSync(__dirname + "/input.txt")
        .toString()
        .trim()
        .split("\n");
const [N, M] = input[0].split(" ").map(Number);
let str = "";

const recursive = (arr) => {
  if (arr.length === M) {
    str += arr.join(" ");
    str += "\n";
    return;
  }

  for (let i = 1; i < N + 1; i++) {
    recursive([...arr, i]);
  }
};
recursive([]);

console.log(str);
