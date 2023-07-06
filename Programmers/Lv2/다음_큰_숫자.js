function solution(n) {
  const findOne = (num) => {
    let str = "";
    let cnt = 0;
    for (let i = num; i > 0; i = parseInt(i / 2)) {
      if (i % 2 > 0) cnt++;
    }
    return cnt;
  };

  let countN = findOne(n); //1갯수

  for (let i = n + 1; ; i++) {
    if (findOne(i) === countN) return i;
  }
}
console.log(solution(78)); //83
