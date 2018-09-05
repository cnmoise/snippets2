from pizza import pizza

exlist2 = [1,2,3,4,5,6,7,8,9]

def greeting(first = 'Brandon',last = 'Freeck',suffix = ''):
	return(suffix.upper() + " " + first.upper() +
	" " + last.upper())
	
	
print(greeting(last = 'doe', suffix = 'Mrs.', first = 'jane'))

print('--------------------------')
print('--------------------------')

	
pizza('16"','Pepperoni', 'Sausage', 'Onions', 'Anchovies')

print('--------------------------')
print('--------------------------')

class Dog():
	
	def __init__(self,name,age,breed):
		self.name = name
		self.age = age
		self.breed = breed
		
	def sit(self):
		print(self.name.title() + ' is now sitting!')
	
	def roll_over(self):
		print(self.name.title() + ' rolls over!')
	
	def paw(self):
		print(self.name.title() + ' puts their paw in your hand!')
		
exDog = Dog('Fido',10,'Golden Retriever')

exDog.sit()
exDog.paw()

exDog.name = 'Rex'

exDog.sit()













