function solution(numbers, k) {
  var answer = 2 * (k - 1) + 1;
  while (answer > numbers.length) {
    answer -= numbers.length;
  }
  return answer;
}
