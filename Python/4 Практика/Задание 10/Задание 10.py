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

num_10(5,2)