def maxProfit(prices,n,k):
    profit_arr = [[0 for i in range(n)] for j in range(k+1) ]
    for i in range(1,k+1):
        for j in range(1,n):
            max_val = 0
            for m in range(i):
                max_val = max(max_val,prices[j]-prices[m]+profit_arr[i-1][m])
            profit_arr[i][j] = max(profit_arr[i][j-1], max_val)
    print(profit_arr)
    return profit_arr[k][n-1]

# k=int(input())
# size=int(input())
# prices = list(map(int,input().split()))
# n = len(prices)
k = 3
# prices = [10, 22, 5, 75, 65, 80] 
prices = [2,5,7,1,4,3,1,3]
n=len(prices)
print(maxProfit(prices,n,k))
