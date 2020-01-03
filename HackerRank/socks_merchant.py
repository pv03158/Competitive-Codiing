#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sockMerchant function below.
def sockMerchant(n, ar):
    counter = 0
    pos = 0
    while(pos < len(ar)-1):
        if ar[pos] in ar[pos+1:]:
            ar.pop(pos)
            counter +=1
        pos += 1
    return counter

if __name__ == '__main__':
    n = int(input())
    ar = list(map(int, input().rstrip().split()))
    result = sockMerchant(n, ar)
    print(result)
