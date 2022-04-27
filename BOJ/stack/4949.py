import sys
while True:
    li=sys.stdin.readline().rstrip()
    if li=='.':break
    li=li.split()
    br=0;seq=[]
    for i in li:
        if br==1:break
        if i.find('(')!=-1 or i.find(')')!=-1 or i.find('[')!=-1 or i.find(']')!=-1:
            reli=list(i)
            for j in range(len(reli)):
                if reli[j]=='(':
                    seq.append('(')
                elif reli[j]==')':
                    if not seq or seq[-1]!='(':
                        print('no')
                        br=1
                        break
                    else:seq.pop()
                elif reli[j]=='[':
                    seq.append('[')
                elif reli[j]==']':
                    if not seq or seq[-1]!='[':
                        print('no')
                        br=1
                        break
                    else:seq.pop()
    if not seq and br!=1:print('yes')
    elif br!=1:print('no')
