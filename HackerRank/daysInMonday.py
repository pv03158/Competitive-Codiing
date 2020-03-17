n = int(input())
days = []
startDay = []
for _ in range(n):
    a,b = input().split()
    days.append(int(a))
    startDay.append(b)

week = ['mon','tues','wed','thurs','fri','sat','sun']
weekCounts = []

for i in range(n):
    lenOfMonth = days[i]
    initialDay = startDay[i]
    completeWeeks = lenOfMonth // 7
    weekCounts = []

