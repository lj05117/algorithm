function solution(maps) {
  let answer = Number.MAX_SAFE_INTEGER;
  const N = maps.length;
  const M = maps[0].length;

  const dx = [-1, 0, 1, 0];
  const dy = [0, 1, 0, -1];

  const arr = [[0, 0, 0]];
  let x,
    y,
    cnt = 0;

  maps[0][0] = 2;

  while (arr.length) {
    [x, y, cnt] = arr.shift();

    if (x === N - 1 && y === M - 1) {
      answer = Math.min(answer, cnt);
      continue;
    }

    for (let i = 0; i < 4; i++) {
      let tempX = x + dx[i];
      let tempY = y + dy[i];

      if (tempX < 0 || tempY < 0 || tempX >= N || tempY >= M) continue;

      if (maps[tempX][tempY] === 1) {
        arr.push([tempX, tempY, cnt + 1]);
        maps[tempX][tempY] = 2;
      }
      //   else if (maps[tempX][tempY] === 2) {
      //   for() // 만약 통과 못하면 방문한 곳이랑 이동 거리 계산해보기 - 다익스트라
      //   }
    }
  }

  return answer === Number.MAX_SAFE_INTEGER ? -1 : answer + 1;
}

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 1],
    [0, 0, 0, 0, 1],
  ])
); //11

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 0],
    [0, 0, 0, 0, 1],
  ])
); //-1
