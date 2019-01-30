x = int(input())
y = int(input())
z = int(input())
n = int(input())

poss_corr = []
for i in range(x+1):
	for j in range(y+1):
		for k in range(z+1):
			if i+j+k != n :
				poss_corr.append([i,j,k])
print(poss_corr)
