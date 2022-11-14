def num(n): #1
    x=0
    while x<n:
        x+=1
        print(x**2)

def second(): #2
    i=2
    x=int(input())
    while x%i!=0:
        i+=1
    print(i)

def third(): #3
    x=int(input())
    b=2
    while b<x:
        b*=2
    print(b//2)

def fourth(): #4
    x=int(input())
    y=int(input())
    i=1
    while x<y:
        i+=1
        x*=1.1
    print(i)

def fifth(): #5
    x=1
    count=0
    while x!=0:
        x=int(input())
        count+=1
    print(count)

def sr_znach(): #6
    x = 1
    count = 0
    sum_znach=0
    while x != 0:
        x = int(input())
        count += 1
        sum_znach+=x
    print(sum_znach/count)

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

def ravna(x):
    i=0
    count=0
    max_count=0
    while x[i] != 0:
       if x[i] == x[i+1]:
           count += 1
           if max_count<count:
               max_count=count
       i+=1
    print(max_count)