def answer(pegs):
    arrLength = len(pegs)
    if ((not pegs) or arrLength == 1):
        return [-1,-1]

    if (arrLength % 2 == 0):
        even = True
    else:
        even = False

    #odds/even switching
    if (even):
        sum = (- pegs[0] + pegs[arrLength - 1])
    else:
        sum = (- pegs[0] - pegs[arrLength -1])

    # python ends 1 early
    if (arrLength > 2):
        for index in range(1, arrLength-1):
            sum += 2 * (-1)**(index+1) * pegs[index]
            # print(sum)

    if (even):
        FirstGearRadius = Fraction(2 * (float(sum)/3)).limit_denominator()
    else:
        FirstGearRadius = Fraction(2 * float(sum)).limit_denominator()

    # print(FirstGearRadius)

    #now that we have the radius of the first gear,
    #we should again check the input array of pegs to verify that
    #the pegs radius' is atleast 1.
    #

    currentRadius = FirstGearRadius
    for index in range(0, arrLength-2):
        CenterDistance = pegs[index+1] - pegs[index]
        NextRadius = CenterDistance - currentRadius
        if (currentRadius < 1 or NextRadius < 1):
            return [-1,-1]
        else:
            currentRadius = NextRadius

    return [FirstGearRadius.numerator, FirstGearRadius.denominator]


from fractions import Fraction

testPegs2 = [12, 54, 84, 106]
testPegs3 = [12, 54, 84, 107]
testPegs4 = [12, 54, 84, 108]
# testPegs = [4,30,50]

print(testPegs2)
print(answer(testPegs2))
print(testPegs3)
print(answer(testPegs3))
print(testPegs4)
print(answer(testPegs4))
# for index in range(0, 13):
#     for jindex in range(index+1, 55):
#         for vindex in range(jindex + 1, 85):
#             for kindex in range(vindex + 1, 109):
#                 testPegs3 = [index, jindex, vindex, kindex]
#
#                 a = answer(testPegs3)
#                 if(a!=[-1,-1]):
#                     print(testPegs3)
#                     print(a)
