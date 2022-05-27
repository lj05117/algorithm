K=int(input())
def snali(N,li):
    input_num=0;
    r=0;c=0
    while(input_num<N*N):
        while(c<N):
            if li[r][c]==0:
                input_num+=1
                li[r][c]=input_num
                c+=1
            else:break
        c-=1
        r+=1
        while(r<N):
            if li[r][c]==0:
                input_num+=1
                li[r][c]=input_num
                r+=1
            else:break
        r-=1
        c-=1
        while(c>=0):
            if li[r][c]==0:
                input_num+=1
                li[r][c]=input_num
                c-=1
            else:break
        c+=1
        r-=1
        while(r>=0):
            if li[r][c]==0:
                input_num+=1
                li[r][c]=input_num
                r-=1
            else:
                break
        r+=1
        c+=1



for i in range(K):
    N=int(input())
    print('#',i+1)
    li=[[0 for j in range(N)]for k in range(N)]
    snali(N, li)
    for n in range(N):
        for m in range(N):
            print(li[n][m],end=" ")
        print()
    
