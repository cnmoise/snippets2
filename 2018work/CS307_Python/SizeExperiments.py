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


b = False
a = True

print(sys.getsizeof(b))
print(sys.getsizeof(a))

b = 0
a = 1

print(sys.getsizeof(b))
print(sys.getsizeof(a))