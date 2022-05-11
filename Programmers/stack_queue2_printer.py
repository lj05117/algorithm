def solution(priorities, location):
    prioritiesList=[]
    #test=[]
    #for i in range(len(priorities)):
    #    test.append([priorities[i],i])
    test=[[i,p] for i,p in enumerate(priorities)] #위의 주석내용을 list comprehension으로 줄인 코드
    while True:
        J=test.pop(0)
        if len(test)==0:return len(prioritiesList)+1
        if J[1]>=max(priorities):
            prioritiesList.append(J)
            priorities.remove(J[1])
            if J[0]==location:return len(prioritiesList)
        else:test.append(J)
