R,C,N=map(int, input().split())
board=[]
position_O=[]
x=[-1,0,1,0,0]
y=[0,-1,0,1,0]

for i in range(R):
    board.append(list(map(str,input())))
    for j in range(C):
        if board[i][j]=='O':
            position_O.append([i,j])
if N%2==0:
    board=[['O' for k in range(C)]for l in range(R)]
else:
    while((N-1)//2!=0):
        new_position=[]
        board=[['O' for k in range(C)]for l in range(R)]
        N-=2
        for d in range(len(position_O)):
            for c in range(5):
                xpos=x[c]+position_O[d][0]
                ypos=y[c]+position_O[d][1]
                if 0<=xpos<R and 0<=ypos<C:
                    board[xpos][ypos]='.'
        for a in range(R):
            for b in range(C):
                if board[a][b]=='O':
                    new_position.append([a,b])
        position_O=new_position

for e in range(R):
    for d in range(C):
        print(board[e][d], end="")
    print()

