import sys
import decimal

# getsizeof(b)
# Return the size of an object in bytes. The object can be any type of object. All built-in objects will return correct
# results, but this does not have to hold true for third-party extensions as it is implementation specific.

# "int": 0,
# "float": 0.0,
# "dict": dict(),
# "set": set(),
# "tuple": tuple(),
# "list": list(),
#  "str": "a",
#  "unicode": u"a",
#  "decimal": decimal.Decimal(0),
# "object": object(),

# https://stackoverflow.com/questions/1331471/in-memory-size-of-a-python-structure

# https://softwareengineering.stackexchange.com/questions/185104/why-is-a-boolean-value-stored-as-a-byte-inside-of-a-computer-when-it-only-requir

# A boolean is stored in 14-16 bytes, in python 3 as of 03.09.2018
#Other sources I've found online claim that a boolean actually takes 24 bytes to store a boolean
# More memory efficient solutions involve using NumPy which uses BitArrays
#this is implemented through C

#https://stackoverflow.com/questions/34502755/python-boolean-byte-size

b = False
a = True

print(sys.getsizeof(b))
print(sys.getsizeof(a))

b = 0
a = 1

print(sys.getsizeof(b))
print(sys.getsizeof(a))