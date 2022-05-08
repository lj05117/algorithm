def solution(answers):
    one=[1,2,3,4,5]*2000
    two=[2,1,2,3,2,4,2,5]*1250
    three=[3,3,1,1,2,2,4,4,5,5]*1000
    onecheck=[i for i in range(len(answers)) if one[i]==answers[i]]
    twocheck=[i for i in range(len(answers)) if two[i]==answers[i]]
    threecheck=[i for i in range(len(answers)) if three[i]==answers[i]]
    maxcheck=[len(onecheck), len(twocheck),len(threecheck)]
    maxlen=max(maxcheck)
    answer=[]
    if len(onecheck)==maxlen:answer.append(1)
    if len(twocheck)==maxlen:answer.append(2)
    if len(threecheck)==maxlen:answer.append(3)
    return answer
