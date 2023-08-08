function biggerIsGreater(w) {
  let values = [...w];
  let point1 = values.length - 1;
  //글자가 2개 이상인 경우, 오른쪽 값보다 작은 값이 있는 인덱스까지 point1 보내기
  while (point1 > 0 && values[point1] <= values[point1 - 1]) point1--;

  //글자가 내림차순 정렬 된 경우
  if (!point1) return "no answer";

  let point2 = point1;

  point1--;

  let min = values[point2];

  //오른쪽 값부터 탐색했을 때, 작은값이랑 인덱스 차이가 2이상 나는 경우 탐색
  //알파벳이지만, a를 1로 하는 숫자라고 생각해보자.
  //ex) 1243 => 3부터 왼쪽으로 탐색. 왼,오 값 비교했을 때, 왼쪽이 작은 경우가 point2와 2이상 차이나는 경우를 탐색
  for (let i = point1 + 2; i < values.length; i++) {
    values[i] < min && values[i] > values[point1] && ((point2 = i), (min = values[i]));
  }

  //값을 교체하는 방법 - 구조 분해 할당
  //point1은 처음 나타난 작은 값. point2는 point1이후 인덱스 중 가장 작은 값.
  //ex)2가 point1, 3이 point2였음. =>1342가 됨.
  [values[point1], values[point2]] = [values[point2], values[point1]];

  //point1의 인덱스까지는 그대로 두고 나머지 숫자들 오름차순 정렬
  //ex)13까지는 그대로 두고, 42 숫자들 오름차순 정렬
  return [
    ...values.slice(0, point1 + 1),
    ...values.slice(point1 + 1, values.length).sort((x, y) => (x >= y ? 1 : -1)),
  ].join("");
}

const input = ["lmno", "dcba", "dcbb", "abdc", "abcd", "fedcbabcd"];

input.map((i) => console.log(biggerIsGreater(i)));
