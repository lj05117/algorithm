function compareTriplets(a, b) {
  const LEN = a.length;
  const score = [0, 0];

  for (let i = 0; i < LEN; i++) {
    if (a[i] > b[i]) score[0] += 1;
    else if (a[i] < b[i]) score[1] += 1;
  }

  return score;
}

console.log(compareTriplets([5, 6, 7], [3, 6, 10]));
