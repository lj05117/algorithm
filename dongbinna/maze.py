def dfs(maze, r,c,N,M,cnt):
    if maze[r][c]==1:
        cnt+=1
        maze[r][c]=2
    elif maze[r][c]==2:pass
    else:return
    if r==N-1 and c==M-1:print(cnt)
    if c!=M-1:dfs(maze,r,c+1,N,M,cnt)
    if r!=N-1:dfs(maze, r+1,c,N,M,cnt)

N,M=input().strip().split()
maze=[]
for i in range(int(N)):
    row=list(map(int,input()))
    maze.append(row)
dfs(maze,0,0,int(N),int(M),cnt=0)
