function diagonalDifference(arr) {
  const LEN = arr.length;
  let leftToRight = 0;
  let rightToLeft = 0;

  //왼쪽과 오른쪽 상단에서 시작해서 대각선 요소를 각각 더한다.
  for (let i = 0; i < LEN; i++) {
    leftToRight += arr[i][i];
    rightToLeft += arr[i][LEN - 1 - i];
  }
  return Math.abs(leftToRight - rightToLeft);
}
console.log(
  diagonalDifference([
    [11, 2, 4],
    [4, 5, 6],
    [10, 8, -12],
  ])
);
