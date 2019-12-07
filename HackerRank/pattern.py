import sys

number_of_lines = int(input())
for line_number in range(-number_of_lines//2+1,number_of_lines//2 +1):
    # printing intial spaces
    for i in range(abs(line_number)):
        sys.stdout.write(' ')
    # printing numbers in ascending order
    for i in range((number_of_lines//2 + 1) -abs(line_number),number_of_lines - 2*abs(line_number) +1):
        sys.stdout.write(str(i))
    # printing in descending order
    for i in range(number_of_lines - 2*abs(line_number)-1,(number_of_lines//2 + 1) -abs(line_number) -1, -1):
        sys.stdout.write(str(i))
    sys.stdout.write('\n');
    