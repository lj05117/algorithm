T=int(input())
for i in range(T):
    N=int(input())
    numlist=[0 for j in range(101)]
    score=list(map(int,input().split()))
    for k in range(1000):
        numlist[score[k]]+=1
    sortedlist=sorted(numlist,reverse=True)
    if sortedlist[0]==sortedlist[1]:
        for a in range(100,0,-1):
            if numlist[a]==sortedlist[0]:
                print("#"+str(N)+" "+str(a))
                break
    else:print("#"+str(N)+" "+str(numlist.index(max(numlist))))
