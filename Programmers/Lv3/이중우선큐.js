function solution(operations) {
  const answer = [];
  for (operation of operations) {
    operation = operation.split(" ");
    operation[0] === "I"
      ? answer.push(Number(operation[1]))
      : operation[1] === "-1"
      ? answer.shift()
      : answer.pop();
    answer.sort((a, b) => a - b);
  }
  if (answer.length === 0) return [0, 0];
  else return [answer[answer.length - 1], answer[0]];
}

console.log(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]));
console.log(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]));
