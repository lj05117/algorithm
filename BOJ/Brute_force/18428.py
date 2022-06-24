N=int(input())
board=[]
teacher=0
for i in range(N):
    one_line=list(map(str,input().split()))
    teacher+=one_line.count('T')
    board.append(one_line)

x=[-1,1,0,0]
y=[0,0,-1,1]

def countT(dx,dy):
    for i in range(4):
        nx=x[i]+dx
        ny=y[i]+dy
        while(0<=nx<N and 0<=ny<N and board[nx][ny]!='O'):
            if board[nx][ny]=='S':
                return True
            nx+=x[i]
            ny+=y[i]
    return False

def solution(count):
    global answer
    if count==3:
        cnt=0
        for i in range(N):
            for j in range(N):
                if board[i][j]=='T':
                    if not countT(i,j):
                        cnt+=1
        if cnt==teacher:
            answer=True
        return 
    for i in range(N):
        for j in range(N):
            if board[i][j]=='X':
                board[i][j]='O'
                count+=1
                solution(count)
                board[i][j]=='X'
                count-=1



answer=False

solution(0)
if answer==False:
    print('NO')
else:print('YES')