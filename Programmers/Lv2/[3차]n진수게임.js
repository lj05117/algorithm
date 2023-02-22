function solution(n, t, m, p){
    let answer = '';
    let all='';
    let num=0;
    //toString함수 사용
    //toString에 인자로 원하는 수를 넣으면 해당하는 숫자의 진법으로 표현 된 글자가 나온다.
    //출력돼야 하는 글자 수 * 인원 수
    while(all.length<t*m){
        all+=num.toString(n);
        num+=1;
    }
    //선택 될 글자의 인덱스 수
    let ind=p-1;
    while(answer.length<t){
        //전체 글자 중에서 자신이 말해야 하는 인덱스만 골라내기
        answer+=all.charAt(ind);
        ind+=m;
    }
    //대문자로 변환해서 반환하기
    return answer.toUpperCase();
}
solution(16,16,2,1);