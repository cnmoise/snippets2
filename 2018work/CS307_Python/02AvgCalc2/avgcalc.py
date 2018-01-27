#Author: Claudiu Moise
#GPA calculator for Java and Python

#Allows us to use the readline method
import sys

Sname ="Derek Brambles"
ColGPA = 3.5
HighGPA = 4.0
#Booleans are capitalized
weighted = True
#Needs to be declared in global scope
RoundedGPA = 0.0
flag = True

RightEnd = [10,20,30,40,50,
			60,71,80,90,91,
			60,71,80,90,90,
			3.51,3.54,3.58,3.61,3.64,
			3.68,3.71,3.74,3.78,3.81,
			3.84,3.88,3.91,3.94,3.98,4.0]

kbw = "x";

#by default stdin takes input as strings
#therefore we have to explicitly cast the input as a float
print("Please enter the students name:")
Sname = sys.stdin.readline()
print("Please enter the students College GPA:")
ColGPA = float(sys.stdin.readline())
print("Please enter the students High School GPA:")
HighGPA = float(sys.stdin.readline())
print("Is the High School GPA weighted? y/n:")
kbw = sys.stdin.readline()

kbw = kbw.strip()
#print(kbw)
if(kbw == "y"):
    weighted = True
elif(kbw == "n"):
    weighted = False
else:
    print("Invalid Input... Assuming GPA Unweighted")

#Function definition
#Have to define fuction before we can use it
def calculateRoundedGPA(ColGPA, HighGPA, weighted):
    if (weighted):
        RoundedGPA = round(((min(4, HighGPA) + (2 * ColGPA)) / 3), 2)
    else:
        RoundedGPA = round(((HighGPA + ColGPA) / 2), 2)
    return RoundedGPA

RoundedGPA = calculateRoundedGPA(ColGPA, HighGPA, weighted)

print("Rounded GPA: ", RoundedGPA)
for i in range(15, 30):
    if (RoundedGPA <= RightEnd[i] and flag):
        print("Compared to:", RightEnd[i])
        print("Score for Academic Record", i)
        flag = False;



