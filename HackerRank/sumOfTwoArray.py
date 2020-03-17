n = int(input())
arr1 = list(map(int,input().split()))
m = int(input())
arr2 = list(map(int,input().split()))
res = []
# creating size of both array of equal dimensions
if len(arr1) > len(arr2):
    for i in range(len(arr1)-len(arr2)):
        arr2.insert(0,0)
else:
    for i in range(len(arr2)-len(arr1)):
        arr1.insert(0,0)
carry = 0
sum = 0
for i in range(len(arr1)-1,-1,-1):
    sum = carry + arr1[i] + arr2[i]
    if sum >= 10:
        carry = sum // 10
        sum = sum % 10
    else:
        carry = 0
    res.insert(0,sum)
if carry > 0:
    res.insert(0,carry)
print(*res,sep=' ')