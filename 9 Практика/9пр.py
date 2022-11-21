#Вариант 12

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



def number_two():
    n=int(input('Введите значение n: '))
    m=int(input('Введите значение m: '))
    A=[]
    for i in range(n):
        B=[]
        for j in range(m):
            print('Введите', str(i + 1), '-ю строку', str(j + 1), '-ю цифру: ', end='')
            B.append(int(input()))
        A.append(B)
    print(A)
    for i in range(len(A) - 1):
        for j in range(len(A[0])):
            A[i][j] -= A[-1][j]

    for i in A:
        print(i)
number_two()