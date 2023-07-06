function solution(n) {
  let answer = 1;
  for (let i = 1; i <= parseInt(n / 2); i++) {
    let sum = 0;
    for (let j = i; j < n; j++) {
      sum += j;
      if (sum >= n) break;
    }
    if (sum === n) answer++;
  }
  return answer;
}
console.log(solution(15));
