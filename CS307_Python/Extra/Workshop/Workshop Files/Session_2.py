response = 7
print(response)

example_list = [1,2,3,4,5,6,7,8,9]

print(type(example_list))

print(example_list[0:response])

print(example_list)

example_list.append("hello")

print(example_list)

nested_list = [10, 11, 12, 13, 14]

example_list.append(nested_list)

print(example_list)

new_string = "Brandon's String"

example_list.append(new_string)

print(example_list)

print("inserting A")

example_list.insert(1, "A")

print("removing 5")

example_list.remove(5)

print(example_list)

print("sorting list")

example_list.sort()

print(example_list)

print("reversing list")

example_list.reverse()

print(example_list)

exlist2 = [1,2,3,4,5,6,7,8,9]

exlist3 = exlist2 + nested_list

print(exlist3)

del exlist3[len(exlist3)-1]
print(exlist3)

print(len(exlist3))

print(exlist3)

for(int i=0; i<10; i++)

for i in range (0,10):
	print(i)
	
for a in exlist3:
	print(a)





