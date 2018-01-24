import random

'''C Class'''
class C:
    def __init__(self, name):
        self.name = name
        self.attributes = {'strength': 0, 'dexterity': 0, 'constitution': 0, 'intelligence': 0, 'wisdom': 0, 'charisma': 0}
        self.level = 0
        self.class_1 = 'none'
        self.class_2 = 'none'

    def newRandomCharacter(self):
        rolls = []
        for x in range(0,6):
            rolls.append(random.randint(1,6) + random.randint(1,6) + random.randint(1,6))


        self.attributes['strength'] = rolls[0]
        self.attributes['dexterity'] = rolls[1]
        self.attributes['constitution'] = rolls[2]
        self.attributes['intelligence'] = rolls[3]
        self.attributes['wisdom'] = rolls[4]
        self.attributes['charisma'] = rolls[5]
        self.autoSetClass()

        self.level = 1

        self.personality = random.randint(0,15)

    def autoSetClass(self):
        best_attribute = max(self.attributes, key = self.attributes.get)

        if(best_attribute == 'strength'):
            self.class_1 = 'Fighter'

        if (best_attribute == 'dexterity'):
            self.class_1 = 'Thief'

        if (best_attribute == 'constitution'):
            if(int(self.attributes['wisdom']) >=14):
                self.class_1 = 'Cleric'
            else:
                self.class_1 = 'Fighter'

        if (best_attribute == 'intelligence'):
            self.class_1 = 'Wizard'

        if (best_attribute == 'wisdom'):
            self.class_1 = 'Cleric'

        if (best_attribute == 'charisma'):
            self.class_1 = 'Bard'

    def getPersonality(self):
        personalities = ['Rude', 'Friendly', 'Courageous', 'Ultimate Do-gooder', 'Kleptomaniac', 'Brooding', 'Scholarly', 'Vegetarian', 'Wimpy', 'Dishonest',
                         'Overly-talkative', 'Flirty', 'Racist', 'Snooty', 'Veteran', 'Constantly-farting']
        return personalities[self.personality]

    def info(self):
        print(str('**********'))
        print(self.name + ', Level ' + str(self.level) + ' ' + self.getPersonality() + ' ' + self.class_1)
        print('STR: ' + str(self.attributes['strength']))
        print('DEX: ' + str(self.attributes['dexterity']))
        print('CON: ' + str(self.attributes['constitution']))
        print('INT: ' + str(self.attributes['intelligence']))
        print('WIS: ' + str(self.attributes['wisdom']))
        print('CHA: ' + str(self.attributes['charisma']))


def game(char1, char2, char3, char4):
    c1 = C(char1)
    c2 = C(char2)
    c3 = C(char3)
    c4 = C(char4)

    characters = [c1,c2,c3,c4]

    print('Your Party:')
    for x in characters:
        x.newRandomCharacter()
        x.autoSetClass()
        x.info()


game('Amy', 'Dick', 'Rob', 'Jon')
