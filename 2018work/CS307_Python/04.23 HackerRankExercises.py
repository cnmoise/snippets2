# https://www.hackerrank.com/challenges/python-tuples/problem

import sys

#user manual entry version

print("please enter # of elems in tuple")
kbw = sys.stdin.readline()
kbw = kbw.strip()

# print("Spy", kbw)

print("please enter a series of integers separated by spaces")
yolo = sys.stdin.readline()
yolo = yolo.strip()

yolo_list = yolo.split(" ")

# print("Spy", yolo)
# print("Spy", yolo_list)

#Coerces a list into a tuple
yolo_tuple = tuple(yolo_list)

# print("Spy", yolo_tuple)

print(hash(yolo_tuple))

#hacker rank version

if __name__ == '__main__':
    n = int(raw_input())
    integer_list = map(int, raw_input().split())

    #Coerces a list into a tuple
    yolo_tuple = tuple(integer_list)

    # print("Spy", yolo_tuple)

    print(hash(yolo_tuple))