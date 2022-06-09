def solution(s):
    temp=[]
    for i in s:
        if temp!=[]:
            if temp[-1]==i:
                temp.pop()
            else:temp.append(i)
        else:temp.append(i)
    if temp==[]:return 1
    else:return 0
