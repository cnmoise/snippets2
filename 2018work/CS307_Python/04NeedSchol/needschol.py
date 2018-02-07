#Author: Claudiu Moise
#Need Calculator

#Allows us to use the readline method
import sys

studentName = "Derek Brambles"
familySize = 4
#Lowest family income defaulted to 20000
#If you would like to change it to a lower number all you have to do
#is rewrite the amount you see on the right hand side (don't include any ,)
lowestFamilyIncome = 20000
familyIncome = 20000
familyIncomeCutoff =   [36000, 48000, 60000, 73000, 86000,
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
    familyIncomeCutoff[familySize] = familyIncomeCutoff[12] + ((familySize - 12 ) * 14,000)

if(familyIncome > familyIncomeCutoff[familySize]):
    print("Student's Family Income exceeds Cutoff Family Income")
    sys.exit()

economicNeedRatio = (familyIncomeCutoff[familySize] - familyIncome) / (familyIncomeCutoff[familySize] - lowestFamilyIncome)
economicNeedScore =  economicNeedRatio*8

#Why is this line necessary?
#what are we supposed to do in the else case?
if (economicNeedScore < round(economicNeedScore) + 0.5):
    print("Score for Economic Need:", round(economicNeedScore)+1)


