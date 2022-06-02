def solution(numbers, hand):
    answer = ''
    left_finger=10
    right_finger=12
    while(numbers):
        if numbers[0]%3==1:
            answer+='L'
            left_finger=numbers[0]
        elif numbers[0]%3==0 and numbers[0]!=0:
            answer+='R'
            right_finger=numbers[0]
        else:
            if numbers[0]==0:numbers[0]=11
            if left_finger%3==1:
                distance_l=left_finger+1
                plus_l=1
            else:
                distance_l=left_finger
                plus_l=0
            distance_l=abs(distance_l-numbers[0])//3+plus_l
            
            if right_finger%3==0:
                distance_r=right_finger-1
                plus_r=1
            else:
                distance_r=right_finger
                plus_r=0
            distance_r=abs(distance_r-numbers[0])//3+plus_r                                                      
            if distance_l<distance_r:
                answer+='L'
                left_finger=numbers[0]
            elif distance_r<distance_l:
                answer+='R'
                right_finger=numbers[0]
            else:
                answer+=hand[0]
                if hand[0]=='r':right_finger=numbers[0]
                else:left_finger=numbers[0]
        del numbers[0]
    return answer.upper()
