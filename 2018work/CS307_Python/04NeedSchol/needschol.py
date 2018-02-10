#Author: Claudiu Moise
#Need Calculator

#Allows us to use the readline method
import sys
import math

studentName = "Derek Brambles"
familySize = 4
#Lowest family income defaulted to 20000
#If you would like to change it to a lower number all you have to do
#is rewrite the amount you see on the right hand side (don't include any ,)
lowestFamilyIncome = 20000
familyIncome = 20000
familyIncomeCutoff =   [20, 36000, 48000, 60000, 73000, 86000,
                        100000,114000, 128000, 142000, 156000,
                        170000, 184000, 0, 0, 0,
                        0, 0, 0, 0, 0]

print("Please enter the students name:")
studentName = sys.stdin.readline()
print("Please enter the students family size (a number between 1 and 20):")
familySize = int(sys.stdin.readline())
print("Please enter the students family income:")
familyIncome = int(sys.stdin.readline())

#
if(familySize>12):
    familyIncomeCutoff[familySize] = familyIncomeCutoff[12] + ((familySize - 12 ) * 14000)
    print(familyIncomeCutoff[familySize])
#if the person is EXACTLY on the cutoff income value
#their score needs to be set to 1

if(familyIncome > familyIncomeCutoff[familySize]):
    print("Student's Family Income exceeds Cutoff Family Income")
    sys.exit()

economicNeedRatio = (familyIncomeCutoff[familySize] - familyIncome) / (familyIncomeCutoff[familySize] - lowestFamilyIncome)
economicNeedScore =  economicNeedRatio*8
print("Ratio", economicNeedRatio)
print("Unrounded Score", economicNeedScore)

#economicNeedScore = math.floor(economicNeedScore)
#print(economicNeedScore)

#Why is this line necessary?
#what are we supposed to do in the else case?
if (economicNeedScore < math.floor(economicNeedScore) + 0.5):
    print("Case 1")
    print("Score for Economic Need:", math.floor(economicNeedScore))
else:
    print("Case 2")
    print("Score for Economic Need:", math.floor(economicNeedScore)+1)


