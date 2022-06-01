def solution(absolutes, signs):
    answer = 0
    while(absolutes):
        if signs[0]==True:
            answer+=absolutes[0]
        else:answer-=absolutes[0]
        del absolutes[0]
        del signs[0]
    return answer
