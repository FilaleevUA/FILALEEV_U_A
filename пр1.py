print("Курс Основы программирования начался")

print((16823*12302)%3092)

age=int(input())
name=input()
if name!='Иван':
    if age>0 and age<75:
        if age>=16:
            print('Поздравляем вы поступили в ВГУИТ')
        else:
            print('Сначала нужно окончить школу!')
            print(16-age)
else:
    print(16-age)



second=int(input())
print('дни -',second/(60*60*24))
print('часы -',second/(60*60))
print('минуты -',second/(60))
print('секунды -',second)



print('введите n')
n=int(input())
print(n + n**2 + n**3 + n**4 + n**5)



x=int(input())
y=int(input())
a=x
x=y
y=a
print(x,y)



number=int(input())
if number%2==0:
    print('Число четное')
else:
    print('Число нечетное')