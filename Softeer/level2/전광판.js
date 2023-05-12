const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
let number = [
  [1, 1, 1, 1, 1, 1, 0], //0
  [0, 0, 0, 1, 1, 0, 0], //1
  [0, 1, 1, 0, 1, 1, 1], //2
  [0, 0, 1, 1, 1, 1, 1], //3
  [1, 0, 0, 1, 1, 0, 1],
  [1, 0, 1, 1, 0, 1, 1],
  [1, 1, 1, 1, 0, 1, 1],
  [1, 0, 0, 1, 1, 1, 0],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 0, 1, 1, 1, 1, 1],
];
rl.on("line", (line) => {
  input.push(line.split(" "));
}).on("close", () => {
  const round = Number(input[0]);
  for (let i = 1; i <= round; i++) {
    let cnt = 0;
    let A = input[i][0].split(""); //['9','8','8','1']
    let B = input[i][1].split(""); //['1','0','7','2','4']

    if (A.length < B.length) {
      //A가 더 길거나 같은 숫자가 되도록
      let temp = [...A];
      A = [...B];
      B = [...temp];
    }

    let minus = A.length - B.length;

    for (let j = 0; j < minus; j++) {
      //1을 가진 수 더하기
      let ANumArr = number[Number(A[j])];
      for (let k = 0; k < 8; k++) {
        if (ANumArr[k] === 1) cnt++;
      }
    }
    for (let j = minus; j < A.length; j++) {
      let ANumArr = number[Number(A[j])];
      let BNumArr = number[Number(B[j - minus])];
      for (let k = 0; k < 8; k++) {
        if (ANumArr[k] !== BNumArr[k]) cnt++;
      }
    }
    console.log(cnt);
  }
});

//--------------위는 제출용, 아래는 테스트용

function solution(input) {
  let number = [
    [1, 1, 1, 1, 1, 1, 0], //0
    [0, 0, 0, 1, 1, 0, 0], //1
    [0, 1, 1, 0, 1, 1, 1], //2
    [0, 0, 1, 1, 1, 1, 1], //3
    [1, 0, 0, 1, 1, 0, 1],
    [1, 0, 1, 1, 0, 1, 1],
    [1, 1, 1, 1, 0, 1, 1],
    [1, 0, 0, 1, 1, 1, 0],
    [1, 1, 1, 1, 1, 1, 1],
    [1, 0, 1, 1, 1, 1, 1],
  ];
  const round = Number(input[0]);
  for (let i = 1; i <= round; i++) {
    let cnt = 0;
    let A = input[i][0].split(""); //['9','8','8','1']
    let B = input[i][1].split(""); //['1','0','7','2','4']

    if (A.length < B.length) {
      //A가 더 길거나 같은 숫자가 되도록
      let temp = [...A];
      A = [...B];
      B = [...temp];
    }

    let minus = A.length - B.length;

    for (let j = 0; j < minus; j++) {
      //1을 가진 수 더하기
      let ANumArr = number[Number(A[j])];
      for (let k = 0; k < 8; k++) {
        if (ANumArr[k] === 1) cnt++;
      }
    }
    for (let j = minus; j < A.length; j++) {
      let ANumArr = number[Number(A[j])];
      let BNumArr = number[Number(B[j - minus])];
      for (let k = 0; k < 8; k++) {
        if (ANumArr[k] !== BNumArr[k]) cnt++;
      }
    }
    console.log(cnt);
  }
}
solution([["2"], ["1", "2"], ["9881", "10724"]]);
