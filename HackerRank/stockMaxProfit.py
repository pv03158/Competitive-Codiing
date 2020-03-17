k = int(input())
n = int(input())
arr = list(map(int,input().split()))

dp_memoization = [ [ 0 for _ in range(n) ] for _ in range(k+1) ]
for i in range(1,k+1):
    for j in range(1,n):
        max_val_candidate = [ dp_memoization[i][j-1] ]      ## INSERTING PROFIT VAL IF TRANSACTION IS NOT DONE
        for m in range(j):
            if m-1 >= 0:       ## CHECKING WHETHER m-1 DOESN'T LIES OUTSIDE THE MATRIX
                max_val_candidate.append( arr[j] - arr[m] + dp_memoization[i-1][m-1] )
            else:
                max_val_candidate.append( arr[j] - arr[m] + 0 )
        dp_memoization[i][j] = max(max_val_candidate)
print(dp_memoization[-1][-1])