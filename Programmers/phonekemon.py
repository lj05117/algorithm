def solution(nums):
    setnums=set(nums)
    if len(setnums)>len(nums)/2:
        return len(nums)/2
    else: return len(setnums)
