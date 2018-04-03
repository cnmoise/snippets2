#Comment in Python are written with a single #
'''
This is a multi-line comment
'''

print("5 + 2 =", 5+2)
print("5 - 2 =", 5-2)
print("5 * 2 =", 5*2)
print("5 / 2 =", 5/2)
print("5 % 2 =", 5%2) # Modulus
print("5 ** 2 =", 5**2) # Exponential calculation
print("5 // 2 =", 5//2) # Floor Division

#Datatypes

#Lists
grocery_list = ['Juice', 'Tomatoes', 'Potatoes', 'Bananas']
print('The first item is', grocery_list[1])
grocery_list.append('onions') # You add values using append
print(grocery_list)
grocery_list.insert(1, "Pickle") # Insert item at given index
grocery_list.remove("Pickle") # Remove item from list
grocery_list.sort() # Sorts items in list
grocery_list.reverse()# Reverse sort items in list
#Tuple
pi_tuple = (3, 1, 4, 1, 5, 9)

#Dictionaries
appartment_building = {'1A' : 'Isaac Bowin',
                  '2A' : 'Leonard Snart',
                  '3B' : 'Mark Mardon',
                  '3C' : 'Sam Scudder',
                  '3A' : 'Thomas Peterson'}

print(appartment_building['2A'])

#Functions
#Example of calling a builtin function
print("Hello World")

