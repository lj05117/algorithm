let fs = require('fs').readFileSync('/dev/stdin').toString().split(' ');
let res = Math.floor(fs[0] / (fs[2] - fs[1])) + 1;
fs[1] >= fs[2] ? console.log(-1) : console.log(res);
