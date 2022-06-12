from itertools import combinations
N,M=map(int, input().split())
home=[]
chicken=[]
for i in range(N):
    town_line=list(map(int, input().split()))
    for j in range(N):
        if town_line[j]==1:
            home.append([i,j])
        elif town_line[j]==2:
            chicken.append([i,j])

chicken_list=list(combinations(chicken,M))
min_distance=float("inf")

for C in chicken_list:
    sum_home_chicken=0
    for i in range(len(home)):
        home_chicken=min([(abs(home[i][0]-k[0])+abs(home[i][1]-k[1])) for k in C])
        sum_home_chicken+=home_chicken
    if min_distance>sum_home_chicken:
        min_distance=sum_home_chicken

print(min_distance)
