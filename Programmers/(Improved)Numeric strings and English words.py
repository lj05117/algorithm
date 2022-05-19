def solution(s):
    for num,numstr in enumerate(['zero','one','two','three','four','five','six','seven','eight','nine']):
        s=s.replace(numstr,str(num))
    return int(s)
