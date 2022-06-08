def solution(a, b):
    month=[31,29,31,30,31,30,31,31,30,31,30,31]
    day_num=sum(month[:a-1])+b
    day=['THU','FRI','SAT','SUN','MON','TUE','WED']
    answer=day[day_num%7]
    return answer
