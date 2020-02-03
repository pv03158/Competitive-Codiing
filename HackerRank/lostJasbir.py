n = int(input())
arr = list(map(int,input().split()))
max_ele = arr.index(max(arr))
arr = list(set(arr))
se = int(input())

## applying binary search here
lb = 0
ub = n-1
flag = False
while lb <= ub:
    mid = ( lb+ub ) // 2
    if se ==  arr[mid]:
        print(mid+max_ele+1)
        flag = True
        break
    elif se < arr[mid]:
        ub = mid - 1
    elif se > arr[mid]:
        lb = mid + 1

if flag == False:
    print(-1)