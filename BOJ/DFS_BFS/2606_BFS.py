import sys
from collections import defaultdict,deque
nodeNum=int(sys.stdin.readline())
edgeNum=int(sys.stdin.readline())
linkedNode=defaultdict(list)
for i in range(edgeNum):
    n1,n2=map(int,sys.stdin.readline().split())
    linkedNode[n1].append(n2)
    linkedNode[n2].append(n1)
for i in linkedNode.keys():
    linkedNode[i]=sorted(linkedNode[i])
queue=deque()
visited=[0]*(nodeNum+1)
cnt=0
queue.append(1)
while queue:
    now=queue.popleft()
    for i in linkedNode[now]:
        if not visited[i]:
            visited[i]=1
            queue.append(i)
            cnt+=1
print(cnt-1)