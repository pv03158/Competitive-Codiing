t = int(input())
n = []
arr = []
for i in range(t):
    n.append(int(input()))
    arr.append(list(map(int, input().split(' ') )))
for array in arr:
    diff = []
    for i in range(len(array)):
        diff.append( i+1 - array[i] )
    counter = 0
    flag = True
    for j in diff:
        if j > 0:
            counter += j
        elif j < -2:
            print('Too chaotic')
            flag = False
            break
    if flag:
        print(counter)