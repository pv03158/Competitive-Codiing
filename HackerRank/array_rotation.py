n = int(input())
arr = list(map(int,input().split()))

max_pos = arr.index(max(arr))
arr = arr[max_pos+1:] + arr[0:max_pos+1]

sum = 0
for i in range(len(arr)):
    sum += i*arr[i]
print(sum)