function solution(s) {
  let str = s;
  let cnt = 0;
  let i = 0;
  for (; str !== "1"; i++) {
    let num = "";
    str.split("").map((i) => (Number(i) > 0 ? (num += i) : cnt++));
    str = "";
    let numLen = num.length;
    for (; numLen !== 0; numLen = parseInt(numLen / 2)) {
      str = (numLen % 2) + str;
    }
  }
  return [i, cnt];
}

console.log(solution("110010101001"));
