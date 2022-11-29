def number_one():
    A=[]
    B=str()
    file2 = open('Филалеев Юрий Александрович_у-223_vivod.txt', 'w')
    with open('Филалеев Юрий Александрович_У-223_vvod.txt', 'r') as file:
        for line in file:
            B = line.strip()
            H = B.split(' ')
            A.append(H)
    H=[]
    for i in range(len(A)):
        for j in range(len(A[i])):
            if i == j:
                print('k-я строка совподает с k-м столбцом на числе - ', A[i][j])
                H.append(A[i][j])
    for i in range(len(H)):
        file2.write(str(H[i]) + '\n')

number_one()
