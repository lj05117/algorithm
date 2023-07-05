function solution(s) {
  return s
    .substring(2, s.length - 2)
    .split("},{")
    .map((e) => e.split(",").map((e) => parseInt(e)))
    .sort((a, b) => a.length - b.length)
    .reduce((acc, cur) => [...acc, ...cur.filter((it) => !acc.includes(it))], []);
}

console.log(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
