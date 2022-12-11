#Задание 1
def max_rec(x,max):
    if x!=0:
        if max<x:
            max=x
    return max


def blok_b():
    n=int(input())
    if n==0:
        return 0
    else:
        return max(n,blok_b())

print(blok_b())