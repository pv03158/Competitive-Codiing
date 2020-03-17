n = int(input())
marks = list(map(int,input().split()))
max_marks = max(marks)
mat = []
for i in range(len(marks)):
    tmp = []
    for j in range(1,max_marks+1):
        if j <= marks[i] :
            tmp.append('* ')
        else:
            tmp.append('  ')
    mat.append(tmp)

for i in range(max_marks-1,-1,-1):
    for j in range(n):
        print(mat[j][i],end='')
    print()
