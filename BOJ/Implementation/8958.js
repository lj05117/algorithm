// let fs = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let fs = [5,
    'OOXXOXXOOO',
    'OOXXOOXXOO',
    'OXOXOXOXOXOXOX',
    'OOOOOOOOOO',
    'OOOOXOOOOXOOOOX'];
let result = '';
for (let i = 1; i<=fs[0]; i++){
    if (i != 1) {
        result += '\n';
    }
    let num = fs[i].length;
    let sum = 0;
    let add = 0;
    for (let j = 0; j < num; j++){
        if (fs[i].charAt(j) == 'O') {
            add += 1;
        } else {
            add = 0;
        }
        sum += add;
    }
    result += sum;
}
console.log(result);
