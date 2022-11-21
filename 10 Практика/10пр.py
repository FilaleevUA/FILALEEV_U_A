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

def number_two():
    A = []
    file2 = open('Филалеев Юрий Александрович_у-223_vivod.txt', 'w')
    with open('Филалеев Юрий Александрович_У-223_vvod.txt', 'r') as file:
        for line in file:
            B = line.strip()
            H = B.split(' ')
            h = list(map(int, H))
            A.append(list(h))
    H = []
    for i in range(len(A) - 1):
        for j in range(len(A[0])):
            A[i][j] -= A[-1][j]
    for i in A:
        file2.write(str(i) + '\n')
number_one()
number_two()