function solution(n) {
  const F = [0, 1];
  while (F.length <= n) {
    let len = F.length;
    F.push((F[len - 1] + F[len - 2]) % 1234567);
  }
  return parseInt(F[F.length - 1]);
}

console.log(solution(8));
