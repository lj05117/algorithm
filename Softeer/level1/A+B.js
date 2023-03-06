const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output:process.stdout
});
let input=[];
rl.on('line',(line)=>{
    input.push(line.split(' '));
}).on('close',()=>{
    for(let i=0;i<input[0];i++){
        console.log('Case #'+(i+1)+': '+(Number(input[i+1][0])+Number(input[i+1][1])))
    }
    // console.log(input);
})
