La connection a la base de donnés étant faite avec le profil utilisateur enregistré, 
il faut executer bdd.sql sur son profil avant tout utilisation du site, sinon il ne fonctionne pas
Il est préférable d'utiliser une navigateur (dans l'ordre) tel que Chrome, chromium, opera ou encore edge..
(SI vous souhaitez néanmoins utilisez mozilla, voici le format pour la date : YYYY-MM-DD)

Nous n'avons pas finis la partie gérer les reservations a cause d'un manque de temps, nous avons vu
trop gros (gérer les places interactivement pas exemple) ce qui nous a pas laissé le temps de
finir l'inssert des tickets, qui est pourtant tres simble, la procédure warning dans reserver.php
aurait servis a executer un rollback si un place avait était reservé entre temps.

Même si nous avons perdu du temps, la partie "graphique" des reservations est totalement modulable, nous en sommes fiere.
De plus, nous avons écris une requiete SQL qui maleheuresement n'est pas intégré au site : 
C'est savoir quels sont les places qui, pour un nombre donnès, on  un certain nombre de place cote a cote.

Le code de la requete est fourniess, les variables a modifier sont 
- Ligne 2 : "nospec = 2"; modifier 2 afin de choisir les nospectacle voulu
- Ligne 2 : '07-MAR-17' a remplacé par la date du spectacle en question
- Ligne 12 "(r3.noplace - R1.noplace > 11)" remplacé la partie '>11' par la condition voulue 
(= x OU >= x OU <= x OU < x .... x etant le nombre de place cote à cote)

Bonne lecture / correction