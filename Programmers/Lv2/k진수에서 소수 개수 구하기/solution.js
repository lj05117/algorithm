//통과 (532.14ms, 35.3MB)
function solution(n, k) {
  let answer = 0;
  let str = "";
  let num = n.toString(k);
  const numArr = num.split("0").map(Number);

  function checkPrime(num) {
    if (num <= 1) return false;
    let sqrtNum = Math.sqrt(num);
    for (let i = 2; i <= sqrtNum; i++) {
      if (num % i === 0) return false;
    }
    return true;
  }

  for (let i = 0; i < numArr.length; i++) {
    if (checkPrime(numArr[i])) answer++;
  }

  return answer;
}

//	통과 (15.07ms, 36.6MB)
function solution(n, k) {
  let answer = 0;
  let str = "";
  let num = n.toString(k);
  const numArr = num.split("0").map(Number);

  function checkPrime(num) {
    if (num <= 1) return false;
    let sqrtNum = Math.sqrt(num);

    for (let i = 2; i <= sqrtNum; i++) {
      if (num % i === 0) return false;
    }
    return true;
  }

  for (let i = 0; i < numArr.length; i++) {
    if (checkPrime(numArr[i])) answer++;
  }

  return answer;
}

console.log(solution(437674, 3)); //3
console.log(solution(110011, 10)); //2
