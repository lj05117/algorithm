const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  line = line.split(" ").map(Number); //숫자로 매핑 해줘야 한다.
  const len = line.length;
  let str = "";

  if (line[0] !== 1 && line[0] !== 8) {
    str = "mixed";
  } else {
    for (let i = 1; i < len; i++) {
      //1씩 차이나지 않으면 mixed이다.
      if (Math.abs(line[i] - line[i - 1]) !== 1) {
        str = "mixed";
        break;
      }
    }
    if (str === "" && line[0] === 1) {
      str = "ascending";
    }
    if (str === "" && line[0] === 8) {
      str = "descending";
    }
  }
  rl.close(console.log(str));
});
