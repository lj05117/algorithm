def solution(price, money, count):
    money_list=[price*n for n in range(1,count+1)]
    answer=sum(money_list)
    if answer>money:
        return answer-money
    else:return 0
