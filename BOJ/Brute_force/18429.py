N,K=map(int,input().split())
kit=[-1]+list(map(int,input().split()))
way=0
use=[1,-1]
visited=[-1 for _ in range(N+1)]
def dfs(day,num,weight):
    global way
    if day>N:
        return 
    if weight-K+kit[num]>=500:
        weight+=kit[num]-K
        visited[num]=1
        for j in range(2):
            if j==0:
                k=num+1
                while(k<=N):
                    if k!=num+1:
                        newnum=newnum+use[j]
                    else:
                        newnum=num+use[j]
                    if 0<newnum<=N and visited[newnum]!=1:
                        dfs(day+1,newnum,weight)
                        visited[newnum]=-1
                    elif day==N:
                        way+=1
                        return
                    k+=1
            elif j==1:
                k=num-1
                while(0<k):
                    if k!=num-1:
                        newnum=newnum+use[j]
                    else:
                        newnum=num+use[j]
                    if 0<newnum<=N and visited[newnum]!=1:
                        dfs(day+1,newnum,weight)
                        visited[newnum]=-1
                    elif day==N:
                        way+=1
                        return
                    k-=1

for i in range(1,N+1):
    newnum=-1
    dfs(1,i,500)
    visited[i]=-1
print(way)