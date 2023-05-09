def obr_vivod(a,b):
    if a>b:
        for i in range(a, b-1, -2):
            print(i)
    else:
        print('A должен быть > B ')


obr_vivod(20,10)
