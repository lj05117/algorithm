function solution(n, left, right) {
  let answer = [];
  //[r,c]의 값은 Math.max(r,c)+1이다.
  //2차원 배열의 각 행을 나란히 붙여, 1차원 배열을 만들고
  //인덱스 값을 i 라고 했을 때
  //r은 i/n, c는 i%n으로 구할 수 있다.
  while (left <= right) {
    answer.push(Math.max(parseInt(left / n), left++ % n) + 1); //left%n 후에 left++된다.
  }
  return answer;
}

console.log(solution(3, 2, 5)); //[3,2,2,3]
