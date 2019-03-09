'''
Characters have 6 stats: STR, INT, AGI, CON, WIS, CHA
Stats are determined by rolling 4d6 and cutting the lowest one
'''

import random
 
def rolld6():
	return random.randint(1,6)

print(rolld6())
print(rolld6())
print(rolld6())
print(rolld6())

