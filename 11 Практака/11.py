
#Вариант - 4
#NixOS Package Collection; Репозиторий: github.com/NixOS/nixpkgs
import requests
from tkinter import*
def buttonAction():
    with open("file_write.txt","w") as file:
        user = txtField.get()
        url = f"https://api.github.com/users/{user}"
        userInfo = requests.get(url).json()
        enum = ['company', 'created_at', 'email', 'id', 'name', 'url']
        data = userInfo.keys()
        for i in data:
            if i in enum:
                file.write(f"{i}:{userInfo[i]}" + '\n')
    head.configure(text = "Данные успешно записались")

#Элементы графического интерфейса

root = Tk()
root.title('GIT request')
root.geometry('600x300')
root["bg"] = "gray"

head = Label(root, bg = "gray", fg = "black", text = 'Запишите имя пользователя', font = ('Times New Roman', 22))
head.pack(expand=True)
txtField = Entry(root,width=40,font=('Times New Roman', 18))
txtField.pack(expand=True)
button = Button(root, bg = "white", fg = "black", text = 'Нажми на меня',command = buttonAction)
button.pack(expand=True)

root.mainloop()