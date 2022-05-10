#기능 개발 문제
def solution(progresses, speeds):
    answer = []
    cnt=0
    while sum(answer)!=len(progresses):
        if cnt+sum(answer)==len(progresses):
            answer.append(cnt)
            break
        for i in range(len(progresses)):
            progresses[i]+=speeds[i]
        for j in range(sum(answer),len(progresses)):
            if progresses[j]>=100:
                cnt+=1
            elif cnt!=0:
                answer.append(cnt)
                cnt=0
                break
            else:break
    return answer
