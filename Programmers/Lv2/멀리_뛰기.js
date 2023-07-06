function solution(n) {
  const answer = [1, 1, 2, 3, 5];
  //1칸, 2칸 뛸 수 있음.
  //3칸 뛰는 경우는 1칸 뛰고 2칸 or 2칸 뛰고 1칸. 그러면 1칸의 경우의 수 + 2칸의 경우의 수
  for (let i = 5; i <= n; i++) {
    answer.push((answer[i - 1] + answer[i - 2]) % 1234567); //보통 1234567 나머지 구하라 하는건 dp
  }

  return answer[n];
}

console.log(solution(4)); //5
