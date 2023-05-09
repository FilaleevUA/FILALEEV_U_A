def nuber_one():
    n = int(input('Введите колличество строк и цифр: '))
    A = []
    for i in range(n):
        B = []
        for j in range(n):
            print('Введите', str(i+1), '-ю строку', str(j+1), '-ю цифру: ', end='')
            B.append(int(input()))
        A.append(B)

    for i in range(len(A)):
        for j in range(len(A[i])):
            if i == j:
                print('k-я строка совподает с k-м столбцом на числе - ', A[i][j])


nuber_one()