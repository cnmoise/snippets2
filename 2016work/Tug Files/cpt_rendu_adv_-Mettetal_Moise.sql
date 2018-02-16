/*
------------------------------------------------------------
-------------Compte Rendu Agence de Voyage------------------
------------------------------------------------------------
-------------------MOISE Claudiu----------------------------
-----------------METTETAL Tugdual---------------------------
------------------------------------------------------------
*/

set linesize 500;
set pagesize 200;
col nomV format a20;
col numC format 999;
alter session set current_schema=agence;

/* Question 10, spécification :
	< p, num > ∈ R ⟺ pour un pays p donné le circuit de numéro num passe par toutes les ville du pays p. 
*/

prompt 'Question 10';
prompt 'Entrez un pays : '
accept pays
select numC
from LesEtapes join LesVilles on (vEtape = nomV) 
where lower(pays) = lower('&pays')
group by numC
having count(vEtape) =
(select count(nomV)
from LesVilles
where lower(pays) = lower('&pays'));

/* Tests :
Pour p = "Angleterre" on obtient 
	NUMC
	----
  	 9

Pour p = "Hollande" on obtient 
	NUMC
	----
	   3
	   4

pour p = "Italie" on obtient no row selected.
*/

--------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------

/* Question 11, spécification :
	< d, num, px, dt, disp > ∈ R2 ⟺ pour une durée d (en nombre de jours) donnée, il reste pour le circuit de numéro num, de prix px,
									partant à la date dt, un nombre de place disponibles disp.
*/

prompt 'Question 11';
prompt Entrez une duree :
accept duree 
select numC,prix,dateDep,nbPlaces - nbRes as PlacesDispo
from (select numC,sum(nbJours) as d
from LesEtapes
group by numC) natural join LesCircuits natural join LesProgrammations natural join LesReservations
where d<= '&duree' and (nbPlaces- nbRes) <> 0
order by numC;

/* Tests :
Pour d = 30 on obtient 
NUMC       PRIX DATEDEP   PLACESDISPO
---- ---------- --------- -----------
   1       1160 04-FEB-10           8
   2       1160 07-JAN-10           9
   3       1040 03-JUL-10           1
   4       1270 30-JUN-10          11
   5       2740 06-NOV-10           3
   5       2740 31-AUG-10          64
   7       2500 16-DEC-09           1
   8       2140 16-FEB-10          11
   8       2140 28-FEB-10           4
   9       5700 30-OCT-10          21
  10       6170 01-JAN-10          78
  10       6170 11-FEB-10          28
  12       6170 06-FEB-10         112
  12       6170 06-FEB-10         189
  13      18590 31-DEC-09          46
  13      18590 31-DEC-09           8
  13      18590 01-JAN-10          63
  13      18590 01-JAN-10          63
  14       7700 26-JUL-10           4
  18       6690 06-DEC-10           1
  19      10400 15-APR-10          25
  21      15000 15-JAN-10          56
  21      15000 15-JAN-10          52

23 rows selected.
Pour d = -1 on obtient no row selected.
*/

---------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------

/* Question 13, spécification :
	< num, datdep, p, datEnt > ∈ R3 ⟺ La programmation de la date datdep du cicuit de numéro num arrive dans le pays p à 
										la date datEnt.
*/

prompt 'Question 13';

-- tables pour la sous requete
create or replace view mettetat.tab as
select numC,dateDep, rang, pays, nbJours
from 
agence.LesProgrammations natural join agence.LesCircuits join agence.LesVilles on (vDep = nomV) natural join agence.LesEtapes
order by numC, dateDep, rang; 
;

create or replace view mettetat.somme as
select numC, dateDep, rang, nbJours, somme
from
(select a.numC, a.dateDep, a.rang, sum(b.nbJours) as somme
from mettetat.tab a join mettetat.tab b on (a.numC = b.numC and a.dateDep = b.dateDep)
where a.rang >= b.rang
group by a.numC, a.dateDep, a.rang) natural join mettetat.tab
order by numC, dateDep, rang;


/* sous requete 1 pour afficher la date d'entree au rang 1 pour chaque circuits
< num, datdep, p, datEnt > ∈ R3 ⟺ La programmation de la date datdep du cicuit de numéro num arrive dans le pays p à 
							la date datEnt pour le rang 1.
*/
/*
select numC, dateDep, pays, dateDep as dateEntree
from LesProgrammations natural join LesEtapes join LesVilles on (vEtape = nomV)
where rang = 1
*/

/*sous requete 2 qui permet de recuperer la date d'entree dans un nouveau pays pour un numero circuits pour chaque rang ou il change
< num, datdep, rg, p, datEnt > ∈ R3 ⟺ La programmation de la date datdep du cicuit de numéro num arrive dans le pays p à 
										la date datEnt pour chaque rang rg ou il change de pays p a partir de rg +1 pour chaque num.
*/
/*
select numC, dateDep, rang, pays, somme + dateDep
from(
select c1.numC, c1.dateDep, c1.rang, c1.pays
from 
(select numC, dateDep, rang, pays
from LesEtapes e1 join LesVilles v1 on (e1.vEtape = v1.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c1
join
(select numC, dateDep, rang, pays
from LesEtapes e2 join LesVilles v2 on (e2.vEtape = v2.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c2 on (c1.rang = c2.rang +1) 
where c1.pays <> c2.pays and c1.numC = c2.numC
group by c1.numC, c1.dateDep, c1.rang, c1.pays) natural join mettetat.somme
order by numC, dateDep;
*/


/*sous requete 3 qui permet d'afficher le numero de circuit la date d'entree le pays le rang et la date a laquelle on change de pays pour tous les rangs a partir de la sous requete 2
< num, datdep, p, rg, datEnt > ∈ R3 ⟺ La programmation de la date datdep du cicuit de numéro num arrive dans le pays p à 
										la date datEnt pour tout les rangs rg.
*/
/*
select t1.numC, t1.dateDep, t1.pays, t1.rang, t1.dateDep, t2.dateEntree from
(select numC, dateDep, rang, pays
from LesProgrammations natural join LesEtapes join LesVilles on (vEtape = nomV)
order by numC, dateDep, rang) t1
full join
(select numC, dateDep, rang, pays, somme + dateDep as dateEntree
from(
select c1.numC, c1.dateDep, c1.rang, c1.pays
from 
(select numC, dateDep, rang, pays
from LesEtapes e1 join LesVilles v1 on (e1.vEtape = v1.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c1
join
(select numC, dateDep, rang, pays
from LesEtapes e2 join LesVilles v2 on (e2.vEtape = v2.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c2 on (c1.rang = c2.rang +1) 
where c1.pays <> c2.pays and c1.numC = c2.numC
group by c1.numC, c1.dateDep, c1.rang, c1.pays) natural join mettetat.somme) t2 on (t1.numC = t2.numC and t1.dateDep = t2.dateDep and t1.pays = t2.pays)
order by t1.numC, t1.dateDep, t1.rang, t2.dateEntree;
*/

/* sous requete 4 basee sour la sous requete 3 permettant de recuperer uniquement les dates ou l'on change de pays pour tous les circuits pour tous les rangs
< num, datdep, p, datEnt > ∈ R3 ⟺ La programmation de la date datdep du cicuit de numéro num arrive dans le pays p à 
										la date datEnt pour le rang rg ou il entre dans ce pays et pout tout les rangs suivants tant que le pays reste le même
										ou que le circuit n'est pas terminé.
*/
/*
select t1.numC as numC, t1.dateDep as dateDep, t1.pays as pays, t2.dateEntree as dateEntree
from
(select numC, dateDep, rang, pays
from LesProgrammations natural join LesEtapes join LesVilles on (vEtape = nomV)
order by numC, dateDep, rang) t1
full join
(select numC, dateDep, rang, pays, somme + dateDep as dateEntree
from(
select c1.numC, c1.dateDep, c1.rang, c1.pays
from 
(select numC, dateDep, rang, pays
from LesEtapes e1 join LesVilles v1 on (e1.vEtape = v1.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c1
join
(select numC, dateDep, rang, pays
from LesEtapes e2 join LesVilles v2 on (e2.vEtape = v2.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c2 on (c1.rang = c2.rang +1) 
where c1.pays <> c2.pays and c1.numC = c2.numC
group by c1.numC, c1.dateDep, c1.rang, c1.pays) natural join mettetat.somme) t2 on (t1.numC = t2.numC and t1.dateDep = t2.dateDep and t1.pays = t2.pays) 
where t2.dateEntree is not NULL 
order by numC, dateDep, dateEntree;
*/


-- requete finale sous requete 1 union sous requete 4 qui permet d'afficher la date d'entree dans un nouveau pays ainsi que la date de depart pour le rang 1 
/* Question 13, spécification :
	< num, datdep, p, datEnt > ∈ R3 ⟺ La programmation de la date datdep du cicuit de numéro num arrive dans le pays p à 
										la date datEnt.
*/
select numC, dateDep, pays, dateDep as dateEntree
from LesProgrammations natural join LesEtapes join LesVilles on (vEtape = nomV)
where rang = 1
union
select t1.numC as numC, t1.dateDep as dateDep, t1.pays as pays, t2.dateEntree as dateEntree
from
(select numC, dateDep, rang, pays
from LesProgrammations natural join LesEtapes join LesVilles on (vEtape = nomV)
order by numC, dateDep, rang) t1
full join
(select numC, dateDep, rang, pays, somme + dateDep as dateEntree
from(
select c1.numC, c1.dateDep, c1.rang, c1.pays
from 
(select numC, dateDep, rang, pays
from LesEtapes e1 join LesVilles v1 on (e1.vEtape = v1.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c1
join
(select numC, dateDep, rang, pays
from LesEtapes e2 join LesVilles v2 on (e2.vEtape = v2.nomV) natural join lesProgrammations
group by numC, dateDep, rang, pays) c2 on (c1.rang = c2.rang +1) 
where c1.pays <> c2.pays and c1.numC = c2.numC
group by c1.numC, c1.dateDep, c1.rang, c1.pays) natural join mettetat.somme) t2 on (t1.numC = t2.numC and t1.dateDep = t2.dateDep and t1.pays = t2.pays) 
where t2.dateEntree is not NULL 
order by numC, dateDep, dateEntree;

---------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------


/* Question 14, spécification :
	< num, ct, moy > ∈ R4 ⟺ Le circuit de numéro num a un cout total ct et un taux moyen de remplissage moy.
*/

prompt 'Question 14';
select numC, cout, moy
from
(select numC, avg(taux) as moy
from
(select t2.numC, t2.dateDep, nvl(res / nbPlaces *100, 0) as taux
from
(select numC, dateDep, sum(nbRes) as res
from LesReservations
group by numC, dateDep ) t1
full join
(select numC, dateDep, nbPlaces
from LesProgrammations) t2 on (t1.numC = t2.numC and t1.dateDep = t2.dateDep))
group by numC)
natural join
(select numC, s1+s2 as cout
from
(select numC, nvl(sum(prix),0) as s1
from LesReservations natural join LesEtapes left join LesMonuments on (vEtape = nomV)
group by numC)
natural join
(select numC, sum(prix) as s2
from LesCircuits
group by numC))
order by numC;

