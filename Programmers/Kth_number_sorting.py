def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        cutAndSort=array[commands[i][0]-1:commands[i][1]]
        cutAndSort.sort()
        answer.append(cutAndSort[commands[i][2]-1])
    return answer
