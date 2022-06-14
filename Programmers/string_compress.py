def solution(s):
    if len(s)//2==0:#s가 한 글자인가?
        return len(s)
    else:
        len_repeat=len(s)//2 #반복되는 문자 탐색을 위한 문자 길이 설정
    minlen=len(s)#최소 길이를 의미하는 변수
    while(len_repeat!=0): #문자 길이가 1일 때 까지
        i=0
        new_s=''
        while((i+len_repeat)<=len(s)): 
            repeat=s[i:len_repeat+i]
            if len(s[len_repeat:])>=len(repeat):
                num=0
                new_s+=repeat
                while(s[i:len_repeat+i]==repeat):
                    num+=1
                    i+=len(repeat)
                if num!=1:
                    new_s+=str(num)

            else:
                new_s+=s[len_repeat:]
                break
            #i+=len_repeat
        if i!=len(s):
            new_s+=s[i:]
        minlen=min(len(new_s),minlen)
        len_repeat-=1

    return minlen