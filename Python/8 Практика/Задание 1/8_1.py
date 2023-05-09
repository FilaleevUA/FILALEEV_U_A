import math
def friendly(a, b):
    d1 = []
    d2 = []
    for i in range(1, a):
        if a % i == 0:
            d1.append(i)
    for i in range(1, b):
        if b % i == 0:
            d2.append(i)
    if a == sum(d2) and b == sum(d1):
        return True
    return False

# 1 задание
n=int(input('n: '))

for ind in range(2, n):
    for ind2 in range(2,n):
        if friendly(ind,ind2):
            print(ind,ind2)

