from selenium import webdriver
from PIL import Image
import sys, requests, bs4, os, random, math

os.environ["PATH"] += ":/Applications/"

driver = webdriver.Firefox()  # TODO: Max window size, and fix the scaling issues that introduces
driver.get('http://champion.gg/champion/Annie/Middle')



# TODO: Add highest pickrate option, add role display, add highest winrate/pickrate display
# TODO: Open browser window at maximum size

# Getting Champ Image
element = driver.find_element_by_class_name('champ-img')
location = element.location_once_scrolled_into_view
size = element.size

driver.save_screenshot('champ.png')

im = Image.open('champ.png')

left = location['x']
top = location['y']
right = location['x'] + size['width']
bottom = location['y'] + size['height'] + 75  # Buffer to grab champ name

im = im.crop((left, top, right, bottom))  # defines crop points
im.save('champ.png')  # saves new cropped image


text = driver.find_elements_by_class_name('champion-stats')  # Get titles/names for stat pics

print(len(text))

for x in text:
    print(x.text)

class_names = ['', '', '', 'summoner-wrapper', '', 'skill-order', '', 'rune-collection', '', 'build-wrapper',
               '', 'build-wrapper', '', 'mastery-container']  # Array to hold the class names we care about


# Loop cycles through the 6 important parts of the page and makes pictures of them
for i in range(3, 14, 2):  # Weird class_names array spacing lines it up to make an easy loop with the text array

    element = driver.find_elements_by_class_name(class_names[i])  # Get array of class we care about determined by i

    driver.save_screenshot(text[i].text + '.png')  # Saves named screenshot based on text name

    im = Image.open(text[i].text + '.png')  # uses PIL library to open image in memory

    left = location['x']
    top = location['y']
    right = location['x'] + size['width']
    bottom = location['y'] + size['height'] + 35  # 35 pixel buffer to catch winrate stats

    if i == 3 or i == 11 or i == 9:  # remove 35 pixel buffer for elements that don't need it
        bottom -= 35

    im = im.crop((left, top, right, bottom))  # defines crop points
    im.save(text[i].text + '.png')  # saves new cropped image

driver.quit()

# Begin Stitching of Created Photos

# Reinitializing pictures, can be avoided entirely by keeping in memory TODO: Avoid this entirely
masteries = Image.open('Highest Win % Masteries.png')
runes = Image.open('Highest Win % Runes.png')
skills = Image.open('Highest Win % Skill Order.png')
items = Image.open('Highest Win % Core Build.png')
summoners = Image.open('Highest Win % Summoners.png')
starters = Image.open('Highest Win % Starters.png')
champ = Image.open('champ.png')


# Making nice variable names for the different dimensions of each picture
(width_mast, height_mast) = masteries.size
(width_rune, height_rune) = runes.size
(width_skill, height_skill) = skills.size
(width_item, height_item) = items.size
(width_summ, height_summ) = summoners.size
(width_start, height_start) = starters.size
(width_champ, height_champ) = champ.size

skills = skills.resize((math.ceil(width_skill * .76), math.ceil(height_skill * .76)), Image.ANTIALIAS)
items = items.resize((width_summ, height_summ), Image.ANTIALIAS)


# New image must be sized appropriately
result_width = width_champ + width_summ + width_rune

# Catching edge case where more than 4 rows of runes exist TODO: Account for all variations of rune amount
if height_summ + height_start + height_item > height_rune - 30:
    result_height = height_summ + height_start + height_item + height_mast
else:
    result_height = height_rune + height_mast - 30

result = Image.new('RGB', (result_width, result_height))  # Making the new image

result.paste((31, 35, 37), (0, 0, result_width, result_height))  # Filling with gray

# Begin pasting images
result.paste(champ, (0, 0))
result.paste(summoners, (width_champ, 0))
result.paste(starters, (width_champ + (math.ceil((width_summ - width_start)/2)), height_summ))  # Centering Starters
result.paste(runes, (width_champ + width_summ, 0))

if height_summ + height_start + height_item > height_rune - 30:  # Accounting for changes in rune height
    result.paste(masteries, (-45, height_summ + height_start + height_item))
else:
    result.paste(masteries, (-45, height_rune - 30))

result.paste(skills, (width_mast - 80, height_rune))
result.paste(items, (width_champ, height_summ + height_start))

result.save('result.png')

'''
[3]     summoner-wrapper (1)
[7]     rune-collection (1)
[13]    mastery-container (1)
[11]    build-wrapper (3)
[5]     skill-order (1)
[9]     build-wrapper (1)
'''

'''
3 Highest Win % Summoners
5 Highest Win % Skill Order
7 Highest Win % Runes
9 Highest Win % Core Build
11 Highest Win % Starters
13 Highest Win % Masteries
'''
