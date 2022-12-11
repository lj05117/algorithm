let fs = require('fs').readFileSync('/dev/stdin').toString();
fs=Number(fs);
let fiveNum = parseInt(fs / 5);
let result = -1;
while (result == -1 && fiveNum>-1) {
    let num = fs - fiveNum * 5;
    if (num % 3 == 0) {
        result = fiveNum + parseInt(num / 3);
    } else {
        fiveNum -= 1;
    }
}
console.log(result);
