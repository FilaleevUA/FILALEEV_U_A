def vis(n):
    if n%4==0 and n%100!=0 and n%400==0:
        print("ДА")
    else:
        print("Нет")

vis(400)