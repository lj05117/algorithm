import sys
def dfs(r,c,sum):
    if numMap[r][c]==1:
        numMap[r][c]=2
        sum+=1 
        if c!=0 and numMap[r][c-1]==1:
            sum+=dfs(r,c-1,0)
        if c<N-1 and numMap[r][c+1]==1:
            sum+=dfs(r,c+1,0) 
        if r!=0 and numMap[r-1][c]==1:
            sum+=dfs(r-1,c,0)
        if r<N-1 and numMap[r+1][c]==1:
            sum+=dfs(r+1,c,0)
    return sum


N=int(sys.stdin.readline())
numMap=[]
cnt=0;sum1=0;sum2=0;sum3=0;sum4=0
sumcnt=[0]*(N*N)
for i in range(N):
    numMap.append(list(map(int,sys.stdin.readline().strip())))
for i in range(N):
    for j in range(N):
        if numMap[i][j]==1:
            sumcnt[cnt]=dfs(i,j,0)
            cnt+=1
del sumcnt[cnt:]
sumcnt.sort()
print(cnt)
for i in range(cnt):
    print(sumcnt[i])