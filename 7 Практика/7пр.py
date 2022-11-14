def one():
    minn=-1000000
    n=int(input())
    x=[int(input()) for i in range(n)]
    for i1 in range(len(x)):
        if x[i1]%2!=0:
            if minn>x[i1]:
                minn=x[i1]
    print(minn)

def two():
    a=[int(input()) for i in range(10)]
    b=[int(input()) for i1 in range(10)]
    y=a
    h=b
    a=h
    b=y
    print(a, '\n', b)
