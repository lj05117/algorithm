N=int(input())
numlist=list(map(int, input().split()))
line=[]
for i in range(N-1,-1,-1):
    line.insert(numlist[i],i+1)
for j in range(N):
    print(line[j],end=" ")
