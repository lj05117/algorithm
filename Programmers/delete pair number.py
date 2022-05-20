def solution(s):
    s_location=0
    while(s_location<len(s)-1):
        if s[s_location]==s[s_location+1]:
            s=s[:s_location]+s[s_location+2:]
            if s_location !=0:
                s_location-=1
        else:
            s_location+=1
    if s=='':return 1
    return 0
