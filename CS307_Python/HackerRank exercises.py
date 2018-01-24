'''
Problem link: https://www.hackerrank.com/challenges/write-a-function/problem

Meant to determine if a given year is a leap year

'''
'''
def is_leap(year):
    leap = False
    if (year % 4 == 0):
        leap = True
        if(year % 100 == 0):
            leap = False
            if (year % 400 == 0):
                leap = True
    return leap

# More efficient
# def is_leap(year):
#     return year % 4 == 0 and (year % 400 == 0 or year % 100 != 0)

print(is_leap(2000))
print(is_leap(1990))
print(is_leap(2003))
print(is_leap(2004))
print(is_leap(1900))
'''

#https://www.hackerrank.com/challenges/python-print/problem
#
'''
Properties of the print function

Difference between sep and end
sep: by default its sep=' '
Only works in python 3
Separates arguments (variables)

end: by default end="\n"
inserted at the very end of the print statement
'''

n = 8;

for i in range(1, n+1):
    print(i, end="")

print()

print(*range(1,n + 1), sep="")

#https://www.hackerrank.com/challenges/python-lists/problem

import sys

num_list = ['insert', 0, 5]
print(num_list[1:])
fuck = list(map(int, num_list[1:]))
print(fuck)

#also an exercise input
N=12
out = []
for i in range(0, N):
    inp = sys.stdin.readline()
    li = inp.split()
    cmd = li[0]
    args = li[1:]
    # Map applies a function to all the items in an input_list.
    # Here is the blueprint:
    # map(function_to_apply, list_of_inputs)
    args = list(map(int, args))

    if (cmd == "print"):
        print(out)
    elif (cmd == "insert"):
        #print(args)
        out.insert(args[0], args[1])
       # print(out)
    elif (cmd == "remove"):
        out.remove(args[0])
       # print(out)
    elif (cmd == "append"):
        out.append(args[0])
       # print(out)
    elif (cmd == "sort"):
        out.sort()
       # print(out)
    elif (cmd == "pop"):
        out.pop()
       # print(out)
    elif (cmd == "reverse"):
        out.reverse()
       # print(out)
'''
A much better solution is to use python's eval function which
will automatically run the python code without having to
do the validation (it is a potential safety hazard though)

n = input()
l = []
for _ in range(n):
    s = raw_input().split()
    cmd = s[0]
    args = s[1:]
    if cmd !="print":
        cmd += "("+ ",".join(args) +")"
        eval("l."+cmd)
    else:
        print l

'''


