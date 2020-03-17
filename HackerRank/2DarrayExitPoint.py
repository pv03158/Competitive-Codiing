r,c = list(map(int,input().split()))
mat = []
for i in range(r):
    tmp = list(map(int,input().split()))
    mat.append(tmp)
curr_direction = 1  ## 0 for going North, 1 for East, 2 for south and 3 for going west
prev_i = prev_j = i = j = 0
while True:
    prev_i = i
    prev_j = j
    if curr_direction == 0:
        i -= 1
    elif curr_direction == 1:
        j += 1
    elif curr_direction == 2:
        i += 1
    elif curr_direction == 3:
        j -= 1
    # checking exit conditions
    if i in [-1,r] or j in [-1,c]:
        print(prev_i,prev_j,sep=', ')
        break
    # changing direction of movement
    if mat[i][j] == 1:
            curr_direction = (curr_direction + 1) % 4
