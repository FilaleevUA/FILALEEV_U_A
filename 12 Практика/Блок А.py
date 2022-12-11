#Блок А
#Задание 1
def fac(n):
    if n==0:
        return 1
    return fac(n-1)*n

def vir(x,n):
    return (x^n)/fac(n)

print(vir(10,2))