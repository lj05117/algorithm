function solution(arr) {
  for (let i = Math.max(...arr) + 1; ; i++) {
    let check = true;

    for (let j = 0; j < arr.length; j++) {
      if (i % arr[j] !== 0) {
        check = false;
        break;
      }
    }

    if (check) return i;
  }
}

console.log(solution([2, 6, 8, 14]));
