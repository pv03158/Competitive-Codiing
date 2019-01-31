char_string  = "proRam"
Query = []

Q = int(input())
for _ in range(Q) :
	Query.append(input())

for string in Query :
	counter = 0
	pos = 0
	for i in range(len(char_string)) :
		string = string[pos:] 
		if string.find(char_string[i]) is -1 :
			print("NO")
			break;
		else :
			pos = string.find(char_string[i])
			counter += 1
	if counter is 6 :
		print("YES")