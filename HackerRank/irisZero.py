N = int(raw_input())
X = int(raw_input())

#Finding no.of factors of fact present till num
def numberOfFactors(num,fact) :
    counter = 0
    for i in range(1,num+1) :
        num = i
        while num >= fact :
            if num%fact == 0 :
                counter += 1
                num = (num/fact)
            else:
                break
    return counter

numberOfFiveFactors = numberOfFactors(N,5)
numberOfTwoFactors = numberOfFactors(N,2)
if numberOfTwoFactors <= numberOfFiveFactors :
    zeroCounter = numberOfTwoFactors
else :
    zeroCounter = numberOfFiveFactors

numberOfB = (zeroCounter*X*N)/100.0
print numberOfB