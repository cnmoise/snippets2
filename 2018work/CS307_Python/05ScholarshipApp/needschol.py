#Author: Claudiu Moise
#

#Allows us to use the readline method
import sys
import math

#Initializing all variables with dummy values
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
ColGPA = 3.5
HighGPA = 4.0
#Booleans are capitalized
weighted = True
#Needs to be declared in global scope
RoundedGPA = 0.0
isFreshman = False

RightEnd = [10,20,30,40,50,
			60,71,80,90,91,
			60,71,80,90,90,
			3.51,3.54,3.58,3.61,3.64,
			3.68,3.71,3.74,3.78,3.81,
			3.84,3.88,3.91,3.94,3.98,4.0]
kbw = "x"

def calculateRoundedGPA(ColGPA, HighGPA, weighted):
    if (weighted):
        RoundedGPA = round(((min(4, HighGPA) + (2 * ColGPA)) / 3), 2)
    else:
        RoundedGPA = round(((HighGPA + ColGPA) / 2), 2)
    return RoundedGPA
def checkColGPA(ColGPA):
    if (ColGPA < 3.5 ):
        print("Student’s College GPA is bellow the specified minimum.")
        return 1
    elif(ColGPA > 4.0):
        print("Student’s College GPA is above the specified maximum.")
        return 2
    else:
        return 0
def checkFamiliyIncome(familySize, familyIncome):
    if (familyIncome < lowestFamilyIncome):
        print("WARNING: This student has a lower income than the specified lowest family income")
        print("Please change the lowest income from the options menu")
    if (familyIncome > familyIncomeCutoff[familySize]):
        print("Student's Family Income exceeds Cutoff Family Income")
        return 1
    else:
        return 0

def calculateScoreForAcademicRecord():
    print("Beginning to calculate Score for Academic Record")

    print("Please enter the students name:")
    studentName = sys.stdin.readline()
    studentName = studentName.strip()

    print("Is this student a freshman? (y/n)")
    kbw = sys.stdin.readline()

    kbw = kbw.strip()
    # print(kbw)
    while (kbw is not 'y' and kbw is not 'n'):
        print("Invalid Input..."
              "\nPlease type in the letter \"y\" with no spaces if the student is a Freshman"
              "\nOr type in the letter \"n\" with no spaces if the student is NOT a Freshman.")

        print("\nIs this student a freshman? (y/n)")
        kbw = sys.stdin.readline()
        kbw = kbw.strip()

    if (kbw is "y"):
        isFreshman = True
    elif (kbw is "n"):
        isFreshman = False

    if (isFreshman):
        print("Please enter the Freshman students College GPA:")
        ColGPA = float(sys.stdin.readline())
        while (checkColGPA(ColGPA) != 0):
            print("Please re-enter the Freshman students College GPA:")
            ColGPA = float(sys.stdin.readline())

        print("Please enter the students High School GPA:")
        HighGPA = float(sys.stdin.readline())
        print("Is the High School GPA weighted? (y/n)")
        kbw = sys.stdin.readline()

        kbw = kbw.strip()
        # print(kbw)
        while (kbw is not "y" and kbw is not "n"):
            print("Invalid Input..."
                  "\nPlease type in the letter \"y\" with no spaces if the students High School GPA is weighted."
                  "\nOr type in the letter \"n\" with no spaces if the student High School GPA is unweighted.")
            print("Is this student a freshman? (y/n)")
            kbw = sys.stdin.readline()
        else:
            if (kbw is "y"):
                weighted = True
            elif (kbw is "n"):
                weighted = False

        # If you are unclear what we are doing here, please refer to the
        # function defined at the start of the program
        RoundedGPA = calculateRoundedGPA(ColGPA, HighGPA, weighted)

        print("Returning Output: \n")
        print("Students Name: ", studentName)
        print("Students College GPA: ", ColGPA)


        if(weighted):
            print("Students weighted High School GPA: ", HighGPA)
        else:
            print("Students unweighted High School GPA: ", HighGPA)

        print("\nRounded GPA: ", RoundedGPA, "\n")
    else:
        print("Please enter the NON-Freshman students College GPA:")
        ColGPA = float(sys.stdin.readline())
        while (checkColGPA(ColGPA) != 0):
            print("Please re-enter the NON-Freshman students College GPA:")
            ColGPA = float(sys.stdin.readline())

        RoundedGPA = ColGPA
        print("Returning Output: \n")
        print("Students Name: ", studentName)
        print("Students College GPA: ", RoundedGPA)

    # This section of the program applies to both Freshman and Non-Freshman
    flag = True

    for i in range(15, 31):
        if (RoundedGPA <= RightEnd[i] and flag):
            #print("Compared to:", RightEnd[i])
            print("Score for Academic Record", i)
            flag = False

def calculateScoreForEconomicNeed():
    print("Please enter the students name:")
    studentName = sys.stdin.readline()
    print("Please enter the students family size (a number between 1 and 20):")
    familySize = int(sys.stdin.readline())
    while (familySize < 1 or familySize > 20):
        print("Sorry this program does not allow for family sizes not between 1 and 20\n")
        print("Please re-enter the students family size (a number between 1 and 20):")
        familySize = int(sys.stdin.readline())
    print("Please enter the students family income (a number with no decimal values or commas):")
    familyIncome = int(sys.stdin.readline())
    if (familySize > 12):
        familyIncomeCutoff[familySize] = familyIncomeCutoff[12] + ((familySize - 12) * 14000)

    while (checkFamiliyIncome(familySize,familyIncome) != 0):
        print("Please re-enter the family income (a number with no decimal values or commas")
        familyIncome = int(sys.stdin.readline())

    economicNeedRatio = (familyIncomeCutoff[familySize] - familyIncome) / (
            familyIncomeCutoff[familySize] - lowestFamilyIncome)
    economicNeedScore = economicNeedRatio * 8
    print("Unrounded Score", economicNeedScore)

    # Why is this line necessary?
    # what are we supposed to do in the else case?
    if (economicNeedScore < math.floor(economicNeedScore) + 0.5):
        print("Case 1:")
        print("Score for Economic Need:", math.floor(economicNeedScore))
    else:
        print("Case 2:")
        print("Score for Economic Need:", math.floor(economicNeedScore) + 1)

def enterMainMenu():
    print("Hello World! Welcome to SimpleQualifier.py or SQ.py for short.")
    print(
        "This program will help you calculate a students GPA or tell you if they are eligible for a need based scholarship")

    print("To begin, select the program function you would like to use by typing in the number you see on its left hand side and pressing ENTER")
    print("1: Calculate Score for Academic Record")
    print("2: Calculate Score for Economic Need")
    print("3: Calculate both Scores")
    print("4: Quit")

    print(
        "This program was created by Claudiu Moise a student at Northeastern Illinois University under the guidance of professor Dorothy Georgakis.")
    print("If you wish to contact me please email me at cnmoise@neiu.edu")

    kbw = int(sys.stdin.readline())


    if kbw == 1:
        while(kbw is not "q"):
            calculateScoreForAcademicRecord()
            print("Would you like to return to the main menu or calculate another students Score for Academic Record? q/c: ")
            #print("To return to the menu type in the letter: q")
            #print("To calculate another students Score for Academic Record type in the letter: c")
            kbw = sys.stdin.readline()
            kbw = kbw.strip()

            while (kbw is not "q" and kbw is not "c"):
                print("Invalid Input..."
                      "\n Please type in the letter \"q\" if you would like to quit to the main menu"
                      "\n Or type in the letter \"c\" if you would like to calculate another students Score for Academic Record.")
                kbw = sys.stdin.readline()
                kbw = kbw.strip()

        print("Returning to Main Menu")
        enterMainMenu()
    elif kbw == 2:
        while(kbw is not "q"):
            calculateScoreForEconomicNeed()
            print("Would you like to return to the main menu or calculate another students Score for Economic Need? q/c: ")
            #print("To return to the menu type in the letter: q")
            #print("To calculate calculate another students Score for Economic Need type in the letter: c")
            kbw = sys.stdin.readline()
            kbw = kbw.strip()

            while (kbw is not "q" and kbw is not "c"):
                print("Invalid Input..."
                      "\n Please type in the letter \"q\" if you would like to quit to the main menu"
                      "\n Or type in the letter \"c\" if you would like to calculate another students Score for Academic Record.")
                kbw = sys.stdin.readline()
                kbw = kbw.strip()

        print("Returning to Main Menu")
        enterMainMenu()
    elif kbw == 3:
        while (kbw is not "q"):
            calculateScoreForAcademicRecord()
            calculateScoreForEconomicNeed()
            print(
                "Would you like to return to the main menu or calculate another students Score for Academic Record AND their Score for Economic Need? q/c: ")
            # print("To return to the menu type in the letter: q")
            # print("To calculate another students Score for Academic Record type in the letter: c")
            kbw = sys.stdin.readline()
            kbw = kbw.strip()

            while (kbw is not "q" and kbw is not "c"):
                print("Invalid Input..."
                      "\n Please type in the letter \"q\" if you would like to quit to the main menu"
                      "\n Or type in the letter \"c\" if you would like to calculate another students Score for Academic Record.")
                kbw = sys.stdin.readline()
                kbw = kbw.strip()
        print("Returning to Main Menu")
        enterMainMenu()
    elif kbw == 4:
        print("Exiting program, thank you for using SQ.py")
        print(
            "This program was created by Claudiu Moise a student at Northeastern Illinois University under the guidance of professor Dorothy Georgakis.")
        sys.exit()
    else:
        while (kbw not in range(0, 5)):
            print("Invalid entry, please select a number between 1 and 4")
            kbw = sys.stdin.readline()
            kbw = kbw.strip()


enterMainMenu()



