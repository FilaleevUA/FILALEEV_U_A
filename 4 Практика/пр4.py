def vivod(a,b): #1зад
    if a<=b:
        for i in range(a,b+1):
            print(i)
    else:
        print('A должен быть <= B ')

def vivd_if(a,b): #2зад
    if a<b:
        for i in range(a,b+1):
            print(i)
    else:
        for i in range(b,a,-1):
            print(i)

def obr_vivod(a,b):#3зад
    if a>b:
        for i in range(b,a,-2):
            print(i)
    else:
        print('A должен быть > B ')

def sum_vivod(N): #4зад
    x=0
    sum_x=0
    while x<N:
        n=int(input("Введите число "))
        sum_x+=n
        x+=1
    print(sum_x)

def nat_ch(n): #5
    sum_ch=0
    for i in range(1,n+1):
        sum_ch+=i**3
    print(sum_ch)

def fact(n): #6
    fact_ch=0
    for i in range(1,n+1):
        fact_ch*=i
    return fact_ch

def sum_fact(n): #7
    y=1
    h=1
    i=1
    while i!=n:
        i+=1
        y*=i
        h+=y
    print(h)

def lesenka(n): #8
    for i in range(1,n+1):
        list_st=[]
        for y in range(1,i+1):
            list_st+=str(y)
        print(list_st)

def fib(n): #9
    List_fib=[]
    for i in range(1,n+1):
        if i == 1 or i == 2:
            List_fib.append(1)
        else:
            List_fib.append(List_fib[i-3]+List_fib[i-2])
    print(sum(List_fib))

def num_10(n,k):
    List_fib=[]
    ch_list_fib=[]
    for i in range(1,n+1):
        if i == 1 or i == 2:
            List_fib.append(1)
        else:
            List_fib.append(List_fib[i-3]+List_fib[i-2])
        if i>=k:
            ch_list_fib.append(List_fib[i-1])
    print(sum(ch_list_fib))


