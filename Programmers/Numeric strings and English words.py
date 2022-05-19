def solution(s):
    answer = ''
    length=0
    while(length!=len(s)):
        #3,4,5
        if s[length]=='z':
            answer+='0'
            length+=4
        elif s[length]=='o':
            answer+='1'
            length+=3
        elif s[length]=='t':
            if s[length+1]=='w':
                answer+='2'
                length+=3
            else:
                answer+='3'
                length+=5
        elif s[length]=='f':
            if s[length+1]=='o':
                answer+='4'
                length+=4
            else:
                answer+='5'
                length+=4
        elif s[length]=='s':
            if s[length+1]=='i':
                answer+='6'
                length+=3
            else:
                answer+='7'
                length+=5
        elif s[length]=='e':
            answer+='8'
            length+=5
        elif s[length]=='n':
            answer+='9'
            length+=4
        else:
            answer+=s[length]
            length+=1

    return int(answer)
