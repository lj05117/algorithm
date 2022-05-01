import sys
def dfs(li,V,r,c,numli):
    if V!=0:
        print(V,end=" ")
        numli.remove(V)
    if not numli:return
    if li[r][c] in numli:
        print(li[r][c],end=" ")
        numli.remove(li[r][c])
        dfs(li,0,li[r][c],0,numli)
    if len(li[r])-1>c:
        dfs(li,0,r,c+1,numli)
    if r<len(li):
        dfs(li,0,r+1,0,numli)
    
        
N,M,V=map(int,sys.stdin.readline().split())
li=[[0]for i in range(N+1)]
numli=[]
for i in range(M):
    n1,n2=map(int,sys.stdin.readline().split())
    if n1 not in numli:numli.append(n1)
    if n2 not in numli:numli.append(n2)
    if li[n1][0]==0:
        li[n1][0]=n2
    else:
        li[n1].append(n2)
        li[n1].sort()
    if li[n2][0]==0:
        li[n2][0]=n1
    else:
        li[n2].append(n1)
        li[n2].sort()
dfs(li,V,V,0,numli)
