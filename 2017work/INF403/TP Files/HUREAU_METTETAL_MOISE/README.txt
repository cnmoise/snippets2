La connection a la base de donn�s �tant faite avec le profil utilisateur enregistr�, 
il faut executer bdd.sql sur son profil avant tout utilisation du site, sinon il ne fonctionne pas
Il est pr�f�rable d'utiliser une navigateur (dans l'ordre) tel que Chrome, chromium, opera ou encore edge..
(SI vous souhaitez n�anmoins utilisez mozilla, voici le format pour la date : YYYY-MM-DD)

Nous n'avons pas finis la partie g�rer les reservations a cause d'un manque de temps, nous avons vu
trop gros (g�rer les places interactivement pas exemple) ce qui nous a pas laiss� le temps de
finir l'inssert des tickets, qui est pourtant tres simble, la proc�dure warning dans reserver.php
aurait servis a executer un rollback si un place avait �tait reserv� entre temps.

M�me si nous avons perdu du temps, la partie "graphique" des reservations est totalement modulable, nous en sommes fiere.
De plus, nous avons �cris une requiete SQL qui maleheuresement n'est pas int�gr� au site : 
C'est savoir quels sont les places qui, pour un nombre donn�s, on  un certain nombre de place cote a cote.

Le code de la requete est fourniess, les variables a modifier sont 
- Ligne 2 : "nospec = 2"; modifier 2 afin de choisir les nospectacle voulu
- Ligne 2 : '07-MAR-17' a remplac� par la date du spectacle en question
- Ligne 12 "(r3.noplace - R1.noplace > 11)" remplac� la partie '>11' par la condition voulue 
(= x OU >= x OU <= x OU < x .... x etant le nombre de place cote � cote)

Bonne lecture / correction