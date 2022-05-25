def solution(numbers):
    numbers=list(map(str,numbers))
    numbers=sorted(numbers,reverse=True)
    answer=''
    for i in range(len(numbers)-1):
        if numbers[i][0]==numbers[i+1][0]:
            if len(numbers[i+1])<len(numbers[i]) and numbers[i][1]<=numbers[i][0]:
                numbers[i+1],numbers[i]=numbers[i],numbers[i+1]
        answer+=numbers[i]
    answer+=numbers[-1]
    return answer
