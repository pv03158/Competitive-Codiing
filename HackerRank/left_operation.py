n,d = list(map(int,input().split(' ')))
arr = list(map(int,input().split(' ')))
arr = arr[d:] + arr[:d]
print(*arr)