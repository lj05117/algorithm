const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});
let input=[];
rl.on('line',(line)=>{
    input.push(line.split(' '));
}).on('close',()=>{
    let hour=0;
    let min=0;
    let tempS=[];
    let tempE=[];
    for(let i=0;i<input.length;i++){
        tempS=input[i][0].split(':');
        tempE=input[i][1].split(':');
        hour+=(Number(tempE[0])-Number(tempS[0]));
        min+=(Number(tempE[1])-Number(tempS[1]));
    }
    min+=(hour*60);
    console.log(min);
})
