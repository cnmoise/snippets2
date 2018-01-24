import random
#important for doing ANYTHING involving IO
import sys
import os

#Going through HackerRank exercises
#Block structure

#Indents matter
print ("Hello, World!")

a = 4
b = 3
print(a+b)
print(a-b)
print(a*b)

#integer division
print(a//b)
print(a/b)

'''
block quotes

LN: 5 main types in python
Numbers
Strings
Lists - []
Tuples - ()
Dictionaries - {}


'''

print("\"Escape characters!")
print("1+2+3= concatenation", 1+2+3)

#REMEMBER THIS STUFF FROM C
print("%s %s %s" % ('replaces', 'the', 'values'))

print("\n" *5)

#gets rid of the newline char
print("i don't like ", end="")
print("newlines")

#LISTS are basically arrays
grocery_list = ['Juice', 'eggs', 'ham', 'grick eyes']

print('first item', grocery_list[0])

grocery_list[0] = "modern art"

print('first item', grocery_list[0])

print(grocery_list[1:4])

events = ["learn python", 'apply to hackathons', 'get life together']

#Nested lists
to_do_list = [events,
              grocery_list]

print(to_do_list)



#like a 2d array, 1st spot dictates the list (or row) that you should take the items from
#the second box dictates the exact position
print(to_do_list[0][1])
print(to_do_list[1][1])

#usefull methods, prebuilt in python, probably very highlevel
grocery_list.append('onions')
print(to_do_list)

#specify position
grocery_list.insert(1, 'pickle')

print(grocery_list)
grocery_list.remove('pickle')

grocery_list.sort()
grocery_list.reverse()


del grocery_list[4]

#changes to grocery list carry over to our 2d list
print(to_do_list)

to_do_list2 = events + grocery_list

print(len(to_do_list2))
#gives us the word w the max//min count of chars
print(max(to_do_list2))
print(min(to_do_list2))

#tuples are like lists
#they can't be changed after they are created
print('TUPLE TESTS')

pi_tuple = (3, 1, 4, 1, 5, 6)
#technically they can be,
#convert to list, change it, save as tuple again
new_tuple = list(pi_tuple)
new_list = list(new_tuple)

print(pi_tuple)

#not working for some reason
len(pi_tuple)
min(pi_tuple)
max(pi_tuple)

#dictionaries AKA Maps
#values with a unique key/value
#can't be inserted into
#keys are on the left, while values are on the right

super_villains = {'riddler' : "Isaac Clarke",
                  'reverse flash' : 'ewbard thorne',
                  'Captain Cold' : 'leonard snart'}

print(super_villains['Captain Cold'])
#reverse of above
#######
print(super_villains.get('leonard snart'))

#he is no longer with us
del super_villains['riddler']

#updtate
super_villains['captain cold'] = 'Robin'

print(len(super_villains))

print(super_villains.keys())

print(super_villains.values())

print("FLOW CONTROL")

n = 10
#odd  syntax,
# and = &&
# != out of parens
if (n % 2) != 0:
    print ("Weird")
elif (n >= 2) and (n <=5): #don't need to restate evens check
    print("Not Weird")
elif (n >= 6) and (n <= 20):
    print("Weird")
elif n > 20:
    print("Not Weird")

#LOGICAL OPERATORS
# and or not

i=0
k=0
n=9
#ctrl slash to comment out blocks of code
# while k < 20:
#     k = (i ** 2)
#     print(k)
#     i += 1

#range is a pretty funky idea, basically makes an array,
# don't include finishing number
#ex: range(0, 5) ends at the # 4

for i in range(0, n):
    k = (i ** 2)#exponent
    print (i, k)

iter_list = ['Juice', 'eggs', 'ham', 'grick eyes']

for y in iter_list:
    print(y)

for x in [2, 3, 4, 5, 6, 7]:
    print (x)

num_list = [[1,2,3],[10,20,30],[100,200,300]]

#watch this
for x in range(0,3):
    for y in range(0,3):
        print(num_list[x][y])
#Making nested for-loops is pretty basic huh?

#while loops are useful when you dont know how many times the code will
#have to run
random_num = random.randrange(0,100)

while(random_num != 15):
    print(random_num)
    random_num = random.randrange(0, 100)
i = 0;

while (i <= 20):
    if(i%2==0):
        print(i)
    elif(i == 9):
        break
    else:
        i += 1
        continue
    i += 1

print("Writing Functions")

def addNumber(fNum, lNum):
    sumNum = fNum + lNum
    return sumNum
    #sumNUM is not defined outside of the function (Out of Scope)

print(addNumber(1,4))
# ctrl+/ strikes again


# print('what is your favorite color')
# color = sys.stdin.readline()
#
#
#
# #color = "yellow"#sys.stdin.readline()
#
# print('your favorite color is', color)
# #gets rid of unneeded spaces
# color = color.strip();
#
# if color == "yellow":
#     print("you may pass")
# else:
#     print("AAAAAAAAAAAAAAAAAAAAAAAAH")

print("String Manipulation")

long ="Ill catch you if you fall The Floor"

#prints out the first 4 characters (index 4 is not included)
print(long[0:4])
#prints last 5 chracters
print(long[-5:])
#prints everything up to the last 5 chars
print(long[:-5])

#concat 2 strings or JOIN them
print(long[:4] + " be there")

#those regex's from C, and Java
'''
Fun Fact: 

%c - character
%s - string
%d - digit
%.5f - float (with 5 decimal points attatched)
'''
#has to nest exactly like this
print("%c is my %s letter and my number %d number is %.5f" % ('x', 'fav', 1, .14))

print("%s %s %s" % ('replaces', 'the', 'values'))

print(long.capitalize())

print(long.find('Floor'))

print(long.isalpha())
print(long.isalnum())

#length of a string
print(len(long))

print(long.replace("Floor", "Ceiling"))

#like the split method in JAVA
long_list = long.split(" ")
print(long_list)

print('FILE I/O TESTING')

test_file = open("test.txt", "wb")

print(test_file.name)
print(test_file.mode)

test_file.write(bytes("Write me to the file\n", 'UTF-8'))

test_file.close()

#open a file for reading AND writing
test_file = open("test.txt", "r+")

text_in_file = test_file.read()

print(text_in_file)
test_file.close()

os.remove("test.txt")

print('OBJECT ORIENTED PROGRAMMING')

class Animal:
    __name = ""
    __height = 0
    __weight = 0
    __sound = 0

    #BEHOLD THE CONSTRUCTOR
    def __init__(self, name, height, weight, sound):
        self.__name = name
        self.__height = height
        self.__weight = weight
        self.__sound = sound

    #self works like java's this
    #behold regular old getters and setters
    def set_name(self, name):
        self.__name = name
    def get_name(self):
        return self.__name

    def set_height(self, height):
        self.__height = height
    def get_height(self):
        return self.__height

    def set_weight(self, weight):
        self.__weight = weight
    def get_weight(self):
        return self.__weight

    def set_sound(self, sound):
        self.__sound = sound
    def get_sound(self):
        return self.__sound

    def get_type(self):
        print("Animal")
    def toString(self):
        return "{} is {} cm tall and {} kilos and say {}".format(self.__name,
                                                              self.__height,
                                                              self.__weight,
                                                              self.__sound)

cat = Animal('whiskers', 33, 10, 'Meow')

print(cat.toString())

#Inheritance

class Dog(Animal):
    __owner = ""

    #overwriting constructor
    def __init__(self, name, height, weight, sound, owner):
        self.__owner = owner
        #lets let the animal constructor handle this crap
        super(Dog, self).__init__(name, height, weight, sound)

    def set_owner(self, owner):
        self.owner = owner

    def get_owner(self):
        return self.__owner

    def get_type(self):
        print("dog")

    #OVERRIDING A FUCNTION
    def toString(self):
        return "{} is {} cm tall and {} kilos and say {} His owner is {}".format(self.__name,
                                                                                  self.__height,
                                                                                  self.__weight,
                                                                                  self.__sound,
                                                                                  self.__owner)
    #METHOD OVERLOADING
    def multiple_souns(self, how_many=None):
        if how_many is None:
            print(self.get_sound())
        else:
            print(self.get_sound())

spot = Dog("Spot", 53, 25, "ruff", "Derek")
print(spot.toString())

class AnimalTesting:
    def get_type(self, animal):
        animal.get_type()

test_animals = AnimalTesting()

test_animals.get_type(cat)
test_animals.get_type(spot)
