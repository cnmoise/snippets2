alter session set current_schema=repas;

--1. Pour la personne invitée le plus souvent donner son nom ainsi que ses plats préférés
--select nomI, nomP
--from 
--(select nomI
--from LesRepas
--group by nomI
--having count(dateR) = (select max(count(dateR))
--       		       from LesRepas
--		       group by nomI)
--) join LesPreferences on (nomI = nomA);

--2. A chaque date ou un repas est organise, donner l'invite qui apprecie le plus grande nombre de plats
--select R1.dateR, R1.nomI
--from
--(
--(select dateR, nomI, count(P.nomP) nbPA
--from LesRepas natural join LeMenu M 
--join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
--group by dateR, nomI)
--union
--(select dateR, nomI, 0
--from LesRepas
--where dateR not in (select dateR
--from LesRepas natural join LeMenu M 
--join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
--group by dateR, nomI)
--)
--) R1
--join 
--(
--select dateR, max(nbPA) mnbPA
--from
--(
--(select dateR, nomI, count(P.nomP) nbPA
--from LesRepas natural join LeMenu M 
--join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
--group by dateR, nomI)
--union
--(select dateR, nomI, 0
--from LesRepas
--where dateR not in (select dateR
--from LesRepas natural join LeMenu M 
--join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
--group by dateR, nomI)
--)
--)
--group by dateR
--) R2 on (R1.dateR = R2.dateR and R1.nbPA = R2.mnbPA);

--3. A chaque date ou un repas est organise donner le nombre d'invites aui est servi au moins un des plats de ses preferences 
--select dateR, count(nomI)
--from
--(
--select dateR, nomI, count(P.nomP) nbPA
--from LesRepas natural join LeMenu M 
--join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
--group by dateR, nomI
--)
--group by dateR
--union
--(select dateR, 0
--from LesRepas
--where dateR not in (select dateR
--      	    	   from LesRepas natural join LeMenu M 
--		   join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
--		   group by dateR, nomI
--		   ));

--4. Donner les noms des amis qui aiment tous els types de plats, cad au moins un plat de chaque type

--select nomA
--from LesPreferences natural join LesPlats
--group by nomA
--having count(distinct typeP) = (select count(distinct typeP) from LesPlats);

--5. Donner pour chaque mois ou au moins n repas a ete organise, le nombre d'invites

--select  to_char(dateR, 'MON-YYYY'), count(distinct nomI)
--from LesRepas
--group by to_char(dateR, 'MON-YYYY');

--6. Donner pour chaque plat, le vin qui l'accompagne le plus souvent, et le nombre de fois que ce vin accompagne ce plat
--select R1.nomP, R1.nomV, R1.nbocc
--from
--(
--select nomP, nomV, count(dateR) as nbocc
--from LeMenu
--group by nomP, nomV
--) R1
--join
--(
--select nomP, max(nbocc) as mnbocc
--from
--(
--select nomP, nomV, count(dateR) as nbocc
--from LeMenu
--group by nomP, nomV
--)
--group by nomP
--) R2 on (R1.nomP = R2.nomP and R1.nbocc = R2.mnbocc);

--7. Donner pour chaque personne (amie et/ou invitee) son nom, le nombre de fois qu'elle a ete invitee, le nombre de plats qu'elle aprecie, et le nombre de types de plats quelle apprecie

--select nomI, nbinv, nbpa, nbtpa
--from
--(select nomI, count(dateR) nbinv
--from LesRepas
--group by nomI) 
--join 
--(select nomA, count(nomP) nbpa, count(distinct typeP) nbtpa
--from LesPreferences natural join LesPlats
--group by nomA) 
--on (nomI = nomA);



