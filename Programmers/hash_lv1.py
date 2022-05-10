#완주하지 못한 선수
def solution(participant, completion):
    check=list(set(participant)-set(completion))
    if len(check)==1:return check[0]
    else:
        participant.sort()
        completion.sort()
        for i in range(len(completion)):
            if participant[i]!=completion[i]:
                return participant[i]
        return participant[-1]
