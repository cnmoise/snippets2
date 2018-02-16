#This program will help you calculate the score for Academic Record
#and the Score for Economic Need of student applicants

#Allows us to use the readline method
import sys
import math

#Initializing all variables with dummy values
StudentName = "Derek Brambles"
FamilySize = 4
#Lowest family income defaulted to 20000
LowestFamilyIncome = 20000
FamilyIncome = 20000

#First value is a dummy value (because the user starts counting from 1, whereas programs start counting from 0)
CutoffFamilyIncome =   [20, 36000, 48000, 60000, 73000, 86000,
                        100000, 114000, 128000, 142000, 156000,
                        170000, 184000, 0, 0, 0,
                        0, 0, 0, 0, 0]
CollegeGPA = 3.5
HighSchlGPA = 4.0
Weighted = True
RoundedGPA = 0.0
isFreshman = False

#the first 15 values of the Right endList are dummy values
#The remaining 16 values are upper boundaries of GPA intervals from a table
RightEnd = [10,20,30,40,50,
			60,71,80,90,91,
			60,71,80,90,90,
			3.51,3.54,3.58,3.61,3.64,
			3.68,3.71,3.74,3.78,3.81,
			3.84,3.88,3.91,3.94,3.98,4.0]


#kbw is a variable
#Everery time the user enters an input, it is temporarily stored in this variable
kbw = "x"

#The function calculateRoundedGPA computes the Weighted Average GPA of a Freshman Student.
def calculateRoundedGPA(ColGPA, HighGPA, weighted):
    if (weighted):
        RoundedGPA = round(((min(4, HighGPA) + (2 * ColGPA)) / 3), 2)
    else:
        RoundedGPA = round(((HighGPA + ColGPA) / 2), 2)
    return RoundedGPA
#The function checkColGPA checks that the student College GPA is between 3.5 and 4.0
def checkColGPA(ColGPA):
    if (ColGPA < 3.5 ):
        print("Student’s College GPA is bellow the specified minimum.")
        return 1
    elif(ColGPA > 4.0):
        print("Student’s College GPA is above the specified maximum.")
        return 2
    else:
        return 0
#The function checkFamilyIncome checks that the Student Family income is between
#  the Lowest Family Income and the Cutoff Family Income
def checkFamilyIncome(familySize, familyIncome):
    if (familyIncome < LowestFamilyIncome):
        print("WARNING: This student has a lower income than the specified lowest family income")
    if (familyIncome > CutoffFamilyIncome[familySize]):
        print("Student's Family Income exceeds Cutoff Family Income")
        return 1
    else:
        return 0
#The function calculateScoreForAcademicRecord computes the student integer score for
#Academic Record that ranges from 15 to 30
def calculateScoreForAcademicRecord():
    print("\n---------------------------------------------------------------------------")
    print("Beginning to calculate Score for Academic Record")
    print("---------------------------------------------------------------------------\n")
    print("Please enter the students name:")
    #asking for user input
    studentName = sys.stdin.readline()
    studentName = studentName.strip()

    print("Is this student a freshman? (y/n)")
    kbw = sys.stdin.readline()

    kbw = kbw.strip()
    #Error checking
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

        # The function calculateRoundedGPA is called here to compute
        # the Rounded Weigthed Average GPA of a Freshman Student
        RoundedGPA = calculateRoundedGPA(ColGPA, HighGPA, weighted)
        print("\n---------------------------------------------------------------------------")
        print("Returning Output:")
        print("---------------------------------------------------------------------------\n")

        print("\nStudents Name: ", studentName)
        studentName = studentName.strip()

        print("Students College GPA: ", ColGPA)
        if(weighted):
            print("Students weighted High School GPA: ", HighGPA)
        else:
            print("Students unweighted High School GPA: ", HighGPA)

        print("\nWeighted Average GPA: ", RoundedGPA)
    else:
        print("Please enter the NON-Freshman students College GPA:")
        ColGPA = float(sys.stdin.readline())
        while (checkColGPA(ColGPA) != 0):
            print("Please re-enter the NON-Freshman students College GPA:")
            ColGPA = float(sys.stdin.readline())

        #Rounded GPA for Non-Freshman student
        RoundedGPA = round(ColGPA, 2)
        print("\n---------------------------------------------------------------------------")
        print("Returning Output:")
        print("---------------------------------------------------------------------------\n")
        print("Students Name: ", studentName)
        print("Students College GPA: ", RoundedGPA)

    # This section of the program applies to both Freshman and Non-Freshman
    flag = True

    for i in range(15, 31):
        if (RoundedGPA <= RightEnd[i] and flag):
            #print("Compared to:", RightEnd[i])
            print("Score for Academic Record", i, "\n")
            flag = False
    print("\n---------------------------------------------------------------------------")
    print("Returning to the Main Menu")
    print("---------------------------------------------------------------------------\n")
#The function calculateScoreForEconomicNeed computes the student integer
#Score for Economic Need that ranges from 0 to 8
def calculateScoreForEconomicNeed():
    print("\n---------------------------------------------------------------------------")
    print("Beginning to calculate Score for Economic Need")
    print("---------------------------------------------------------------------------\n")

    print("Please enter the students name:")
    studentName = sys.stdin.readline()
    print("Please enter the students family size (a number between 1 and 20):")
    familySize = int(sys.stdin.readline())
    while (familySize < 1 or familySize > 20):
        print("Sorry this program does not allow for family sizes not between 1 and 20\n")
        print("Please re-enter the students family size (a number between 1 and 20):")
        familySize = int(sys.stdin.readline())
    print("Please enter lowest family income(a number with no decimal values or commas):")
    LowestFamilyIncome = int(sys.stdin.readline())
    print("Please enter the students family income (a number with no decimal values or commas):")
    familyIncome = int(sys.stdin.readline())
    if (familySize > 12):
        CutoffFamilyIncome[familySize] = CutoffFamilyIncome[12] + ((familySize - 12) * 14000)

    while (checkFamilyIncome(familySize,familyIncome) != 0):
        print("Please re-enter the family income (a number with no decimal values or commas)")
        familyIncome = int(sys.stdin.readline())

    RatioEconNeed = (CutoffFamilyIncome[familySize] - familyIncome) / (
            CutoffFamilyIncome[familySize] - LowestFamilyIncome)
    ScoreEconNeed = RatioEconNeed * 8

    print("\n---------------------------------------------------------------------------")
    print("Returning Output:")
    print("---------------------------------------------------------------------------\n")
    print("Students Name: ", studentName)
    print("Students Family Size: ", familySize)
    print("Students Family Income: ", familyIncome)
    if (ScoreEconNeed < math.floor(ScoreEconNeed) + 0.5):
        print("\nScore for Economic Need:", math.floor(ScoreEconNeed))
    else:
        print("Score for Economic Need:", math.floor(ScoreEconNeed) + 1)

    print("\n---------------------------------------------------------------------------")
    print("Returning to the Main Menu")
    print("---------------------------------------------------------------------------\n")

#The execution of the CalculatorScoreAcademicRecordEconomicNeed program
#starts with the execution of the enterMainMenu function.
#Its Menu offer to the user 4 options numbered 1, 2, 3, 4
def enterMainMenu():
    print("Welcome to CalculatorScoreAcademicRecordEconomicNeed")
    print("This program calculates the Score for Academic Record and the Score for Economic Need")
    print("\nMenu")

    print("\n 1: Calculate the Weighted Average GPA\n   and the Score for Academic Record")
    print(" 2: Calculate Score for Economic Need")
    print(" 3: Calculate both Scores")
    print(" 4: Quit")



    print(
        "\nSelect one of these four options from the Menu by typing in the number for the option and press ENTER")
    kbw = int(sys.stdin.readline())


    if kbw == 1:
        calculateScoreForAcademicRecord()
        enterMainMenu()
    elif kbw == 2:
        calculateScoreForEconomicNeed()
        enterMainMenu()
    elif kbw == 3:
        calculateScoreForAcademicRecord()
        calculateScoreForEconomicNeed()
        enterMainMenu()
    elif kbw == 4:
        print("Exiting program, thank you for using Simple Qualifier")
        sys.exit()
    else:
        while (kbw not in range(0, 5)):
            print("Invalid entry, please select a number between 1 and 4")
            kbw = sys.stdin.readline()
            kbw = kbw.strip()


enterMainMenu()



