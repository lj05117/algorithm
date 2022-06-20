from collections import deque
N,M=map(int, input().split())
ocean=[]
shark=deque()
for i in range(N):
    ocean.append(list(map(int, input().split())))
    for j in range(M):
        if ocean[i][j]==1:
            shark.append([i,j])
mx=[0,-1,-1,-1,0,1,1,1]
my=[-1,-1,0,1,1,1,0,-1]
count=0
while(shark):
    x,y=shark.popleft()
    for k in range(8):
        nowx=x+mx[k]
        nowy=y+my[k]
        if 0<=nowx<N and 0<=nowy<M and ocean[nowx][nowy]==0:
            shark.append([nowx,nowy])
            ocean[nowx][nowy]=ocean[x][y]+1
            if ocean[nowx][nowy]>count:
                count=ocean[nowx][nowy]
print(count-1)

