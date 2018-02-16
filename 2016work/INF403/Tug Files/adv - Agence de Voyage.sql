--Agence de Voyage--



/* ∈ 
prompt 'Question 1';
prompt 'Taper la date désirée :';
accept d;
select numC, vDep, vArr from LesCircuits natural join LesProgrammations
where dateDep > to_date('&d', 'DD/MM/YY');
*/


/*
prompt 'Question 2';
select nomC from LesReservations
minus
(select nomC from LesReservations R join LesEtapes E on (R.numC = E.numC) join LesMonuments M on (M.nomV = E.vEtape));
*/

/*
prompt 'Question 3';
select numC, sum(nbJours), prix
from LesCircuits natural join LesEtapes
where numC not in (select numC from LesReservations)
group by numC, prix
order by numC;
*/

/*
prompt 'Question 4':
accept nom;
prompt 'Taper un nom : ';
select vEtape
from LesReservations natural join LesEtapes
where nomC = '&nom';
*/

/*
prompt 'Question 5';
prompt 'Taper un nom : ';
accept nom;
select vEtape,nomM
from (select vEtape
from LesReservations natural join LesEtapes
where nomC = '&nom') join LesMonuments on (vEtape = nomV)
order by vEtape;
*/

/*
prompt 'Question 6';
prompt 'Taper un nom : ';
accept nom;
select vEtape,count(nomM)
from (select vEtape
from LesReservations natural join LesEtapes
where nomC = '&nom') left join LesMonuments on (vEtape = nomV)
group by vEtape
order by vEtape;
*/

/*
prompt 'Question 7';
prompt 'Taper un nom : ';
accept nom;
select vEtape,sum(prix)
from (select vEtape
from LesReservations natural join LesEtapes
where nomC = '&nom') join LesMonuments on (vEtape = nomV)
group by vEtape
order by vEtape;
*/

/*
prompt 'Question 8';
prompt 'Entrez un pays : ';
accept pays;
select distinct nomC
from LesReservations natural join LesEtapes join LesVilles on (vEtape = nomV)
where pays = '&pays';
*/

/*
prompt 'Question 9';
prompt 'Entrez un nom : '
accept nom
select pays,vEtape,nomM
from (select vEtape
from LesReservations natural join LesEtapes
where nomC = '&nom') left join LesMonuments on (vEtape = nomV) natural join LesVilles
order by pays;
*/

/*
prompt 'Question 10';
accept pays
prompt 'Entrez un pays : '
select numC
from LesEtapes join LesVilles on (vEtape = nomV) 
where lower(pays) = lower('&pays')
group by numC
having count(vEtape) =
(select count(nomV)
from LesVilles
where lower(pays) = lower('&pays'));
*/

/*
prompt 'Question 11';
prompt Entrez une duree :
accept duree 
select numC,prix,dateDep,nbPlaces - nbRes as PlacesDispo
from (select numC,sum(nbJours) as d
from LesEtapes
group by numC) natural join LesCircuits natural join LesProgrammations natural join LesReservations
where d<= '&duree' and (nbPlaces- nbRes) <> 0
order by numC;
*/

/*
On fait la liste des circuits avec leurs duree, puis dans cette liste on cherche ceux ayant une duree
 inferieure ou egale a celle donnee et pour cela on cherche les infos restantes*/
/*
prompt 'Question 12';

------Version sans prise en compte des villes de depart et d'arrivee------

select distinct numC,pays
from(
	select numC, count(numC) as c
	from (
		select distinct numC, pays
		from LesEtapes natural join LesEtapes join LesVilles on (vEtape = nomV))
	group by numC)
natural join LesEtapes join LesVilles on (vEtape=nomV)
where c = 1
order by numC;


-------------------------
------Version avec-------
-------------------------


(select distinct numC,pays
from(
	select numC, count(numC) as c
	from (
		select distinct numC, pays
		from LesEtapes natural join LesEtapes join LesVilles on (vEtape = nomV))
	group by numC)
natural join LesEtapes join LesVilles on (vEtape=nomV)
where c = 1)
intersect
(select numC, pays
from LesCircuits join LesVilles on (vDep = nomV)
minus
(select numC, pays
from LesCircuits join LesVilles on (vDep=nomV)
minus
select numC, pays
from LesCircuits join LesVilles on (vArr=nomV)))
;
*/

/*
------------------------------------------------------------------------------
------------------------------------------------------------------------------
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

-- sous requete 1 pour afficher la date d'entree au rang 1 pour chaque circuits
/*
select numC, dateDep, pays, dateDep as dateEntree
from LesProgrammations natural join LesEtapes join LesVilles on (vEtape = nomV)
where rang = 1
*/

--sous requete 2 qui permet de recuperer la date d'entree dans un nouveau pays pour un numero circuits pour chaque rang ou il change
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


--sous requete 3 qui permet d'afficher le numero de circuit la date d'entree le pays le rang et la date a laquelle on change de pays pour tous les rangs a partir de la sous requete 2
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

-- sous requete 4 basee sour la sous requete 3 permettant de recuperer uniquement les dates ou l'on change de pays pour tous les circuits pour tous les rangs
/*
select t1.numC, t1.dateDep , t1.pays, t1.rang, t2.dateEntree
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
order by t1.numC, t1.dateDep, t1.rang, t2.dateEntree;
*/


-- requete finale sous requete 1 union sous requete 4 qui permet d'afficher la date d'entree dans un nouveau pays ainsi que la date de depart pour le rang 1 

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



