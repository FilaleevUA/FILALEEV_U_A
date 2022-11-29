def lesenka(n):
    for i in range(1,n+1):
        list_st=[]
        for y in range(1,i+1):
            list_st+=str(y)
        print(list_st)

lesenka(3)