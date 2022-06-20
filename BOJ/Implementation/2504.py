L=list(input())
temp=1
sum=0
merge=[]
for i in range(len(L)):
    if L[i]=='(':
        temp*=2
        merge.append('(')
    elif L[i]=='[':
        temp*=3
        merge.append('[')
    elif L[i]==')':
        if not merge or merge[-1]!='(':
            sum=0
            break
        if L[i-1]=='(':
            sum+=temp
        temp//=2
        merge.pop()
    else:
        if not merge or merge[-1]!='[':
            sum=0
            break
        if L[i-1]=='[':
            sum+=temp
        temp//=3
        merge.pop()
if merge:print(0)
else:print(sum)