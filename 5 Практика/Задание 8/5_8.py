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

ravna([10,52,125,125,6,3,0])