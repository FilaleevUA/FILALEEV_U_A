def fib(n): #9
    List_fib=[]
    for i in range(1,n+1):
        if i == 1 or i == 2:
            List_fib.append(1)
        else:
            List_fib.append(List_fib[i-3]+List_fib[i-2])
    print(sum(List_fib))

fib(3)