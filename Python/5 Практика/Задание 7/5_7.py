def bol_znach(): #7
    x = 1
    count = 0
    b=0
    while x != 0:
        x = int(input())
        if x>b:
            count += 1
        b=x
    print(count)

bol_znach()