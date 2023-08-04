const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  const num = Number(line);
  const dp = [Number(2)];

  for (let i = 1; i <= num; i++) {
    let before = dp[i - 1];
    let next = before * 2 - 1;
    dp.push(next);
  }

  let answer = dp[dp.length - 1];
  console.log(answer * answer);

  rl.close();
}).on("close", () => {});
