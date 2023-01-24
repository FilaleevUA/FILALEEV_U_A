from datetime import date
import os.path
from tkinter import*
from tkinter import messagebox
import math

dt_now = date.today()
#dt_now = date(2023, 1, 28)


def create_new_file(username):
    username_filename = username+'.txt'
    file1 = open(username_filename, "w+")
    file1.close()


def open_file(username):
    username_filename = username + '.txt'
    file1 = open(username_filename, 'r')
    file1.close()


def condition_username():
    username = loginInput.get()
    username_filename = username + '.txt'
    if os.path.isfile(username_filename):
        open_file(username)
        create_new_window()
    else:
        create_new_file(username)
        create_new_window()


def open_history():
    username = loginInput.get()
    username_filename = username + '.txt'
    from os import startfile
    startfile(username_filename)


def summ_attachment():
    username = loginInput.get()
    username_filename = username + '.txt'
    with open(username_filename) as file:
        summ = 0
        for line in file:
            string = str(line)
            string_split = string.split(' ')
            if int(string_split[2]) == 0:
                summ += float(string_split[1])
    return str(summ)


def new_attachment():

    def deposit():
        global dt_now
        date_now = str(dt_now)
        username = loginInput.get()
        username_filename = username + '.txt'
        days_deposit = loginInput_NumberDays.get()
        invested_amount = (int(loginInput_attachment.get()))
        usename_data = date_now + ' ' + str(invested_amount) + ' ' + str(days_deposit)
        file_write = open(username_filename, 'a')
        file_write.write(usename_data)
        file_write.write('\n')
        window_attachment.destroy()

    def withdrawal_balance():
        global dt_now
        date_now = str(dt_now)
        username = loginInput.get()
        username_filename = username + '.txt'
        withdrawal_amount = -abs(int(loginInput_attachment.get()))
        available_amount = summ_attachment()
        if abs(withdrawal_amount) > float(available_amount):
            messagebox.showwarning('Ошибка', 'Вы не можете снять такую сумму \n Возьмите меньше')
            return
        usename_data = date_now + ' ' + str(withdrawal_amount) + ' 0'
        file_write = open(username_filename, 'a')
        file_write.write(usename_data)
        file_write.write('\n')
        window_attachment.destroy()

    def new_attachment_command():
        global dt_now
        date_now = str(dt_now)
        username = loginInput.get()
        username_filename = username + '.txt'
        invested_amount = loginInput_attachment.get()
        usename_data = date_now + ' ' + str(invested_amount) + ' 0'
        file_write = open(username_filename, 'a')
        file_write.write(usename_data)
        file_write.write('\n')
        window_attachment.destroy()

    window_attachment = Toplevel(window)
    window_attachment.title('Выбор операции')
    window_attachment.geometry('600x400')

    Frame_Attachment = Frame(window_attachment, bg='white')
    Frame_Attachment.place(relx=0.05, rely=0.15, relwidth=0.9, relheight=0.7)

    transaction_amount = Label(Frame_Attachment, bg='white', text='Введите сумму:')
    transaction_amount.pack()

    loginInput_attachment = Entry(Frame_Attachment, bg='grey')
    loginInput_attachment.pack()

    button_new_attachment = Button(Frame_Attachment, text='Вложить', command=new_attachment_command)
    button_new_attachment.pack()
    button_withdrawal_balance = Button(Frame_Attachment, text='Снять', command=withdrawal_balance)
    button_withdrawal_balance.pack()

    label_transaction_amount = Label(Frame_Attachment, bg='white', text='Введите количество дней:')
    label_transaction_amount.pack()
    loginInput_NumberDays = Entry(Frame_Attachment, bg='grey')
    loginInput_NumberDays.pack()

    button_depsit = Button(Frame_Attachment, text='Вложить под 10%', command=deposit)
    button_depsit.pack()


def create_new_window():
    username = loginInput.get()
    username_filename = username + '.txt'
    global dt_now
    with open(username_filename, 'r+') as file:
        new_file = str()
        for line in file:
            string = str(line)
            string_split = string.split(' ')
            summ_on_balance = string_split[1]
            days = int(string[8:10])
            mounth = int(string[5:7])
            year = int(string[0:4])
            first_date = dt_now
            second_date = date(year, mounth, days)
            if int(string_split[2]) != 0 and first_date != second_date:
                old_data = string_split
                delta = first_date - second_date
                delta_str = str(delta)
                delta_split = delta_str.split(' ')
                delta_days = delta_split[0]
                if int(string_split[2]) == int(delta_days):
                    percent = int(summ_on_balance)
                    for i in range(int(string_split[2])):
                        print(percent)
                        percent *= 1.1
                    new_percent = math.floor(percent)
                    new_data = str(old_data[0]) + ' ' + str(new_percent) + ' 0'
                    new_file += new_data + '\n'
                else:
                    new_file += line
            else:
                new_file += line
    f = open(username_filename, 'w')
    f.write(new_file)
    f.close()


    newWindow = Toplevel(window)
    newWindow.title('Приложение копилка(Вход произведен)')
    newWindow.geometry('600x400')

    newFrame = Frame(newWindow, bg='white')
    newFrame.place(relx=0.05, rely=0.15, relwidth=0.9, relheight=0.7)

    LabelUsername = Label(newFrame, bg='white', text='Имя пользователя: '+username)
    balance = summ_attachment()
    label_balance = Label(newFrame, bg='white', text='Баланс: '+balance)
    LabelUsername.pack()
    label_balance.pack()

    button_openHistory = Button(newFrame, text='Посмотреть историю вложений', command=open_history)
    button_openHistory.pack()

    button_new_attachment = Button(newFrame, text='Новая операция', command=new_attachment)
    button_new_attachment.pack()


window = Tk()
window.title('Приложение (Копилка)')
window.geometry('300x250')
frame = Frame(window, bg='grey')
frame.place(relx=0.05, rely=0.15, relwidth=0.9, relheight=0.7)
loginInput = Entry(frame, bg='white')
loginInput.pack()
btn = Button(frame, text='Войти', command=condition_username)
btn.pack()


window.mainloop()