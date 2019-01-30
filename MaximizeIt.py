tmp = input().split(" ")
k = int(tmp[0])
m = int(tmp[1])
rawlist = []
sumation = 0

def large(sliced_list):
	largest = sliced_list[0]
	print("Finding : ")
	for i in sliced_list:
		print((i*i)%m)
		if (i*i)%m > (largest*largest)%m :
			largest = i;
	return largest

for _ in range(k):
	tmp = input().split(" ")
	tmp = list(map(int,tmp))
	rawlist.append(tmp)
for i in rawlist:
	tmp = large(i)
	print(tmp)
	sumation += tmp*tmp
print(sumation%m)
