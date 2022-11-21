n=int(input())
if n<=1440:
    chas=n//60
    n=n%60
    print(chas,":",n)