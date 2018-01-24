import random
import re
from datetime import datetime
import requests
from bs4 import BeautifulSoup
from discord.ext.commands import Bot


def prequelMeme(sub):
    def getMeme(sub):
        # Get the webpage and convert it to something parseable
        url = "imgur.com/r/" + sub + "/top/week"
        r = requests.get("http://" + url)
        data = r.text
        soup = BeautifulSoup(data, "html.parser")

        # Get all post links and append to list
        memeLinks = []
        for link in soup.find_all('a'):
            if "/r/" + sub + "/" in link.get('href'):
                memeLinks.append(link.get('href'))

        # Pick one link at random
        randomKey = random.randrange(0, len(memeLinks) - 1)
        chosenOne = "http://imgur.com" + memeLinks[randomKey]

        # Go look at that page
        r = requests.get(chosenOne)
        data = r.text
        soup = BeautifulSoup(data, "html.parser")

        # Grab title and image link
        title = soup.find("h1", attrs={"class": "post-title"}).string
        image = "http:" + soup.find("div", attrs={"class": "post-image"}).find("a")["href"]

        # Hello there!
        return title + '\n' + image

    # Very lazy error handling for when the page isn't downloaded fast enough to parse
    attempts = 0

    response = ""

    while attempts < 10:
        try:
            response = getMeme(sub)
            break
        except:
            attempts += 1

    if attempts == 10:
        response = "There as an error with the command. Try again or try another subreddit."

    return response


def find_whole_word(w):
    return re.compile(r'\b({0})\b'.format(w), flags=re.IGNORECASE).search


bot = Bot(command_prefix='!')


@bot.event
async def on_ready():
    print('Logged in as')
    print(bot.user.name)
    print(bot.user.id)
    print(datetime.now())
    print('------')


@bot.command()
async def commands():
    await bot.say('facemugs, eggs, ariel, slavery, deusvult, pirates, corey, quote, cleveland, wall,'
                  ' dinosaurs, manifest, stickbitboit, china, revolution, brandon, london, savage, victory,'
                  ' same, dog, bobbeh, sean, fullmast, downs, jordan, donut, furstoss, w, tasty, luke, faggot,'
                  ' potus, squats, poetry, aaahhh, nah, no, niggadick, welp, justreich, quinn, jon, godzilla,'
                  ' pfs, dr, whitelotus, sriracha, fries, bdsnek, punish, fax, penis, pizzagate, weebs, nicotine,'
                  ' gay, tilt, hotone, tuna, drown, dicks, dump, jews, hitler, feminine, thirteen, chicken, bagget,'
                  ' boop, packs, elo, pizza, memepunchers, nick, glans, edge, erection, chrome, robot, gaston,'
                  ' overwatch, league, dota, uch, diablo, heroes, pubg, siege, quiplash, meme'
                  )


@bot.command()
async def facemugs():
    await bot.say('http://i.imgur.com/J8ehKMk.jpg')


@bot.command()
async def eggs():
    await bot.say('http://i.imgur.com/nPBMdLY.jpg')


@bot.command()
async def ariel():
    await bot.say('http://i.imgur.com/phlFqVi.jpg')


@bot.command()
async def slavery():
    await bot.say('http://i.imgur.com/bDvpOWc.jpg')


@bot.command()
async def deusvult():
    await bot.say('http://i.imgur.com/IKAiYfL.jpg')


@bot.command()
async def pirates():
    await bot.say('http://i.imgur.com/5SytQYh.jpg')


@bot.command()
async def corey():
    await bot.say('http://i.imgur.com/7h43PSV.jpg')


@bot.command()
async def quote():
    await bot.say('http://i.imgur.com/Q17A3sF.jpg')


@bot.command()
async def cleveland():
    await bot.say('http://i.imgur.com/6fOQDfK.jpg')


@bot.command()
async def wall():
    await bot.say('http://i.imgur.com/JdFLkOK.jpg')


@bot.command()
async def dinosaurs():
    await bot.say('http://i.imgur.com/13RQSf1.jpg')


@bot.command()
async def manifest():
    await bot.say('http://i.imgur.com/5rOXvwm.jpg')


@bot.command()
async def stickbitboit():
    await bot.say('http://i.imgur.com/GAd6WgC.jpg')


@bot.command()
async def china():
    await bot.say('http://i.imgur.com/c0RMObE.jpg')


@bot.command()
async def revolution():
    await bot.say('http://i.imgur.com/M98KrZn.jpg')


@bot.command()
async def brandon():
    await bot.say('http://i.imgur.com/LInheRQ.jpg')


@bot.command()
async def london():
    await bot.say('http://i.imgur.com/js0kuZA.jpg')


@bot.command()
async def savage():
    await bot.say('http://i.imgur.com/FTzQ8Ii.jpg')


@bot.command()
async def victory():
    await bot.say('http://i.imgur.com/t7w4VxK.jpg')


@bot.command()
async def same():
    for i in range(1, random.randint(3, 7)):
        await bot.say('SAME')


@bot.command()
async def dog():
    await bot.say('http://i.imgur.com/OlbZrhI.jpg')


@bot.command()
async def bobbeh():
    await bot.say('http://i.imgur.com/pTEkUYZ.gif')


@bot.command()
async def sean():
    await bot.say('http://i.imgur.com/FYQVyNA.jpg')


@bot.command()
async def fullmast():
    await bot.say('http://i.imgur.com/POAeh9X.jpg')


@bot.command()
async def downs():
    await bot.say('http://i.imgur.com/DtRDCiT.jpg')


@bot.command()
async def jordan():
    await bot.say('http://i.imgur.com/Ntk99tP.jpg')


@bot.command()
async def donut():
    await bot.say('http://i.imgur.com/v4mRPtP.jpg')


@bot.command()
async def furstoss():
    await bot.say('http://i.imgur.com/Qp8WFx0.jpg')


@bot.command()
async def w():
    await bot.say('http://i.imgur.com/icN63mM.jpg')


@bot.command()
async def tasty():
    await bot.say('http://i.imgur.com/BnddZDO.jpg')


@bot.command()
async def luke():
    await bot.say('http://i.imgur.com/WZlsGHj.jpg')


@bot.command()
async def faggot():
    await bot.say('http://i.imgur.com/1okqcfN.jpg')


@bot.command()
async def potus():
    await bot.say('http://i.imgur.com/CjOW5BR.jpg')


@bot.command()
async def squats():
    await bot.say('http://i.imgur.com/7aaAixO.jpg')


@bot.command()
async def poetry():
    await bot.say('http://i.imgur.com/obOXMNk.jpg')


@bot.command()
async def aaahhh():
    await bot.say('http://i.imgur.com/wpZxndm.jpg')


@bot.command()
async def nah():
    await bot.say('http://i.imgur.com/3EM51bx.jpg')


@bot.command()
async def no():
    await bot.say('http://i.imgur.com/oq1xw4C.jpg')


@bot.command()
async def niggadick():
    await bot.say('http://i.imgur.com/BHDRMV3.jpg')


@bot.command()
async def welp():
    await bot.say('http://i.imgur.com/WP1LMcA.jpg')


@bot.command()
async def justreich():
    await bot.say('http://i.imgur.com/L2Nrbl9.jpg')


@bot.command()
async def quinn():
    await bot.say('http://i.imgur.com/EsafoCi.jpg')


@bot.command()
async def jon():
    await bot.say('http://i.imgur.com/8MkGJ3I.jpg')


@bot.command()
async def godzilla():
    await bot.say('http://i.imgur.com/iqcYS2M.jpg')


@bot.command()
async def pfs():
    await bot.say('http://i.imgur.com/Oth1S25.jpg')


@bot.command()
async def dr():
    await bot.say('http://i.imgur.com/zcUKYkR.jpg')


@bot.command()
async def whitelotus():
    await bot.say('http://i.imgur.com/U1HHNFz.jpg')


@bot.command()
async def sriracha():
    await bot.say('http://i.imgur.com/MnYWuoo.jpg')


@bot.command()
async def fries():
    await bot.say('http://i.imgur.com/zmWSlwr.jpg')


@bot.command()
async def bdsnek():
    await bot.say('http://i.imgur.com/HNaM3Js.jpg')


@bot.command()
async def punish():
    await bot.say('http://i.imgur.com/kmIPbNY.jpg')


@bot.command()
async def fax():
    await bot.say('(((Fax Machine)))')


@bot.command()
async def penis():
    await bot.say('http://i.imgur.com/l7KloHB.jpg')


@bot.command()
async def pizzagate():
    await bot.say('http://i.imgur.com/jnc8tkc.jpg')


@bot.command()
async def weebs():
    await bot.say('http://i.imgur.com/A9sPz2o.gif')


@bot.command()
async def nicotine():
    await bot.say('http://i.imgur.com/x9Idipo.jpg')


@bot.command()
async def gay():
    await bot.say('http://i.imgur.com/ZqdK3jl.jpg')


@bot.command()
async def tilt():
    await bot.say('http://i.imgur.com/xGtsBWc.jpg')


@bot.command()
async def hotone():
    await bot.say('http://i.imgur.com/xZahfEv.png')


@bot.command()
async def tuna():
    await bot.say('http://i.imgur.com/eeg4DGP.jpg')


@bot.command()
async def drown():
    await bot.say('http://i.imgur.com/WYcUCzo.jpg')


@bot.command()
async def dicks():
    await bot.say('http://i.imgur.com/XiZZeWm.jpg')


@bot.command()
async def dump():
    await bot.say('http://i.imgur.com/YZghLbl.jpg')


@bot.command()
async def jews():
    await bot.say('http://i.imgur.com/4A6aBDM.jpg')


@bot.command()
async def hitler():
    await bot.say('http://i.imgur.com/gic3sM7.jpg')


@bot.command()
async def feminine():
    await bot.say('http://i.imgur.com/2I7EKdW.jpg')


@bot.command()
async def thirteen():
    await bot.say('http://i.imgur.com/huydyAl.jpg')


@bot.command()
async def chicken():
    await bot.say('http://i.imgur.com/MciobNd.jpg')


@bot.command()
async def bagget():
    await bot.say('http://i.imgur.com/0hohfUb.jpg')


@bot.command()
async def boop():
    await bot.say('https://i.imgur.com/R5RvCHp.gifv')


@bot.command()
async def packs():
    await bot.say('http://i.imgur.com/yBaflXc.jpg')


@bot.command()
async def elo():
    await bot.say('http://i.imgur.com/BMWTn8Z.png')


@bot.command()
async def pizza():
    await bot.say('http://i.imgur.com/7wovUjX.jpg')


@bot.command()
async def memepunchers():
    await bot.say('http://i.imgur.com/bssza8H.jpg')


@bot.command()
async def nick():
    await bot.say('http://i.imgur.com/kmNlTSV.gif')


@bot.command()
async def glans():
    await bot.say('http://i.imgur.com/AI3LOtv.mp4')

@bot.command()
async def edge():
    await bot.say('https://i.imgur.com/pT8aEZ1.jpg')

@bot.command()
async def erection():
    await bot.say('https://i.imgur.com/rQpV91e.jpg')

@bot.command()
async def chrome():
    await bot.say('https://i.imgur.com/CDoAGIf.jpg')

@bot.command()
async def robot():
    await bot.say('https://i.imgur.com/TFDE9Ib.jpg')

@bot.command()
async def gaston():
    await bot.say('https://i.imgur.com/Q5zwAdB.gif')

@bot.command()
async def seige():
    await bot.say('lern 2 spel u munkee')


'''##################################################################################################################'''
'''##################################################################################################################'''


@bot.command()
async def overwatch():
    await bot.say('<@127205495457972224> <@155772105500262400> <@158991858112921600> <@147495490492039169>'
                  ' <@135413443934027776> <@136204959459835905> <@300464634916503555> <@240561551818358786>'
                  ' <@200048220758343680> <@292119288058216450>'
                  ' THE WORLD NEEDS MORE HEROES!')


@bot.command()
async def league():
    await bot.say('<@127205495457972224> <@155772105500262400> <@158991858112921600> <@147495490492039169>'
                  ' <@135413443934027776> <@173271806285709314> <@200048220758343680> <@122910094592704516>'
                  ' <@136369720516542466> <@225088295196033024>'
                  ' TIME TO PLAY THE INFERIOR MOBA!')


@bot.command()
async def dota():
    await bot.say('<@127205495457972224> <@135413443934027776> <@300464634916503555> <@240561551818358786>'
                  ' DOTA MASTER RACE TIME!')


@bot.command()
async def uch():
    await bot.say('<@127205495457972224> <@155772105500262400> <@158991858112921600> <@147495490492039169>'
                  ' <@162006673525964800> <@240561551818358786> <@200048220758343680>'
                  ' TIME TO BE THE ULTIMATE ANIMAL!')


@bot.command()
async def diablo():
    await bot.say('<@127205495457972224> <@135413443934027776> <@136204959459835905> '
                  ' TIME TO KILL SOME DEMONS!')


@bot.command()
async def heroes():
    await bot.say('<@127205495457972224> <@155772105500262400> <@158991858112921600>'
                  ' <@135413443934027776> <@136204959459835905> <@200048220758343680>'
                  ' THE NEXUS NEEDS YOU!')


@bot.command()
async def pubg():
    await bot.say('<@127205495457972224> <@158991858112921600> <@147495490492039169>'
                  ' <@240561551818358786> <@200048220758343680> <@155772105500262400>'
                  ' <@136204959459835905> <@135413443934027776> <@173271806285709314>'
                  ' <@177249796904452096> <@300464634916503555> <@292119288058216450>'
                  ' GET READY TO RUMBLE!')

@bot.command()
async def siege():
    await bot.say('<@127205495457972224> <@135413443934027776> <@136204959459835905> <@240561551818358786>'
                  ' <@300464634916503555> <@200048220758343680> <@194860927978438656> <@155772105500262400>'
                  ' TIME TO BREACH!')

@bot.command()
async def quiplash():
    await bot.say('<@162006673525964800> <@127205495457972224> <@172487884480184320> <@155772105500262400>'
                  ' <@147495490492039169> <@172208392717336576> <@136369720516542466> <@225088295196033024>'
                  ' BRING OUT THE DAD JOKES!')


@bot.command()
async def meme(sub: str):
    await bot.say(prequelMeme(sub))


@bot.event
async def on_message(message):
    user = message.author

    binks = ['Looks to be approximately ' + str(random.randint(1, 10000)) + ' binks!',
             'My scanners detect ' + str(random.randint(1, 10000)) + ' binks!',
             'Captain, our scouts are reporting ' + str(random.randint(1, 10000)) + ' binks!',
             str(random.randint(100000, 1000000)) + ' binks! Are you sure you want to procede?',
             'I don\'t care if there\'s ' + str(random.randint(1, 1000)) + ' binks or ' + str(
                 random.randint(1000, 10000)) + '. Kill them all!',
             '... ' + str(random.randint(1, 100)) + ' binks',
             str(random.randint(10000, 100000)) + ' binks. That\'s a lot of binks!',
             str(random.randint(1, 10000)) + ' binks and counting sir!',
             str(random.randint(1, 10000)) + ' binks and plenty of twinks 😉']

    bot_response = ['Beep Boop',
                    'Bzzzt, I can hear you!',
                    '<@' + str(message.author.id) + '> BE NICE!',
                    '*cancels plans for world domination*',
                    'Hello World!']

    if message.author == bot.user:
        return

    if message.author.id == '140688682821615616':
        await bot.add_reaction(message, '🍕')

    if message.author.id == '122910094592704516':
        await bot.add_reaction(message, '🍆')

    if random.randint(1, 20) == 2:
        await bot.add_reaction(message, '🍕')

    if random.randint(1, 100) == 2:
        await bot.add_reaction(message, '🍺')

    if random.randint(1, 100) == 2:
        await bot.add_reaction(message, '🍻')

    if find_whole_word('binks')(message.content):
        await bot.send_message(message.channel, binks[random.randint(0, 8)])

    if find_whole_word('poo')(message.content):
        await bot.add_reaction(message, '💩')

    if find_whole_word('glansberg')(message.content):
        await bot.send_message(message.channel, 'Yeah fuck you <@73608637553061888>!')

    if find_whole_word('glans')(message.content):
        await bot.send_message(message.channel, 'Yeah fuck you <@73608637553061888>!')

    if find_whole_word('rustyraptor')(message.content):
        await bot.send_message(message.channel, 'Yeah fuck you <@136369720516542466>!')

    if find_whole_word('rusty')(message.content):
        await bot.send_message(message.channel, 'Yeah fuck you <@136369720516542466>!')

    if find_whole_word('freeckbot')(message.content):
        await bot.send_message(message.channel, bot_response[random.randint(0, 4)])


    await bot.process_commands(message)


bot.remove_command("help")


@bot.command()
async def help():
    await bot.say('Help yourself, asshole.')
    await bot.say('(Try !commands)')


bot.run('MjkwOTU2MDYyODQ3MTM5ODQx.C6sprw.BX_z9Ij_XEPdTo3-YvjuvwBCdws')
