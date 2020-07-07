import socket

import mysql.connector



s = socket.socket()
host = '127.0.0.1'
port = 1233

print('Waiting for connection')
mydb = mysql.connector.connect(host="localhost", user="root", passwd="root")
mycursor = mydb.cursor()
def encrypt(text):
    result = ""
    s = 4
    # traverse text
    for i in range(len(text)):
        char = text[i]

        # Encrypt uppercase characters
        if (char.isupper()):
            result += chr((ord(char) + s - 65) % 26 + 65)

            # Encrypt lowercase characters
        else:
            result += chr((ord(char) + s - 97) % 26 + 97)

    return result
#while(True):

    print("Enter 1 for login ")
    print("Enter 2 for register")
    print("Enter 3 for deletion")
    print("Enter 4 for updation")

    n = int(input())
    if (n == 1):

        uname = input("Enter the username")
        mycursor.execute("select userpass from netusers.connect where username = %s", (uname,))
        passresult = mycursor.fetchone()
        mydb.commit()

        if passresult is None:
            print("User Not exists")
        else:
            pwd = passresult[0]
            userpass = input("Enter the UserPass")
            userpass = encrypt(userpass)
            if (userpass == pwd):
                # connect to the server on local computer
                s.connect(('127.0.0.1', port))

                # receive data from the server
                print(s.recv(1024))
                # close the connection
                s.close()
                print("Login successfully")
            else:
                print("Wrong Pass")

    elif (n == 2):

        username = input("Enter username")

        password = input("Enter password")
        Email = input("Enter email address")
        phoneno = input("Enter phone number")
        password = encrypt(password)

        val = (username, password , Email,phoneno)
        mycursor.execute("insert into netusers.connect values(%s,%s ,%s,%s)", val)
        mydb.commit()
        print("Successfully registered")

    elif (n == 3):
        uname = input("Enter the username")
        mycursor.execute("select userpass from netusers.connect where username = %s", (uname,))
        passresult = mycursor.fetchone()
        mydb.commit()

        if passresult is None:
            print("User Not exists")
        else:
            pwd = passresult[0]
            userpass = input("Enter the UserPass")
            userpass = encrypt(userpass)
            if (userpass == pwd):
                # connect to the server on local computer
                s.connect(('127.0.0.1', port))

                # receive data from the server
                print(s.recv(1024))

                mycursor.execute("DELETE FROM netusers.connect WHERE username = %s", (uname,))
                mydb.commit()


                # close the connection
                s.close()
                print("Deletion successfull")

            else:
                print("Wrong Pass")
    elif (n == 4):

                print("Enter new data which you want to update. If you want tokeep the columns same then enter the same data")
                uname = input("Enter the username")
                mycursor.execute("select userpass from netusers.connect where username = %s", (uname,))

                passresult = mycursor.fetchone()
                mydb.commit()

                if passresult is None:
                    print("User Not exists")
                else:
                    pwd = passresult[0]
                    userpass = input("Enter the UserPass")
                    userpass = encrypt(userpass)
                    if (userpass == pwd):
                        # connect to the server on local computer
                        s.connect(('127.0.0.1', port))
                        usernamenew = input("Enter the new Username")
                        Emailnew = input("Enter new E-mail")
                        Phonenonew = input("Enter new Phoneno")

                        # receive data from the server
                        print(s.recv(1024))

                        sql_update_query1 = """UPDATE netusers.connect SET username = %s WHERE userpass = %s"""
                        inputData1 = (usernamenew, userpass)
                        mycursor.execute(sql_update_query1, inputData1)

                        sql_update_query2 = """UPDATE netusers.connect SET Email = %s WHERE userpass = %s"""
                        inputData2 = (Emailnew, userpass)
                        mycursor.execute(sql_update_query2, inputData2)

                        sql_update_query3 = """UPDATE netusers.connect SET Phoneno = %s WHERE userpass = %s"""
                        inputData3 = (Phonenonew, userpass)
                        mycursor.execute(sql_update_query3, inputData3)
                        mydb.commit()

                        # close the connection
                        s.close()
                        print("Updation successfull")

                    else:
                        print("Wrong Pass")