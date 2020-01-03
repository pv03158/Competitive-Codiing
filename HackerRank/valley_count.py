#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the countingValleys function below.
def countingValleys(n, s):
    valley_count = 0
    ascend = []     # above sea level
    descend = []    # below sea level
    counter = 0     # counter 0 is at sea level, +ve int at height, -ve int below sea
    for i in s:
        if counter == 0:
            if i == 'U':
                ascend.append(1)
                counter += 1
            if i == 'D':
                descend.append(-1)
                counter -= 1
        elif counter > 0:
            if i == 'U':
                ascend.append(1)
                counter += 1
            if i == 'D':
                ascend.append(-1)
                counter -= 1
        elif counter < 0:
            if i == 'U':
                descend.append(1)
                counter += 1
            if i == 'D':
                descend.append(-1)
                counter -= 1
    for i in descend:
        counter += i
        if counter == 0 :
            valley_count += 1
    return valley_count
            

if __name__ == '__main__':
    n = int(input())
    s = input()
    result = countingValleys(n, s)
    print(result)
