def pr7():
    s = input('Введите строку \n')
    str_split = s.split(' ')
    for i in range(len(str_split)):
        for i2 in range(len(str_split[i])):
            if str_split[i][i2]=='я' or str_split[i][i2]=='Я':
                print(str_split[i])

pr7()
