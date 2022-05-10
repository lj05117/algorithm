def solution(name):
    answer = 0
    zeroCount=0
    maxzero=0
    for i in range(len(name)):
        num=13-abs(ord(name[i])-78)
        answer+=num
        if num==0:
            zeroCount+=1
        elif i>0 and name[i-1]=='A':
            if maxzero<zeroCount:
                maxzero=zeroCount
                zeroCount=0
    if zeroCount==0 and maxzero==0:return answer+len(name)-1
    for i in range(len(name)):
        if name[-i-1]=='A':
            answer-=1
        else:break

    return answer+len(name)-1-maxzero
