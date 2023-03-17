const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});
let input=[];
rl.on('line',(line)=>{
    input.push(line.split(' '));
}).on('close',()=>{
    // console.log(input)
    if(Number(input[0][0])>Number(input[0][1])){
        console.log('A');
    }else if (Number(input[0][0])<Number(input[0][1])){
        console.log('B')
    }else{
        console.log('same')
    }
})
