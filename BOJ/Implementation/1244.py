N=int(input())
studentList=[-1]+list(map(int,input().split()))
peopleN=int(input())
def switch(in_n):
    if studentList[in_n]==0:
        studentList[in_n]=1
    else:
        studentList[in_n]=0

for _ in range(peopleN):
    sex,ch_n=map(int, input().split())
    if sex==1:
        i=1
        while(ch_n*i<=N):
            switch(ch_n*i)
            i+=1
    else:
        switch(ch_n)
        i=1
        while(ch_n-i>0 and ch_n+i<=N):
            if studentList[ch_n-i]==studentList[ch_n+i]:
                switch(ch_n-i)
                switch(ch_n+i)
                i+=1
            else:break
for i in range(1,N+1):
    print(studentList[i],end=" ")
    if i%20==0:print()