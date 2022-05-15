def solution(id_list, report, k):
    report=list(set(report))
    userlist=[[i,0] for i in id_list]
    answer=[0 for i in id_list]
    for i in range(len(report)):
        user,baduser=report[i].split()
        userlist[id_list.index(baduser)][1]+=1
    for i in range(len(report)):
        user,baduser=report[i].split()
        if userlist[id_list.index(baduser)][1]>=k:
            answer[id_list.index(user)]+=1
        
    return answer
