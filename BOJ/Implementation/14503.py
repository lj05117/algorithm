N,M=map(int,input().split())
r,c,d=map(int,input().split())
space=[]
for _ in range(N):
    space.append(list(map(int,input().split())))
dx=[-1,0,1,0] #북, 동, 남, 서
dy=[0,1,0,-1]
cnt=0


while(True):
    go_back=0
    a=0
    if space[r][c]==0:
        space[r][c]=2
        cnt+=1
    while(a!=4):
        d-=1
        if d<0:d+=4
        if 0<=r+dx[d]<N and 0<=c+dy[d]<M and space[r+dx[d]][c+dy[d]]==0:
            r+=dx[d]
            c+=dy[d]
            break
        a+=1
    if a==4:
        if go_back==0:
            d-=2
            if d<0:d+=4
            if space[r+dx[d]][c+dy[d]]==1:
                break
            else:
                r+=dx[d]
                c+=dy[d]
                d+=2
                if d>3:d-=4

print(cnt)