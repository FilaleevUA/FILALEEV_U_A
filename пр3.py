def sum(a,b,c):
    s=a+b+c
    return s


def shoelaces(a,b,l,n):
    long=((a*n)*4)+((b*n)*2)+l*2
    print(long)


def min(a,b,c):
    m=min(a,b,c)
    print(m)


def chess_b(a,b,c,d):
    if (a + b + c + d) % 2 == 0:
        print('ДА')
    else:
        print('НЕТ')


def vis(n):
    if n%4==0 and n%100!=0 and n%400==0:
        print("ДА")
    else:
        print("Нет")


def sov(a,b,c):
    if a==b==c:
        print(3)
    elif (a==b and a!=c) or (c==b and b!=a):
        print(2)
    else:
        print(0)


def chocolate(a,b,k):
    if a*b>=k:
        print("Да")
    else:
        print("Нет")


print(sum(3,2,6))


a = int(input())
b = int(input())
s = 1/2*a*b
print(s)


n=int(input())
if n<=1440:
    chas=n//60
    n=n%60
    print(chas,":",n)


