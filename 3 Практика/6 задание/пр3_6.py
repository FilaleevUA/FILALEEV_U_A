def sov(a,b,c):
    if a==b==c:
        print(3)
    elif (a==b and a!=c) or (c==b and b!=a):
        print(2)
    else:
        print(0)

sov(4,4,4)
