N=int(input())
def dfs(mirrow,room,money):
    global answer
    mo=int(mirrow[room][1])
    if mirrow[room][0]=='E':
        pass
    elif mirrow[room][0]=='L':
        if money<mo:
            money=mo
    else:
        if money<mo:
            return 
        else:
            money-=mo
    if room==N:
        answer='Yes'
        return
    visited[room]=1
    nextroom=mirrow[room][2:]
    nextroom.pop()
    for j in range(len(nextroom)):
        nextroom[j]=int(nextroom[j])
        if nextroom[j]!=room and visited[nextroom[j]]!=1:
            dfs(mirrow,nextroom[j],money)




while(N!=0):
    answer='No'
    mirrow=[[]]
    visited=[0 for i in range(N+1)]
    for i in range(N):
        mirrow.append(list(map(str,input().split())))
    dfs(mirrow,1,0)
    print(answer)
    N=int(input())