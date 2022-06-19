def two(i):
    if len(L)>i and fail!=1:
        if L[i]!=')':
            if L[i]=='[':
                three(i)
            else:
                fail=1
                return 0
def three(i):
    if len(L)>i and fail!=1:
        if L[i]!=']':
            if L[i]=='(':
                two(i)
            else:
                fail=1
                return 0


L=list(map(str, input()))
merge=[]
i=0
sum=0
fail=0
while(L):
    if L[i]=='(':
        i+=1
        two(i)

    if L[i]=='[':
        i+=1
        three(i)
    if fail==1:
        print(0)
        break

if fail==0:
    print(sum)