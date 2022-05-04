import sys
from collections import defaultdict,deque
def dfs(V):
    if visited_node[V]:
        return
    visited_node[V]=1
    print(V,end=" ")
    for i in dic_N[V]:
        dfs(i)
    
N,M,V=map(int,sys.stdin.readline().split())
dic_N=defaultdict(list)
for i in range(M):
    N1,N2=map(int,sys.stdin.readline().split())
    dic_N[N1].append(N2)
    dic_N[N2].append(N1)
for i in dic_N.keys():
    dic_N[i]=sorted(dic_N[i])
visited_node=[0]*(N+1)
dfs(V)
print()
queue=deque()
queue.append(V)
bfs_visited=[0]*(N+1)
bfs_visited[V]=1
while queue:
    pop_queue=queue.popleft()
    print(pop_queue,end=" ")
    for i in dic_N[pop_queue]:
        if not bfs_visited[i]:
            queue.append(i)
            bfs_visited[i]=1