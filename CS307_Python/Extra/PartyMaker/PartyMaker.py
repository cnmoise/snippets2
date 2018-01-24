import random

'''
In the game of Dungeons and Dragons, the character creation process consists of allocating stats,
selecting a race, assigning a class, and naming the character.

In this exercise we will attempt to automate the process by first taking care of the stat allocation.

Afterwards we will try and make a method that can determine the preferred class for a character
based on the stats they were allocated.

We will then randomly select a race and name.
'''

'''
We want to first make a Class for the character.
It should have attributes for character name, character level, character race, character class, and each stat.

The character stats in Dungeons and Dragons are as follows:
Strength (STR), Dexterity (DEX), Intelligence (INT), Constitution (CON), Wisdom (WIS), and Charisma (CHA)

You can choose to make a separate attribute for each stat, or you can make a dictionary of stats:
self.stats = {'stat_1' : value_1, 'stat_2' : value_2, .... }
'''

# Our roll_d6 method and roll_stat method won't be actually doing any operations on the object
# Because of this we can choose to define them outside of the "Character" class

# def roll_d6():
#     return random.randint(1, 6)
#
#
# def roll_stat():
#     rolls = [roll_d6(), roll_d6(), roll_d6(), roll_d6()]
#     rolls.remove(min(rolls))
#     return sum(rolls)

# Or we can define them as part of the Character class


class Character:
    def __init__(self, name=''):  # initialize name to blank string to make parameter optional
        self.name = name
        self.race = ''
        self.class1 = ''
        self.class2 = ''
        self.level = ''
        self.stats = {'STR': 0, 'DEX': 0, 'INT': 0, 'CON': 0, 'WIS': 0, 'CHA': 0}
        # self.stats is now a dictionary, we can call the "indexes" like this: stats['STR']
        # these will function more or less like an array, except instead of numbers it's a string


# Okay we have a constructor class, now we need to decide what methods we should include
#
# We'll need a new method to roll a d6 (six-sided die), a method that rolls 4 d6 and returns the sum of the top 3 rolls,
# and then we'll need a method that utilizes the previous methods to randomly assign values to each stat
#
# After that, we'll need a method that picks a class for the character based on their highest stat
#
# And finally we'll need a method that randomizes a race and name for the character
#
# You can optionally include get and set methods for this class, but it won't be absolutely necessary,
# as long as you're not super concerned about security of the methods
#
# You can access the attributes like so: print(char.level), char.level = 2, print(char.stats['STR']) etc...

    def roll_d6(self):
        return random.randint(1, 6)

    def roll_stat(self):
        rolls = [self.roll_d6(), self.roll_d6(), self.roll_d6(), self.roll_d6()]
        rolls.remove(min(rolls))
        return sum(rolls)

    def auto_stats(self):
        for key in self.stats:
            self.stats[key] = self.roll_stat()


Freeck = Character('Freeck')

print(Freeck.stats)
Freeck.auto_stats()
print(Freeck.stats)




