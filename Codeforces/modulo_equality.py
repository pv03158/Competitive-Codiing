from itertools import permutations

m,n = list(map(int,input().split()))
a = list(map(int,input().split()))
b = list(map(int,input().split()))
b.sort()
for i in range(n):
    tmp = [(i+j)%n for j in a]
    tmp.sort()
    if tmp == b:
        print(i)
        break
