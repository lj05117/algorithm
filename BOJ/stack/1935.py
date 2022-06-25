n=int(input())
ex=list(map(str, input()))
num=[0 for _ in range(n)]
for i in range(n):
    num[i]=int(input())

num_list=[]
for j in ex:
    if 'A'<=j<='Z':
        num_list.append(num[ord(j)-ord('A')])
    else:
        num2=num_list.pop()
        num1=num_list.pop()
        if j=='*':
            num_list.append(num1*num2)
        elif j=='/':
            num_list.append(num1/num2)
        elif j=='+':
            num_list.append(num1+num2)
        else:
            num_list.append(num1-num2)

print('%.2f' %num_list[0])