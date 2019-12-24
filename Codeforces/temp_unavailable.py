import math

t = int(input())
case = []
for i in range(t):
    case.append(list(map(int,input().split())))

for i in range(len(case)):
    a = case[i][0]
    b = case[i][1]
    c = case[i][2]
    r = case[i][3]

    b1 = c-r
    b2 = c+r

    if r >= abs((a-c)):
        d1 = 0
    else:
        d1 = min( abs((b1-a)),abs((b2-a)) )
    if r >= abs((b-c)):
        d2 = 0
    else:
        d2 = min( abs((b-b1)),abs((b-b2)) )
    print(min(d1+d2,abs(b-a)))