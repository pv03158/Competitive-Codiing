import sys

number_of_test_cases = int(input())
number_of_admissions = list(map(int,input().split(' ')))
number_of_spaces = []
for i in range(len(number_of_admissions)):
    number_of_spaces.append(max(number_of_admissions) - number_of_admissions[i])
for i in range(max(number_of_admissions)):
    for j in range(len(number_of_spaces)):
        if number_of_spaces[j] == 0 :
          sys.stdout.write('* ')
        if number_of_spaces[j] != 0:
            sys.stdout.write('  ')
            number_of_spaces[j] -= 1
    sys.stdout.write('\n')