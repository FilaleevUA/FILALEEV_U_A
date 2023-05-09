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

number_two()
