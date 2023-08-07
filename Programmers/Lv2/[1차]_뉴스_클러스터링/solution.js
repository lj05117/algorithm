function solution(str1, str2) {
  const str1Dict = {};
  const str2Dict = {};
  const str1Len = str1.length;
  const str2Len = str2.length;
  let regex = /^[a-z]*$/;
  let str_1 = str1.toLowerCase();
  let str_2 = str2.toLowerCase();
  let sum = 0;
  let mul = 0;

  //객체 만들기
  for (let i = 0; i < str1Len - 1; i++) {
    let strNow = str_1.slice(i, i + 2);
    if (!regex.test(strNow)) {
      continue;
    }
    if (strNow in str1Dict) {
      str1Dict[strNow]++;
    } else {
      str1Dict[strNow] = 1;
    }
  }

  for (let i = 0; i < str2Len - 1; i++) {
    let strNow = str_2.slice(i, i + 2);
    if (!regex.test(strNow)) {
      continue;
    }
    if (strNow in str2Dict) {
      str2Dict[strNow]++;
    } else {
      str2Dict[strNow] = 1;
    }
  }

  //합집합, 교집합 구하기
  for (let key in str1Dict) {
    if (key in str2Dict) {
      sum += Math.max(str1Dict[key], str2Dict[key]);
      mul += Math.min(str1Dict[key], str2Dict[key]);
    } else {
      sum += str1Dict[key];
    }
  }
  for (let key in str2Dict) {
    if (key in str1Dict) {
      continue;
    }
    sum += str2Dict[key];
  }

  if (sum === 0 && mul === 0) return 65536;
  return parseInt((mul / sum) * 65536);
}

console.log(solution("FRANCE", "french")); //	16384
console.log(solution("handshake", "shake hands")); //65536
console.log(solution("aa1+aa2", "AAAA12")); //43690
console.log(solution("E=M*C^2", "e=m*c^2")); //65536
