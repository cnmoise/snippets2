def sweep(spaces, r1):
  start = r1[0]/r1[1]
  for i in range(0,len(spaces)):
    if(spaces[i] - start) < 1:
      return [-1, -1]
    start = spaces[i] - start
  return r1

def answer(pegs):
    # for i in range(0, len(pegs) - 1):
    #     spaces = [pegs[i + 1] - pegs[i]]

    #Sums up all middle terms in the algorithm

    #calculates all the gaps between pegs (the distance the radii need to bridge)
    spaces = [pegs[i + 1] - pegs[i] for i in range(0, len(pegs) - 1)]
    f_space = sum(spaces[::2]) - sum(spaces[1::2])
    print("spaces[::2]")
    print (spaces[::2])
    print("spaces[1::2]")
    print (spaces[1::2])

    print(f_space)
    if(f_space <= 2):
        return [-1,-1]

    # Assigns first radius
    # if array is even
    firstRad = 0
    if(len(spaces)%2 == 0):
        firstRad = [2*f_space, 1]
    else:
        if(f_space%3 == 0):
            firstRad = [2*f_space/3, 1]
        else:
            firstRad = [2*f_space, 3]

    return sweep(spaces, firstRad)


# print(answer([4,30,50]))
# print(answer([12, 54, 84, 108]))



# for index in range(0, 13):
#     for jindex in range(index+1, 55):
#         for vindex in range(jindex + 1, 85):
#             for kindex in range(vindex + 1, 109):
#                 testPegs3 = [index, jindex, vindex, kindex]
#                 a = answer(testPegs3)
#                 if(a!=[-1,-1]):
#                     print(testPegs3)
#                     print(a)