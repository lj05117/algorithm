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

if N%4==1:
    for a in range(R):
        for b in range(C):
            print(board[a][b], end="")
        print()
else:
    for k in range(R):
        for l in range(C):
            board[k][l]='O'
    if N%2!=0:
        for d in range(len(position_O)):
            for c in range(5):
                xpos=x[c]+position_O[d][0]
                ypos=y[c]+position_O[d][1]
                if 0<=xpos<R and 0<=ypos<C:
                    board[xpos][ypos]='.'
    for e in range(R):
        for d in range(C):
            print(board[e][d], end="")
        print()