print ('Hello World!')

name = 'brandon freeck'
number1 = 1234

string = ' He said "hey!" '

print(name + str(number1))
print(number1)

print(" You \"Jerk\" ")

''' This is a multiline comment '''

# Single line comment

print(name.title())
print(name.upper())
print(name.lower())

print(len(name))

first_name = 'brandon'
last_name = 'freeck'

full_name = first_name + ' ' + last_name

print (full_name)

print ('brandon \n freeck')

age = 4102348562389745623780

if (age % 10) == 1:
    print ("It's your " + str(age) + "st Birthday!")
elif (age % 10) == 2:
    print ("It's your " + str(age) + "nd Birthday!")
elif (age % 10) == 3:
    print ("It's your " + str(age) + "rd Birthday!")
else:
    print ("It's your " + str(age) + "th Birthday!")
