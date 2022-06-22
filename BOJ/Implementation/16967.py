H,W,X,Y=map(int, input().split())
B=[]
A=[[0 for a in range(W)]for b in range(H)]
for i in range(H+X):
    B.append(list(map(int,input().split())))

for k in range(H):
    for l in range(W):
        if X<=k and k<=H and Y<=l and l<=W:
            A[k][l]=B[k][l]-A[k-X][l-Y]
        else:
            A[k][l]=B[k][l]
for c in range(len(A)):
    for b in range(len(A[0])):
        print(A[c][b],end=" ")
    print()
