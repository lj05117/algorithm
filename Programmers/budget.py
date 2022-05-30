def solution(d, budget):
    d.sort()
    answer = 0
    sum_budget=0
    if sum(d)<=budget: return len(d)
    while(sum_budget<=budget):
        sum_budget+=d[answer]
        answer+=1
    answer-=1
    return answer
