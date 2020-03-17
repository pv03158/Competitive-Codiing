n = int(input())
for i in range(1,n+1):
    for j in range(1,i+1):
        print(j,end=' ')
    #printing spaces
    if i != n:
        for j in range(2*(n-i)-1):
            print(' ',end=' ')
        for k in range(i,0,-1):
            print(k,end=' ')
    else:
        for k in range(i-1,0,-1):
            print(k,end=' ')
    print()
        