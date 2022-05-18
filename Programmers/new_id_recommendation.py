def solution(new_id):
    answer = ''
    i=0
    while i<len(new_id):
        if 65<=ord(new_id[i])<=90:#대문자인가
            answer+=chr(ord(new_id[i])+32)
        #소문자, 숫자, 빼기, 밑줄, 마침표
        elif 97<=ord(new_id[i])<=122 or 48<=ord(new_id[i])<=57 or new_id[i]=='_'or new_id[i]=='-':
            answer+=new_id[i]
        elif new_id[i]=='.' and answer!='':
            if answer[-1]!='.':
                answer+='.'
        i+=1
    #if answer[0]=='.':
    #    answer=answer[1:]
    if answer and answer[-1]=='.':
        answer=answer[:-1]
    if answer=='':
        answer='a'
    if len(answer)>15:
        answer=answer[:15]
        if answer[-1]=='.':
            answer=answer[:-1]
    elif len(answer)<3:
        answer+=answer[-1]*3
        answer=answer[:3]

           
    
    return answer
