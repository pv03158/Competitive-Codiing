from itertools import permutations

# taking inputs
t = int(input())
k = []
for i in range(t):
    k.append(int(input()))
# computing signature key
def compute_signature(num):
    divisor = 2
    remainder = []
    while True:
        if num // divisor == 0:
            remainder.append(num % divisor)
            break
        else:
            remainder.append(num % divisor)
            num = num // divisor
            divisor += 1
    return remainder
# printing all the possible combinations for the given key
for key in k:
    key_with_same_signature = []
    remainders = compute_signature(key)
    remainders.sort()
    signatures = list(set(permutations(remainders)))
    for signature in signatures:
        last_divisor = len(signature) + 1
        original_number = 0
        for bit in signature:
            original_number = last_divisor * original_number + bit
            last_divisor -= 1
    #     tmp = compute_signature(original_number)
    #     tmp.sort()
    #     if tmp == remainders:
    #         key_with_same_signature.append(original_number)
    # print(len(set(key_with_same_signature)) - 1)



            


