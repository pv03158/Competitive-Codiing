n,m = list(map(int,input().split()))
coins = list(map(int,input().split()))

dp_memo_table = [[0 for _ in range(n+1)] for _ in range(len(coins))]
for i in range(len(coins)):
    for j in range(1,n+1):
        if j < coins[i]:
            dp_memo_table[i][j] = 0
        else:
            rem_val = j - coins[i]
            if rem_val == 0:
                possible_ways = 1
            else:
                possible_ways = 0
                for k in range(i+1):
                    possible_ways += dp_memo_table[k][rem_val]
            dp_memo_table[i][j] = possible_ways
print(sum([ dp_memo_table[i][-1] for i in range(len(coins))]))