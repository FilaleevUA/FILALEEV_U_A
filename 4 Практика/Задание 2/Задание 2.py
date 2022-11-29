def vivd_if(a,b):
    if a<b:
        for i in range(a,b+1):
            print(i)
    else:
        for i in range(b,a,-1):
            print(i)

vivd_if(10,20)