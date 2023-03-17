function solution(s) {
    let sLen = s.length;
    if(sLen%2===0){
        return s[sLen/2-1]+s[sLen/2];    
    }else{
        return s[parseInt(sLen/2)];
    }
    
}