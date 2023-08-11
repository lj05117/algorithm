const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
const dx = [0, 1, 0, -1];
const dy = [-1, 0, 1, 0];

rl.on("line", (line) => {
  input.push(line.split("").map(Number));
}).on("close", () => {
  const N = Number(input[0].join(""));
  const barrier = [];

  const bfs = (i, j) => {
    const que = [[i, j]];
    let cnt = 1;
    let barrierNum = barrier.length + 2;
    input[i][j] = barrierNum;

    while (que.length) {
      const pos = que.shift();

      for (let i = 0; i < 4; i++) {
        let r = pos[0] + dy[i];
        let c = pos[1] + dx[i];
        if (1 <= r && r <= N && 0 <= c && c < N && input[r][c] === 1) {
          que.push([r, c]);
          cnt++;
          input[r][c] = barrierNum;
        }
      }
    }

    barrier.push(cnt);
  };

  for (let i = 1; i <= N; i++) {
    for (let j = 0; j < N; j++) {
      if (input[i][j] === 1) {
        bfs(i, j);
      }
    }
  }
  console.log(barrier.length);
  barrier.sort((a, b) => a - b);
  barrier.forEach((element) => {
    console.log(element);
  });
});
