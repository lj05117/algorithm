def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    duplication=[]
    for i in lost:
        if i in reserve:
            duplication.append(i)
    lost=list(set(lost)-set(duplication))
    reserve=list(set(reserve)-set(duplication))
    for i in lost:
        if i-1 in reserve:
            reserve.remove(i-1)
        elif i+1 in reserve:
            reserve.remove(i+1)
        else:n-=1
    answer=n
    return answer
