def sum_fact(n):
    y=1
    h=1
    i=1
    while i!=n:
        i+=1
        y*=i
        h+=y
    print(h)

sum_fact(3)