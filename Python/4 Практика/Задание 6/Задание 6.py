def fact(n):
    fact_ch=1
    for i in range(1,n+1):
        fact_ch*=i
    return fact_ch

print(fact(5))