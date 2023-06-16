const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];
rl.on("line", (line) => {
  input.push(line.split(" "));
}).on("close", () => {
  const room = Number(input[0][0]);
  const arrLen = Number(input[0][1]);

  const arr = new Array(room);
  for (let i = 0; i < room; i++) {
    arr[i] = new Array(9).fill(true);
  }

  //이름 오름차순으로 정렬
  const nameArr = new Array(room);
  for (let i = 0; i < room; i++) {
    nameArr[i] = input[i + 1][0];
  }
  nameArr.sort();

  //회의시간 빼기.
  for (let i = room + 1; i <= room + arrLen; i++) {
    const reservation = input[i];
    let roomName = 0;
    for (; roomName <= room; roomName++) {
      if (nameArr[roomName] === reservation[0]) {
        break;
      }
    }
    let start = Number(reservation[1]) - 9;
    const end = Number(reservation[2]) - 9;
    for (; start < end; start++) {
      arr[roomName][start] = false;
    }
  }
  //true인 애들 cnt돌리기.
  //각 구간 print하기기
  for (let i = 0; i < room; i++) {
    console.log("Room " + nameArr[i] + ":");
    let cnt = 0;
    for (j = 0; j < 9; j++) {
      if (arr[i][j] === true) {
        if (j == 0 || arr[i][j - 1] === false) cnt++;
      }
    }
    if (cnt === 0) {
      console.log("Not available");
    } else {
      console.log(cnt + " available:");
      let str = "";
      for (let j = 0; j < 9; j++) {
        if (arr[i][j] === true) {
          if (
            (j === 0 && arr[i][j + 1] === false) ||
            (str === "" && arr[i][j + 1] === false) ||
            (j === 8 && str === "")
          ) {
            str = String(j + 9).padStart(2, "0") + "-" + String(j + 10).padStart(2, "0");
            console.log(str);
            str = "";
          } else if (j == 0 || arr[i][j - 1] === false) {
            str = String(j + 9).padStart(2, "0");
          } else if (j === 8 || arr[i][j + 1] === false) {
            str += "-" + String(j + 10).padStart(2, "0");
            console.log(str);
            str = "";
          }
        }
      }
    }
    if (i != room - 1) {
      console.log("-----");
    }
  }
});
