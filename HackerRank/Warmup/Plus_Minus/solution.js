function plusMinus(arr) {
  const LEN = arr.length;
  let plus = 0,
    minus = 0,
    zero = 0;

  for (let i of arr) {
    if (i > 0) plus++;
    else if (i === 0) zero++;
    else minus++;
  }

  console.log(
    (plus / LEN).toFixed(6) + "\n" + (minus / LEN).toFixed(6) + "\n" + (zero / LEN).toFixed(6)
  );
}

plusMinus([-4, 3, -9, 0, 4, 1]);
