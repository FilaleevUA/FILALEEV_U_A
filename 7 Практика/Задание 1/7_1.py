def one():
    minn=100000
    n=int(input())
    x=[int(input()) for i in range(n)]
    for i1 in range(len(x)):
        if x[i1]%2!=0:
            if minn>x[i1]:
                minn=x[i1]
    print(minn)

one()