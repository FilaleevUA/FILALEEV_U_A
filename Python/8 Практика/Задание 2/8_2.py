import math


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