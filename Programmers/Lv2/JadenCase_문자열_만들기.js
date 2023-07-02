function solution(s) {
  let arr = s.split(" ");
  arr = arr.map((x) => x.charAt(0).toUpperCase() + x.slice(1).toLowerCase());
  return arr.join(" ");
}
console.log(solution("3people unFollowed me"));
