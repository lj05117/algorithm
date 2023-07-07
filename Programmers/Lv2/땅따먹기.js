function solution(land) {
  let len = land.length;

  for (let i = 1; i < len; i++) {
    let upperLine = [...land[i - 1]].sort((a, b) => a - b);
    for (let j = 0; j < 4; j++) {
      if (upperLine[3] === land[i - 1][j]) {
        land[i][j] += upperLine[2];
      } else {
        land[i][j] += upperLine[3];
      }
    }
  }

  return Math.max(...land[len - 1]);
}

console.log(
  solution([
    [1, 2, 3, 5],
    [5, 6, 7, 8],
    [4, 3, 2, 1],
  ])
);
