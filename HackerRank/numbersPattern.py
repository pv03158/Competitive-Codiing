x = int(input('Enter the number of Students : '))
li = []
for i in range(x):
    tmp = int(input("Enter Marks of "+str(i)+" student : "))
    li.append(tmp)
sum = 0
for i in range(len(li)):
    sum = sum + li[i]
print(sum / len(li))