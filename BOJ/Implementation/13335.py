from collections import deque
n,w,L=map(int,input().split())
a=list(map(int,input().split()))
count_n=0
pass_time=0
bridge=deque([0 for _ in range(w)])
end_n=0
while(end_n!=n):
    pass_time+=1
    if sum(bridge)+a[count_n]<=L:
        bridge.append(a[count_n])
    else:
        bridge.append(0)
    end=bridge.popleft()
    if end!=0:
            end_n+=1
    if bridge[-1]!=0:
            count_n+=1



print(pass_time)
