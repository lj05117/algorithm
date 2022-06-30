T=int(input())
for _ in range(T):
    p=list(map(str,input()))
    n=int(input())
    x=eval(input())
    st_i, end_i=0,n
    flip=0
    if p.count('D')<=n:
        for i in p:
            if i=='R':
                flip=(flip+1)%2
            elif flip==0:
                st_i+=1
            else: 
                end_i-=1
        x=x[st_i:end_i]
        if flip:
            print('['+','.join(list(map(str,x[::-1])))+']')
        else:
            print('['+','.join(list(map(str,x)))+']')
    else:
        print('error')