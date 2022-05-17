#the highest and lowest rankings of the lotto
def solution(lottos, win_nums):
    zero=lottos.count(0)
    correctNum=0
    for i in range(6):
        if lottos[i] in win_nums:
            correctNum+=1
    if correctNum>=2:
        low=abs(correctNum-7)
    else: low=6
    high=low-zero
    if low-zero<1:high=1
    return [high,low]
