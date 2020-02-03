n = int(input())
pos = 1
flag = False
for i in range(-n//2 + 1,n//2 + 1):
    #printing spaces
    for _ in range(abs(i)):
        print(' ',end='')
    #printing numbers
    for j in range(pos,n-2*(abs(i))+1):
        print(j,end='')
    #printing in reverse order
    for k in range(n-2*(abs(i))-1,pos-1,-1):
        print(k,end='')
    if i < 0:
        pos += 1
    else:
        pos -= 1
    print()