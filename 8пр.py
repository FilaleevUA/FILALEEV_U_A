# вар 12
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

# 2 задание
def median(a, b, c):
    m = 0.5 * (math.sqrt(2*a**2+2*b**2-c**2))
    return(m)
a = int(input('a: '))
b = int(input('b: '))
c = int(input('c: '))
med_a = median(b, c, a)
med_b = median(a, c, b)
med_c = median(a, b, c)
print(median(med_b, med_c, med_a), median(med_a, med_c, med_b), median(med_a, med_b, med_c))
