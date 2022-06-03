def solution(board, moves):
    basket=[]
    answer=0
    for i in range(len(moves)):
        j=0
        while(j<len(board[0])):
            if board[j][moves[i]-1]!=0:
                basket.append(board[j][moves[i]-1])
                board[j][moves[i]-1]=0
                break
            j+=1
    j=0
    while(len(basket)>j+1):
        if basket[j]==basket[j+1]:
            del basket[j],basket[j]
            answer+=2
            j=0
        else:j+=1

    return answer
