def two():
    a=[int(input()) for i in range(5)]
    b=[int(input()) for i1 in range(5)]
    y=a
    h=b
    a=h
    b=y
    print(a, '\n', b)

two()