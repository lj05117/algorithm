function steadyGene(gene) {
  const geneDic = { A: 0, C: 0, G: 0, T: 0 };
  //geneDic 객체에 각 알파벳이 나온 횟수만큼 표시해주기
  Array.from(gene).forEach((c) => geneDic[c]++);

  const n = gene.length / 4;
  let left = 0,
    right = 0,
    minLen = Infinity;

  //포인터가 글자 길이를 넘지 않는 동안 탐색
  while (left < gene.length && right < gene.length) {
    //하나라도 유전자 갯수 많은게 있는가?
    if (Object.values(geneDic).some((v) => v > n)) {
      //오른쪽 포인터가 가리키고 있던 글자 갯수 줄이고 -> 왼, 오 포인터의 사이가 변경할 글자. 오른쪽 포인터의 오른쪽은 사용할 유전자 글자.
      //오른쪽 포인터가 이동하는것은 변경할 글자 범위를 늘리고, 유지할 글자 줄인다는 뜻.
      geneDic[gene[right]]--;
      //오른쪽 포인터 오른쪽으로 이동
      right++;
    } else {
      //유지할 문자열에서 유전자 갯수가 많은게 없는 경우
      //범위를 제대로 설정했다고 생각하고 변경할 문자열의 최소길이 측정
      minLen = Math.min(minLen, right - left);
      //왼쪽 포인터가 가리키고 있던 글자를 유지할 글자로 설정. 글자 갯수 +1 해줌.
      geneDic[gene[left]]++;
      //왼쪽 포인터를 오른쪽으로 옮겨서 변경할 글자 범위 줄임.
      left++;
    }
  }

  return minLen;
}

console.log(steadyGene("TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC"));
