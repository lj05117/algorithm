function solution(A, B) {
  let answer = 0;
  A.sort((a, b) => a - b);
  B.sort((a, b) => b - a); //큰 수끼리 곱하면 안됨.
  for (let i = 0; i < A.length; i++) {
    answer += A[i] * B[i];
  }
  return answer;
}
console.log(solution([1, 4, 2], [5, 4, 4])); //29
