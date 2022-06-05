def solution(n):
    answer = 0
    i=0
    while(n):
        answer+=(n//(3**i)%3)*(10**i)
        n-=n%3**i
        i+=1
    while(answer%10==0):
        answer//=10
    li=list(map(str,str(answer).strip()))
    answer=0
    for i in range(len(li)):
        answer+=int(li[i])*(3**i)
    return answer
