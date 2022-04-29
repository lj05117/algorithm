def dfs(ice, r,c,N,M):
    if ice[r][c]==0:
        ice[r][c]=2
        if c!=M-1:
            dfs(ice,r,c+1,N,M)
        if r!=N-1:
            dfs(ice,r+1,c,N,M)
    else:return

N,M=input().split()
ice=[]
cnt=0;jn=0;
for i in range(int(N)):
    icerow=list(map(int,input().strip()))
    ice.append(icerow)
for j in ice:
    kn=0
    for k in j:
        if k==0:
            dfs(ice,jn,kn,int(N),int(M))
            cnt+=1
        kn+=1
    jn+=1
print(cnt)
