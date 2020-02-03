n = int(input())
arr = list(map(int,input().split()))

counter = 0
sum = 0
for i in arr:
    if i > counter:
        counter = i
        sum += counter
print(sum)