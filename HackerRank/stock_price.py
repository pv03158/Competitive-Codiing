k = int(input())
n = int(input())
arr = list(map(int,input().split()))

lb = 0
ub = len(arr)
to_sum = []
def max_profit(array):
    profits = []
    for i in range(len(array)-1):
        tmp = []
        for j in range(i+1,len(array)):
            tmp.append(abs(array[i]-array[j]))
        profits.append(tmp)
    tmp = []
    for i in range(len(profits)):
        tmp.append(profits[i][-1])
    if len(tmp) > 0:
        return ( tmp.index(max(tmp))+1,max(tmp) )
    else:
        return ( 0,0 )

index,profit = max_profit( arr[lb:ub] )
while index > 0:
    index,profit = max_profit( arr[lb:ub] )
    print(index,profit)
    to_sum.append(profit)
    if index > lb:
        ub = index
        max_profit(arr[lb:ub])
    else:
        break

print(to_sum)
sumation = 0
for i in range(k):
    sumation += to_sum[i]
print(sumation)