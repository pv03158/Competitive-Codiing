x = []
p = []
def contains(str1,str2):
	if str1 == str2[:len(str1)+1] :
		return True
	else:
		return False

def shortHandNotation(x,string):
	for i in range(1,len(string)+1):
			for str1 in x:
				if not contains(string[:i],str1)  :
					p.append(string[:i])
					return 

n = int(input())
for _ in range(n):
	tmp = input()
	x.append(tmp)

for string in x :
	tmp = x
	tmp.remove(string)
	if string[0] not in p:
		p.append(string[0])
	else:
		shortHandNotation(tmp,string)

for string in p:
	print(string) 
