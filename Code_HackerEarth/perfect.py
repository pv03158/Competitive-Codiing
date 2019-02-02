num = int(input())
perfect_num = [66,77];
end = counter = 2
iter = 1

while counter < num:
	iter +=1;
	for i in range(0,end):
		perfect_num.append(int("6" + str(perfect_num[i]) + "6"))
		counter += 1

	for i in range(0,end):
		perfect_num.append(int("7" + str(perfect_num[i]) + "7"))
		counter += 1
		start = end;
		end = end+2**iter
print(perfect_num[num-1])
