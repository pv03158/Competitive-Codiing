Q = int(raw_input())
X = []
for _ in range(Q) :
	tmp = int(raw_input())
	if tmp < 10 :
		tmp = "00" + str(tmp)
	elif tmp < 100 :
		tmp = "0" + str(tmp)
	else : 
		tmp = str(tmp)
	X.append(tmp)

for num in X :
	TotalBits = 0
	for bit in num :
		if int(bit) is 1 :
			TotalBits += 2
		if int(bit) is 2 or int(bit) is 3 or int(bit) is 5 :
			TotalBits += 5
		if int(bit) is 4 :
			TotalBits += 4
		if int(bit) is 6 or int(bit) is 0 or int(bit) is 9 :
			TotalBits += 6
		if int(bit) is 7 :
			TotalBits += 3
		if int(bit) is 8 :
			TotalBits += 7
	MaxNumber = "111"
	if TotalBits > 6 and TotalBits < 11:
		if TotalBits is 7 :
			MaxNumber[0] = "7"
		if TotalBits is 8 :
			MaxNumber[0] = "4"
		if TotalBits is 9 :
			MaxNumber[0] = "5"
		if TotalBits is 10 :
			MaxNumber[0] = "9"
	if TotalBits > 10 :
		if TotalBits is 11 :
			MaxNumber = "971"
		if TotalBits is 12 :
			MaxNumber = "941"
		if TotalBits is 13 :
			MaxNumber = "951"
		if TotalBits is 14 :
			MaxNumber = "991"
		if TotalBits is 15 :
			MaxNumber = "997"
		if TotalBits is 16 :
			MaxNumber = "994"
		if TotalBits is 17 :
			MaxNumber = "995"
		if TotalBits is 18 :
			MaxNumber = "999"
		if TotalBits is 19 :
			MaxNumber = "998"
		if TotalBits is 20 :
			MaxNumber = "988"
		if TotalBits is 21 :
			MaxNumber = "888"
	print(1000-int(MaxNumber))

