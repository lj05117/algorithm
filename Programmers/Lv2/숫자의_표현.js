function solution(n) {
  let answer = 1;
  for (let i = 1; i <= n / 2; i++) {
    let sum = 0;
    for (let j = i; j < n; j++) {
      sum += j;
      if (sum === n) {
        answer++;
        break;
      }
      if (sum > n) break;
    }
  }
  return answer;
}
