from itertools import combinations #조합을 구하기 위해 itertools 모듈에서 combinations 함수를 불러온다.
N,M=map(int, input().split()) #N은 도시의 한 줄 수, M은 최대 치킨 가게 수
home=[] #집들의 좌표를 받을 리스트
chicken=[] #치킨가게의 좌표를 받을 리스트
for i in range(N): 
    town_line=list(map(int, input().split())) #도시 한 줄 씩 입력받음
    for j in range(N): 
        if town_line[j]==1: # 집인가?
            home.append([i,j]) 
        elif town_line[j]==2: # 치킨가게인가?
            chicken.append([i,j])

chicken_list=list(combinations(chicken,M)) # M개씩 묶인 치킨 가게 조합을 리스트 안에 넣음
min_distance=float("inf") #최소값을 구하기 위해 우선 무한대로 최소값 설정

for C in chicken_list: #치킨거리 구하기 위해 조합 한 묶음씩 비교
    sum_home_chicken=0 
    for i in range(len(home)): # 모든 집과 C(현재 선택된 치킨가게들) 거리 비교 시작
        home_chicken=min([(abs(home[i][0]-k[0])+abs(home[i][1]-k[1])) for k in C]) # C안에 있는 치킨집 중 home[i]와 제일 짧은 거리를 찾음
        sum_home_chicken+=home_chicken #현재 조합(C)의 치킨거리 구하기
    if min_distance>sum_home_chicken: # 최소값으로 판별된 거리보다 더 적은 치킨거리가 나왔는가?
        min_distance=sum_home_chicken
        
print(min_distance)
