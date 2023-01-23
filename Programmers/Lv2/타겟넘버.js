var answer=0;
function solution(numbers, target){
    dfs(0, numbers.length, target, 0, numbers);
    console.log(answer);
    return answer;
}
function dfs(index,len, target, sum, numbers){
    if(index==len){
        if(target==sum){
            answer+=1;
        }
        return;
    }
    dfs(index+1, len, target, sum+numbers[index], numbers);
    dfs(index+1, len, target, sum-numbers[index], numbers);
}
// solution([1,1,1,1,1],3);
