n=int(input())
cnt=0
for i in range((n+1)*3600):
    if i//3600==3 or i%3600//600==3 or i%3600//60%10==3 or i%3600%60//10==3 or i%3600%60%10==3:
        cnt+=1
print(cnt)
