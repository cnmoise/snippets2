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

    if (arrLength > 2):
        for index in range(1, arrLength-1):
            sum += 2 * (-1)**(index+1) * pegs[index]
            print(sum)

    if even:
        FirstGearRadius = Fraction(2 * (float(sum)/3))
    else:
        FirstGearRadius = Fraction(2 * float(sum))

    print(FirstGearRadius)

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

testPegs = [12, 54, 84, 108]

print(answer(testPegs));
