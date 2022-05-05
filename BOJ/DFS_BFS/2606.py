import sys
from collections import defaultdict
def dfs(V,cnt):
    if visited[V]:return cnt
    visited[V]=1
    cnt+=1
    for i in connectedNode[V]:
        cnt=dfs(i,cnt)
    return cnt

nodeNum=int(sys.stdin.readline())
edgeNum=int(sys.stdin.readline())
connectedNode=defaultdict(list)
for i in range(edgeNum):
    n1,n2=map(int,sys.stdin.readline().split())
    connectedNode[n1].append(n2)
    connectedNode[n2].append(n1)
for i in connectedNode.keys():
    connectedNode[i]=sorted(connectedNode[i])
visited=[0]*(nodeNum+1)
cnt=0
print(dfs(1,cnt)-1)