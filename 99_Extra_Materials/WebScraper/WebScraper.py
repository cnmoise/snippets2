from selenium import webdriver
import sys, requests, bs4, os

''' Setting temporary path to where firefox driver is located,
    will need to be changed for windows systems if necessary,
    otherwise should be commented out'''
os.environ["PATH"] += ":/Applications/"

filename = "toons.txt"

browser = webdriver.Firefox()


class Toon(): # class to hold character info
    def __init__(self, name: object, server: object, iLvl: object, artPower: object, lastUpdate: object) -> object:
        self.name = name
        self.server = server
        self.iLvl = iLvl
        self.artPower = artPower
        self.lastUpdate = lastUpdate

    def info(self):
        print(self.name)
        print(self.server)
        print(self.iLvl)
        print(format(int(self.artPower), ",d"))
        print(self.lastUpdate)


with open(filename) as file_object:
    toons = file_object.readlines()

toonList = []

for toon in toons: # creating list of Toon objects
    toonList.append(Toon(toon.split()[0], toon.split()[1], "0", "0", "0"))

for toon in toonList:

    wowProgRes = requests.get("http://www.wowprogress.com/character/us/" + toon.server + "/" + toon.name)
    wowProgRes.raise_for_status()  # Throws exception if error downloading webpage

    wowProgSoup = bs4.BeautifulSoup(wowProgRes.text, "html.parser")  # new bs4 object to allow for parsing

    gearData = wowProgSoup.select("div.gearscore")  # finding the classes we want
    updatedData = wowProgSoup.select("span.datetime")

    itemLevel = gearData[0].getText()  # getting the pieces of info we care about
    artifactPower = gearData[1].getText()
    lastUpdated = updatedData[len(updatedData)-1].getText()  # we only want the most recent entry

    toon.iLvl = itemLevel[12:]  # getting rid of some preceding text, and adding values to objects
    toon.artPower = artifactPower[16:]
    toon.lastUpdate = lastUpdated

    # Objects have been filled with data, time to click update button

    browser.get("http://www.wowprogress.com/character/us/" + toon.server + "/" + toon.name)

    elem = browser.find_elements_by_tag_name("input")

    elem[8].click()
    elem[8].click()
    elem[8].click()

for toon in toonList:
    print('---------------')
    toon.info()

print('---------------')

# We should be done so let's quit the browser

browser.quit()
browser.quit()
browser.quit()
